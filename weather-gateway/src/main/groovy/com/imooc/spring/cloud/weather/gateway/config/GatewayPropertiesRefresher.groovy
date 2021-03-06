package com.imooc.spring.cloud.weather.gateway.config

import com.ctrip.framework.apollo.enums.PropertyChangeType
import com.ctrip.framework.apollo.model.ConfigChangeEvent
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.BeansException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.context.environment.EnvironmentChangeEvent
import org.springframework.cloud.gateway.config.GatewayProperties
import org.springframework.cloud.gateway.event.RefreshRoutesEvent
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.ApplicationEventPublisherAware
import org.springframework.stereotype.Component

/**
 * 集成Apollo实现网关的动态路由
 * 监听网关配置修改，刷新网关路由
 *
 * @author ksewen* @date 2019/5/175:24 PM
 */
@Component
class GatewayPropertiesRefresher implements ApplicationContextAware, ApplicationEventPublisherAware {

    private static final Logger logger = LoggerFactory.getLogger(GatewayPropertiesRefresher.class)
    private static final String ID_PATTERN = "spring\\.cloud\\.gateway\\.routes\\[\\d+\\]\\.id"
    private static final String DEFAULT_FILTER_PATTERN = "spring\\.cloud\\.gateway\\.default-filters\\[\\d+\\]\\.name"

    private ApplicationContext applicationContext
    private ApplicationEventPublisher publisher

    @Autowired
    private GatewayProperties gatewayProperties

    @Override
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext
    }


    @Override
    void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher
    }

    @ApolloConfigChangeListener(interestedKeyPrefixes = "spring.cloud.gateway.")
    void onChange(ConfigChangeEvent changeEvent) {
        refreshGatewayProperties(changeEvent)
    }

    /***
     * 刷新org.springframework.cloud.gateway.config.PropertiesRouteDefinitionLocator中定义的routes
     *
     * @author ksewen* @date 2019/5/21 2:13 PM
     */
    private void refreshGatewayProperties(ConfigChangeEvent changeEvent) {
        logger.info("Refreshing GatewayProperties!")
        preDestroyGatewayProperties(changeEvent)
        this.applicationContext.publishEvent(new EnvironmentChangeEvent(changeEvent.changedKeys()))
        refreshGatewayRouteDefinition()
        logger.info("GatewayProperties refreshed!")
    }

    /***
     * GatewayProperties没有@PreDestroy和destroy方法
     * org.springframework.cloud.context.properties.ConfigurationPropertiesRebinder#rebind(java.lang.String)中destroyBean时不会销毁当前对象
     * 如果把spring.cloud.gateway.前缀的配置项全部删除（例如需要动态删除最后一个路由的场景），initializeBean时也无法创建新的bean，则return当前bean
     * 若仍保留有spring.cloud.gateway.routes[n]或spring.cloud.gateway.default-filters[n]等配置，initializeBean时会注入新的属性替换已有的bean
     * 这个方法提供了类似@PreDestroy的操作，根据配置文件的实际情况把org.springframework.cloud.gateway.config.GatewayProperties#routes
     * 和org.springframework.cloud.gateway.config.GatewayProperties#defaultFilters两个集合清空
     *
     * @author ksewen* @date 2019/5/21 2:13 PM
     */
    private synchronized void preDestroyGatewayProperties(ConfigChangeEvent changeEvent) {
        logger.info("Pre Destroy GatewayProperties!")
        final boolean needClearRoutes = this.checkNeedClear(changeEvent, ID_PATTERN)
        if (needClearRoutes) {
            this.gatewayProperties.getRoutes().clear()
        }
        final boolean needClearDefaultFilters = this.checkNeedClear(changeEvent, DEFAULT_FILTER_PATTERN)
        if (needClearDefaultFilters) {
            this.gatewayProperties.getDefaultFilters().clear()
        }
        logger.info("Pre Destroy GatewayProperties finished!")
    }

    private void refreshGatewayRouteDefinition() {
        logger.info("Refreshing Gateway RouteDefinition!")
        this.publisher.publishEvent(new RefreshRoutesEvent(this))
        logger.info("Gateway RouteDefinition refreshed!")
    }

    /***
     * 根据changeEvent和定义的pattern匹配key，如果所有对应PropertyChangeType为DELETED则需要清空GatewayProperties里相关集合
     *
     * @param changeEvent
     * @param pattern
     * @return boolean* @author ksewen* @date 2019/5/23 2:18 PM
     */
    private boolean checkNeedClear(ConfigChangeEvent changeEvent, String pattern) {
        Set<String> changedKeySet = changeEvent.changedKeys().findAll { it.matches(pattern) }
        return changedKeySet.any { (PropertyChangeType.DELETED == changeEvent.getChange(it)?.changeType) }
    }
}
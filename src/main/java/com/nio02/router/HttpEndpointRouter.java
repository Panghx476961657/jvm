package com.nio02.router;

import java.util.List;

/**
 * 微服务先根据uri匹配服务，再根据注册服务列表进行路由
 * <p>
 * 随机路由
 * IP hash路由
 * 负载均衡（平均分配）
 */
public interface HttpEndpointRouter {

    String route(List<String> endpoints);

    // Load Balance
    // Random
    // RoundRibbon 
    // Weight
    // - server01,20
    // - server02,30
    // - server03,50

}

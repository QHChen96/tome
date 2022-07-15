package com.khetao.tome.gateway.custom;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.web.server.ServerWebExchange;

import java.util.function.Predicate;

/**
 * @author chenqinhao 2022/7/14
 * @email qhchen96@gmail.com
 */
public class TagPredicateFactory extends AbstractRoutePredicateFactory {

    public TagPredicateFactory(Class configClass) {
        super(configClass);
    }



    @Override
    public Predicate<ServerWebExchange> apply(Object config) {
        return null;
    }
}

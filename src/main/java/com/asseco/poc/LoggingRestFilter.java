package com.asseco.poc;

import io.micronaut.core.order.Ordered;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.annotation.RequestFilter;
import io.micronaut.http.annotation.ResponseFilter;
import io.micronaut.http.annotation.ServerFilter;
import io.micronaut.http.filter.ServerFilterPhase;
import lombok.extern.slf4j.Slf4j;

@ServerFilter(Filter.MATCH_ALL_PATTERN)
@Slf4j
public class LoggingRestFilter implements Ordered {

    @RequestFilter 
    void filterRequest(HttpRequest<?> request) {
        log.trace("{}: {}", request.getMethod(), request.getPath());
        log.trace("body: {}", request.getBody());
//        HttpHeadersUtil.trace(log, request.getHeaders());
    }

    @ResponseFilter
    void filterResponse(HttpResponse<?> response) {
        log.trace("response: {}", response.getStatus());
        log.trace("body: {}", response.getBody());
    }
    
    @Override
    public int getOrder() { 
        return ServerFilterPhase.FIRST.order();
    }
    
}

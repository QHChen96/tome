package com.khetao.tome.loadbalancer.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 将这个feign经过得实例的header携带下去
 * @author chenqinhao 2022/8/1
 * @email qhchen96@gmail.com
 */
@RequiredArgsConstructor
@Slf4j
public class ColorationHeaderInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        String headerName = null;
        // 将header透传到下一个服务
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                headerName = headerNames.nextElement();
                requestTemplate.header(headerName, request.getHeader(headerName));
            }
        }
    }
}

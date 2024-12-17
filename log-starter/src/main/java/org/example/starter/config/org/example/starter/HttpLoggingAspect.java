package org.example.starter.config.org.example.starter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.example.starter.config.LogProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class HttpLoggingAspect {

    private final LogProperties logProperties;
    private static final Logger logger = LoggerFactory.getLogger(HttpLoggingAspect.class);

    public HttpLoggingAspect(LogProperties logProperties) {
        this.logProperties = logProperties;
    }

    @Before("@within(org.springframework.web.bind.annotation.RestController) || @within(org.springframework.stereotype.Controller)")
    public void logBeforeRequest(JoinPoint jp) {
        if ("INFO".equalsIgnoreCase(logProperties.getLevel())) {
            logger.info("HTTP REQUEST: {}", jp.getSignature().getName());
        }
        if ("DEBUG".equalsIgnoreCase(logProperties.getLevel())) {
            logger.info("HTTP REQUEST: {}", jp.getSignature());
        }
    }

    @AfterReturning(pointcut = "@within(org.springframework.web.bind.annotation.RestController) || @within(org.springframework.stereotype.Controller)", returning = "response")
    public void logAfterResponse(JoinPoint jp, Object response) {
        if ("INFO".equalsIgnoreCase(logProperties.getLevel())) {
            logger.info("HTTP RESPONSE for {}", jp.getSignature().getName());
        }
        if ("DEBUG".equalsIgnoreCase(logProperties.getLevel())) {
            logger.info("HTTP RESPONSE for {}: {}", jp.getSignature(), response);
        }
    }
}
package com.khetao.tome.web.task;

import org.springframework.core.task.TaskDecorator;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * 线程上下文信息复制
 * @author chenqinhao 2022/7/3
 * @email qhchen96@gmail.com
 */
public class ContextCopyingDecorator implements TaskDecorator {


    @Override
    public Runnable decorate(Runnable runnable) {
        RequestAttributes context = RequestContextHolder.currentRequestAttributes();
        return () -> {
            try {
                RequestContextHolder.setRequestAttributes(context);
            } finally {
                RequestContextHolder.resetRequestAttributes();
            }
        };
    }
}

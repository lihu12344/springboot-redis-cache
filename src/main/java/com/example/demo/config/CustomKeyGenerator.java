package com.example.demo.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component("keyGenerator")
public class CustomKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object o, Method method, Object... objects) {
        StringBuilder builder=new StringBuilder();
        builder.append(o.getClass().getName()).append("::").append(method.getName());

        for(Object object:objects) {
            builder.append(":").append(object.toString());
        }
        return builder;
    }
}

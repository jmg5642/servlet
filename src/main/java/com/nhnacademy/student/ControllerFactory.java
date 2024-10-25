package com.nhnacademy.student;

import com.nhnacademy.student.Controller.RequestMapping;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ControllerFactory  {
    private final ConcurrentMap<String, Object> beanMap = new ConcurrentHashMap<>();

    public void init(Set<Class<?>> c){
        //todo beanMap에 key = method + servletPath, value = Controller instance
        for (Class<?> clazz : c) {
            if (clazz.isAnnotationPresent(RequestMapping.class)) {
                RequestMapping mapping = clazz.getAnnotation(RequestMapping.class);
                String key = mapping.method() + mapping.value();

                try {
                    Object instance = clazz.getDeclaredConstructor().newInstance();
                    beanMap.put(key, instance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public Object getBean(String method, String path){
        //todo beanMap 에서 method+servletPath을 key로 이용하여 Controller instance를 반환합니다.
        String key = method + path;
        return beanMap.get(key);
    }
}
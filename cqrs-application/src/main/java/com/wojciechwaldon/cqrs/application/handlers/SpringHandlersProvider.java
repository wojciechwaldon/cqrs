package com.wojciechwaldon.cqrs.application.handlers;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.type.MethodMetadata;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
abstract class SpringHandlersProvider implements ApplicationListener<ContextRefreshedEvent> {

    @NonNull
    ConfigurableListableBeanFactory beanFactory;

    Map<Class<?>, String> handlers = new HashMap<Class<?>, String>();

    public void onApplicationEvent(ContextRefreshedEvent event) {
        handlers.clear();
        String[] handlerNames = beanFactory.getBeanNamesForType(getHandlerClass());
        for (String beanName : handlerNames) {
            BeanDefinition handler = beanFactory.getBeanDefinition(beanName);
            try {
                String className = null;
                className = getClassName(handler, className);
                Class<?> handlerClass = Class.forName(className);
                handlers.put(getHandledType(handlerClass), beanName);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    abstract Class<?> getHandlerClass();

    private String getClassName(BeanDefinition handler, String className) {
        if (handler instanceof AnnotatedBeanDefinition) {
            MethodMetadata factoryMethodMetadata = ((AnnotatedBeanDefinition) handler).getFactoryMethodMetadata();
            if (factoryMethodMetadata != null) {
                className = factoryMethodMetadata.getReturnTypeName();
            }
        } else {
            className = handler.getBeanClassName();
        }
        return className;
    }

    private Class<?> getHandledType(Class<?> clazz) {
        Type[] genericInterfaces = clazz.getGenericInterfaces();
        ParameterizedType type = findByRawType(genericInterfaces, getHandlerClass());
        return (Class<?>) type.getActualTypeArguments()[0];
    }

    private ParameterizedType findByRawType(Type[] genericInterfaces, Class<?> expectedRawType) {
        for (Type type : genericInterfaces) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parametrized = (ParameterizedType) type;
                if (expectedRawType.equals(parametrized.getRawType())) {
                    return parametrized;
                }
            }
        }
        throw new RuntimeException();
    }
}


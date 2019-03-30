package com.wojciechwaldon.cqrs.application.handlers;

import com.wojciechwaldon.cqrs.api.query.Query;
import com.wojciechwaldon.cqrs.api.query.QueryHandler;
import com.wojciechwaldon.cqrs.api.query.QueryView;
import lombok.NonNull;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;


public class SpringQueryHandlersProvider extends SpringHandlersProvider implements QueryHandlersProvider {

    public SpringQueryHandlersProvider(@NonNull ConfigurableListableBeanFactory beanFactory) {
        super(beanFactory);
    }

    @SuppressWarnings("unchecked")
    public QueryHandler<Query, QueryView> getHandler(Query query) {
        String beanName = handlers.get(query.getClass());
        if (beanName == null) {
            throw new RuntimeException("Query handler not found. Query class is " + query.getClass());
        }
        return beanFactory.getBean(beanName, QueryHandler.class);
    }

    Class<?> getHandlerClass() {
        return QueryHandler.class;
    }
}


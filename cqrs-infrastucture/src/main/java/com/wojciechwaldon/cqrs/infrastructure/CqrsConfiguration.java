package com.wojciechwaldon.cqrs.infrastructure;

import com.wojciechwaldon.cqrs.api.command.CommandExecutor;
import com.wojciechwaldon.cqrs.api.query.QueryExecutor;
import com.wojciechwaldon.cqrs.application.command.SpringCommandExecutor;
import com.wojciechwaldon.cqrs.application.handlers.CommandHandlersProvider;
import com.wojciechwaldon.cqrs.application.handlers.QueryHandlersProvider;
import com.wojciechwaldon.cqrs.application.handlers.SpringCommandHandlersProvider;
import com.wojciechwaldon.cqrs.application.handlers.SpringQueryHandlersProvider;
import com.wojciechwaldon.cqrs.application.query.SpringQueryExecutor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CqrsConfiguration {

    @Bean
    QueryHandlersProvider queryHandlersProvider(ConfigurableListableBeanFactory beanFactory) {
        return new SpringQueryHandlersProvider(beanFactory);
    }

    @Bean
    CommandHandlersProvider commandHandlersProvider(ConfigurableListableBeanFactory beanFactory) {
        return new SpringCommandHandlersProvider(beanFactory);
    }

    @Bean
    CommandExecutor commandExecutor(CommandHandlersProvider commandHandlersProvider) {
        return new SpringCommandExecutor(commandHandlersProvider);
    }

    @Bean
    QueryExecutor queryExecutor(QueryHandlersProvider queryHandlersProvider) {
        return new SpringQueryExecutor(queryHandlersProvider);
    }
}

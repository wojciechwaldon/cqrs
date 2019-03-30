package com.wojciechwaldon.cqrs.application.handlers;

import com.wojciechwaldon.cqrs.api.command.Command;
import com.wojciechwaldon.cqrs.api.command.CommandHandler;
import lombok.NonNull;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;


public class SpringCommandHandlersProvider extends SpringHandlersProvider implements CommandHandlersProvider {

    public SpringCommandHandlersProvider(@NonNull ConfigurableListableBeanFactory beanFactory) {
        super(beanFactory);
    }

    @SuppressWarnings("unchecked")
    public CommandHandler<Command> getHandler(Command command) {
        String beanName = handlers.get(command.getClass());
        if (beanName == null) {
            throw new RuntimeException("Command handler not found. Command class is " + command.getClass());
        }
        return beanFactory.getBean(beanName, CommandHandler.class);
    }

    Class<?> getHandlerClass() {
        return CommandHandler.class;
    }
}


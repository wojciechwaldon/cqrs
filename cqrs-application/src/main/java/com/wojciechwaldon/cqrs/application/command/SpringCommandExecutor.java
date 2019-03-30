package com.wojciechwaldon.cqrs.application.command;

import com.wojciechwaldon.cqrs.api.command.Command;
import com.wojciechwaldon.cqrs.api.command.CommandExecutor;
import com.wojciechwaldon.cqrs.api.command.CommandHandler;
import com.wojciechwaldon.cqrs.application.handlers.CommandHandlersProvider;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SpringCommandExecutor implements CommandExecutor {

    private CommandHandlersProvider commandHandlersProvider;

    public void execute(Command command) throws Exception {
        CommandHandler<Command> handler = commandHandlersProvider.getHandler(command);
        handler.handle(command);
    }
}


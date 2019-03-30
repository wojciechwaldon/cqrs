package com.wojciechwaldon.cqrs.application.handlers;

import com.wojciechwaldon.cqrs.api.command.Command;
import com.wojciechwaldon.cqrs.api.command.CommandHandler;

public interface CommandHandlersProvider {

    CommandHandler<Command> getHandler(Command command);
}

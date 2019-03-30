package com.wojciechwaldon.cqrs.api.command;

public interface CommandHandler<T extends Command> {

    void handle(T command) throws Exception;
}

package com.wojciechwaldon.cqrs.api.command;

public interface CommandExecutor {

    void execute(Command command) throws Exception;
}

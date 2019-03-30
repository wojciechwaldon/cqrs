package com.wojciechwaldon.cqrs.application.command.model;

import com.wojciechwaldon.cqrs.api.command.CommandHandler;

public class TestSaveWithExceptionCommandHandler implements CommandHandler<TestSaveWithExceptionCommand> {

    public void handle(TestSaveWithExceptionCommand command) throws Exception {
        throw new Exception("TestSaveWithExceptionCommandHandler successful");
    }
}

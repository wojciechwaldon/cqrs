package com.wojciechwaldon.cqrs.application.command.model;

import com.wojciechwaldon.cqrs.api.command.CommandHandler;

public class TestSaveCommandHandler implements CommandHandler<TestSaveCommand> {

    public void handle(TestSaveCommand command) {
        System.out.println("TestSaveCommandHandler successful, message: " + command.getMessageToSave());
    }
}

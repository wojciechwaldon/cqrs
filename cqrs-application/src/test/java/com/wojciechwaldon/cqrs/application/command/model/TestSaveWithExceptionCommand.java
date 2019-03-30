package com.wojciechwaldon.cqrs.application.command.model;

import com.wojciechwaldon.cqrs.api.command.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class TestSaveWithExceptionCommand implements Command {

    private String messageToSave;
}

package com.wojciechwaldon.cqrs.application.command;

import com.wojciechwaldon.cqrs.api.command.CommandExecutor;
import com.wojciechwaldon.cqrs.application.command.model.TestSaveCommand;
import com.wojciechwaldon.cqrs.application.command.model.TestSaveWithExceptionCommand;
import com.wojciechwaldon.cqrs.application.configuration.TestCommandConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestCommandConfiguration.class)
public class CommandHandlerTest {

    @Autowired
    private CommandExecutor commandExecutor;

    @Test
    public void shouldExecuteCommand() throws Exception {
        //given
        TestSaveCommand command = TestSaveCommand.of("Should execute command");

        //when
        commandExecutor.execute(command);
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionDuringExecutingCommand() throws Exception {
        //given
        TestSaveWithExceptionCommand command = TestSaveWithExceptionCommand.of("Should execute command with exception");

        //when
        commandExecutor.execute(command);
    }

}

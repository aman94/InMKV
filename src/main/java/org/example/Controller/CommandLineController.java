package org.example.Controller;

import lombok.RequiredArgsConstructor;
import org.example.DataStore.Store;
import org.example.Entities.Commands.Command;
import org.example.Entities.Commands.CommandResponse;
import org.example.Executors.CommandExecutor;
import org.example.Helpers.CommandParser;


@RequiredArgsConstructor
public class CommandLineController {
    private final CommandExecutor commandExecutor;
    private final Store store;

    public void run(String commandString){
        Command command = CommandParser.parse(commandString, store);
        commandExecutor.submit(command);
//        command.execute();
    }
}

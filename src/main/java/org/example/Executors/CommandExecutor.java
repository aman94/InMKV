package org.example.Executors;


import org.example.Entities.Commands.Command;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CommandExecutor {
    private static final ExecutorService executorService  = Executors.newFixedThreadPool(20);
    public void submit(Command command){
        executorService.submit(new RunnableCommand(command));
    }


}

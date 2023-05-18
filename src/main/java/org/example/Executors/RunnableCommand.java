package org.example.Executors;

import lombok.RequiredArgsConstructor;
import org.example.Entities.Commands.Command;
import org.example.Entities.Commands.CommandResponse;
import org.example.Exception.DataStoreRuntimeException;


@RequiredArgsConstructor
public class RunnableCommand implements Runnable {
    private final Command command;
    @Override
    public void run() {
        try {
            CommandResponse response = command.execute();
            System.out.println(response.getPrintableString());
//        }catch (Exception e){
//            throw e;
//        }
        }catch (DataStoreRuntimeException e){
            System.out.println(e.getMessage());
        }

    }
}

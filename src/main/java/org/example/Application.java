package org.example;

import org.example.Controller.CommandLineController;
import org.example.DataStore.DataStoreFactory;
import org.example.DataStore.Store;
import org.example.Executors.CommandExecutor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Application {
    public static void run(){
        Store store = DataStoreFactory.getInstance();
        CommandExecutor executor = new CommandExecutor();
        CommandLineController controller = new CommandLineController(executor,store);
        runCommands(controller);
    }

    private static void runCommands(CommandLineController controller) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/input.txt"));
            reader.lines().sequential().forEach(line-> {
                controller.run(line);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        controller.run("put sde_bootcamp title SDE-Bootcamp price 30000.00 enrolled false estimated_time 30");
        controller.run("get sde_bootcamp");
    }

}

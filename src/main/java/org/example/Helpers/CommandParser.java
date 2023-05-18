package org.example.Helpers;

import org.example.DataStore.Store;
import org.example.Entities.Commands.*;
import org.example.Exception.CommandNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class CommandParser {


    public static Command parse(String command, Store store){

        String[] splits = command.split(" ");
        //Todo move to separate method for each command to add specific validations.
        return switch (splits[0]) {
            case "get" -> new GetCommand(splits[1], store);
            case "put" -> parsePutCommand(splits, store);
            case "exit" -> new ExitCommand();
            case "keys" -> new KeysCommand(store);
            case "delete" -> new DeleteCommand(splits[1], store);
            case "search" -> new SearchCommand(splits[1], splits[2], store);
            default -> throw new CommandNotFoundException("");
        };
    }

    private static PutCommand parsePutCommand(String[] splits, Store store){
        //put sde_bootcamp title SDE-Bootcamp price 30000.00 enrolled false estimated_time 30
        //Add creation validations. length % 2  ==0
        String key = splits[1];
        Map<String,String> attributes = new HashMap<>();
        for (int i = 2; i < splits.length ; i+=2) {
            attributes.put(splits[i],splits[i+1]);
        }
        return new PutCommand(key, attributes, store);
    }


}

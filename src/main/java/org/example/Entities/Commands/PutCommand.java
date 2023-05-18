package org.example.Entities.Commands;

import lombok.RequiredArgsConstructor;
import org.example.DataStore.Store;
import org.example.Entities.Commands.Command;
import org.example.Entities.Commands.CommandResponse;

import java.util.Map;

@RequiredArgsConstructor
public class PutCommand  implements Command {
    private final String key;
    private final Map<String,String> attributes;
    private final Store store;


    @Override
    public CommandResponse execute() {
        store.put(key, attributes);
        return () -> "";
    }

}

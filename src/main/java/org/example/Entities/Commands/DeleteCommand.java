package org.example.Entities.Commands;

import lombok.RequiredArgsConstructor;
import org.example.DataStore.Store;

@RequiredArgsConstructor
public class DeleteCommand implements Command {

    private final String key;
    private final Store store;
    @Override
    public CommandResponse execute() {
        store.delete(key);
        return new DeleteCommandResponse();
    }
}

package org.example.Entities.Commands;

import lombok.RequiredArgsConstructor;
import org.example.DataStore.Store;

@RequiredArgsConstructor
public class KeysCommand implements Command {
    private final Store store;
    @Override
    public KeysCommandResponse execute() {
        return new KeysCommandResponse(store.keys());
    }
}

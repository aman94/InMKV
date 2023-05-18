package org.example.Entities.Commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.DataStore.Store;
import org.example.Entities.Constants;
import org.example.Exception.KeyNotFoundException;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
public class GetCommand  implements Command {
    @Getter
    private String key;
    private final Store store;

    @Override
    public GetResponse execute() {
        StoreEntity storeEntity = store.get(key);
        if(storeEntity == null)
            throw new KeyNotFoundException(String.format(Constants.KEY_NOT_FOUND_ERROR_MESSAGE,key));
        return new GetResponse(storeEntity.getAttributes());
    }


    public static @NotNull GetCommand getInstance(String[] splits , Store store) {
        return new GetCommand(splits[1], store);
    }
}

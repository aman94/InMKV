package org.example.Entities.Commands;

import lombok.RequiredArgsConstructor;
import org.example.DataStore.Store;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class SearchCommand implements Command {
    private final String attributeKey;
    private final String attributeValue;
    private final Store store;

    @Override
    public SearchCommandResponse execute() {
     List<StoreEntity> storeEntities = store.search(attributeKey, attributeValue);
     return new SearchCommandResponse(
             storeEntities.stream()
                     .filter(k -> k.getAttributes().get(attributeKey).equals(attributeValue))
                     .map(StoreEntity::getKey)
                     .collect(Collectors.toList()));
    }
}

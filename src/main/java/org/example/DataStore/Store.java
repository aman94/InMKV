package org.example.DataStore;

import org.example.Entities.Commands.StoreEntity;

import java.util.List;
import java.util.Map;

public interface Store {
    StoreEntity get(String key);

    void put(String key, Map<String,String> listOfAttributePairs);

    List<StoreEntity> search(String attributeKey, String attributeValue);

    void delete(String key);

    List<String> keys();

}

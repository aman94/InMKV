package org.example.DataStore;

import org.example.Entities.AttributeType;
import org.example.Entities.Constants;
import org.example.Entities.Commands.StoreEntity;
import org.example.Exception.KeyNotFoundException;
import org.example.Helpers.AttributeValidator;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryDataStore implements Store{

    private final  ConcurrentHashMap<String,StoreEntity> storeEntityMap;
    private final ConcurrentHashMap<String, AttributeType> metadata;

    public InMemoryDataStore() {
        this.storeEntityMap = new ConcurrentHashMap<>();
        this.metadata = new ConcurrentHashMap<>();
    }

    @Override
    public StoreEntity get(String key) {
        return storeEntityMap.get(key);
    }

    @Override
    public void put(String key, Map<String, String> listOfAttributePairs) {
        AttributeValidator.validate(listOfAttributePairs,metadata);
        StoreEntity storeEntity = new StoreEntity(key,listOfAttributePairs);
        storeEntityMap.put(key,storeEntity);
    }

    @Override
    public List<StoreEntity> search(String attributeKey, String attributeValue) {
        List<StoreEntity> result = new ArrayList<>();
        Enumeration<StoreEntity> enumeration = storeEntityMap.elements();
        while (enumeration.hasMoreElements()){
            StoreEntity entity = enumeration.nextElement();
            if(entity.getAttributes().get(attributeKey).compareTo(attributeValue) == 0){
                result.add(entity);
            }
        }
        return result;
    }

    @Override
    public void delete(String key) {
        if(storeEntityMap.remove(key) == null)
            throw new KeyNotFoundException(String.format(Constants.KEY_NOT_FOUND_ERROR_MESSAGE,key));
    }

    @Override
    public List<String> keys() {
        return new ArrayList<>(storeEntityMap.keySet());
    }
}

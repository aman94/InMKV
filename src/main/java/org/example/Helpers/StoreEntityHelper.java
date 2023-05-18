package org.example.Helpers;

import org.example.Entities.Commands.StoreEntity;

import java.util.Map;

public class StoreEntityHelper {
    public static StoreEntity build(String key, Map<String, String> listOfAttributePairs){
        return new StoreEntity(key,listOfAttributePairs);
    }
}

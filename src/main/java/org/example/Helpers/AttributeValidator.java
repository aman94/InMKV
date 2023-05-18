package org.example.Helpers;

import org.example.Entities.AttributeType;
import org.example.Entities.Constants;
import org.example.Exception.AttributeValidationException;

import java.util.Map;

public class AttributeValidator {
    public static void validate(Map<String,String> attributes, Map<String, AttributeType> types){
        attributes.forEach((key,value) -> {
            if(types.containsKey(key)){
                validateType(value,types.get(key));
            }else
                types.put(key,getType(value));
        });
    }
    private static void validateType(String value, AttributeType type){
        if(getType(value) != type){
            throw new AttributeValidationException(Constants.ATTRIBUE_VALIDATION_ERROR_MESSAGE);
        }
    }

    private static AttributeType getType(String value){
        Double dtemp = getDouble(value);
        if(dtemp != null){
            return value.contains(".") ? AttributeType.DOUBLE : AttributeType.INTEGER;
        }
        if(isBoolean(value))
            return AttributeType.BOOLEAN;

        return AttributeType.STRING;
    }
    private static Double getDouble(String value){
       try{
           return Double.parseDouble(value);
       }catch (Exception e){
           return null;
       }
    }
    private static boolean isBoolean(String value){
        return value.compareTo("true") == 0 || value.compareTo("false") == 0 ;
    }

}

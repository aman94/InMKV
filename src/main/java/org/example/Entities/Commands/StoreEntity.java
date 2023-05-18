package org.example.Entities.Commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class StoreEntity {
    private final String key;
    private final Map<String,String> attributes;
}

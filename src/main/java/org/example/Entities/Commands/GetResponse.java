package org.example.Entities.Commands;

import org.example.Entities.Commands.CommandResponse;

import java.util.HashMap;
import java.util.Map;

public class GetResponse implements CommandResponse {
    private final Map<String,String> attributes;

    public GetResponse(Map<String, String> attributes) {
        this.attributes =new HashMap<>();
        this.attributes.putAll(attributes);
    }

    @Override
    public String getPrintableString() {
        return attributes.entrySet().stream()
                .map(e -> e.getKey()+": "+e.getValue())
                .reduce((a,b) -> a+","+b)
                .get();
    }
}

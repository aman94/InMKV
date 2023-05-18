package org.example.Entities.Commands;

import lombok.RequiredArgsConstructor;
import org.example.Entities.Commands.CommandResponse;

import java.util.List;

@RequiredArgsConstructor
public class SearchCommandResponse implements CommandResponse {
    private final List<String> keys;

    @Override
    public String getPrintableString() {
        return keys.stream()
                .reduce((a,b) -> a+","+b)
                .get();
    }
}

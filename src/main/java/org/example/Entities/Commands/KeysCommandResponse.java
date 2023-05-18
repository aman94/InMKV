package org.example.Entities.Commands;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.Entities.Commands.CommandResponse;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class KeysCommandResponse implements CommandResponse {
    private final List<String> keys;

    @Override
    public String getPrintableString() {
        return keys.stream()
                .reduce((a,b) -> a+","+b).get();
    }
}

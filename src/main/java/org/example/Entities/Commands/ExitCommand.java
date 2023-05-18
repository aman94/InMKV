package org.example.Entities.Commands;

import org.example.Entities.Commands.Command;
import org.example.Entities.Commands.CommandResponse;

public class ExitCommand implements Command {
    @Override
    public CommandResponse execute() {
        System.exit(0);
        return null;
    }
}

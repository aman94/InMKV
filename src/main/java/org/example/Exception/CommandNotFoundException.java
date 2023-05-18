package org.example.Exception;

public class CommandNotFoundException extends DataStoreRuntimeException{
    public CommandNotFoundException(String message) {
        super(message);
    }
}

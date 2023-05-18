package org.example.DataStore;

public class DataStoreFactory {
    private static class SingletonStore{
        private static final Store INSTANCE = new InMemoryDataStore();
    }
    public static Store getInstance(){
        return SingletonStore.INSTANCE;
    }

}

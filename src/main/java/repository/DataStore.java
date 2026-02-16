// DataStore.java

package repository;

import model.MemoryEntry;
import java.util.List;
import java.io.IOException;

public interface DataStore {
    List<MemoryEntry> loadAll() throws IOException; 
    
    void saveAll(List<MemoryEntry> entries) throws IOException;
}
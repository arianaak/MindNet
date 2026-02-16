package repository;

import model.MemoryEntry;
import exceptions.MemoryNotFoundException;
import exceptions.InvalidMemoryEntryException;
import exceptions.DuplicateException;
import java.io.*;
import java.util.*;


public class MemoryRepository {

    private final File file = new File("memory.json");
    
    private final Map<Long, MemoryEntry> entriesMap = new HashMap<>();

    public MemoryRepository() {
        loadFromFile();
    }

    public List<MemoryEntry> findAll() {
        
        return new ArrayList<>(entriesMap.values());
    }

    public MemoryEntry findById(long id) throws MemoryNotFoundException {
        MemoryEntry entry = entriesMap.get(id);
        if (entry == null) {
            throw new MemoryNotFoundException("Memory with id " + id + " not found");
        }
        return entry;
    }

    public void add(MemoryEntry entry) throws InvalidMemoryEntryException, DuplicateException {
        
        if (entriesMap.containsKey(entry.getId())) {
            throw new DuplicateException("ID " + entry.getId() + " already exists. Cannot create memory.");
        }
        
        if (entry.getTitle() == null || entry.getTitle().isEmpty()) {
            throw new InvalidMemoryEntryException("Title cannot be empty");
        }

        entriesMap.put(entry.getId(), entry); 
        saveToFile();
    }

    public void delete(long id) throws MemoryNotFoundException {
        if (entriesMap.remove(id) == null) {
            throw new MemoryNotFoundException("Memory with id " + id + " not found");
        }
        saveToFile();
    }

    // ----------- FILE ------------

    private void saveToFile() {
        List<MemoryEntry> entries = new ArrayList<>(entriesMap.values());
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.println("[");
            for (int i = 0; i < entries.size(); i++) {
                MemoryEntry e = entries.get(i);
                writer.println("   {");
                writer.println("     \"id\": " + e.getId() + ",");
                writer.println("     \"title\": \"" + e.getTitle() + "\",");
                writer.println("     \"description\": \"" + e.getDescription() + "\"");
                writer.print("   }");
                if (i < entries.size() - 1) writer.println(",");
            }
            writer.println("\n]");
        } catch (IOException e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            entriesMap.clear(); 
            String line;
            long id = 0;
            String title = null;
            String description = null;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("\"id\"")) {
                    id = Long.parseLong(line.split(":")[1].replace(",", "").trim());
                } else if (line.startsWith("\"title\"")) {
                    title = line.split(":")[1].replace("\"", "").replace(",", "").trim();
                } else if (line.startsWith("\"description\"")) {
                    description = line.split(":")[1].replace("\"", "").trim();
                    entriesMap.put(id, new MemoryEntry(id, title, description)); 
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading: " + e.getMessage());
        }
    }
}
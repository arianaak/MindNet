package controller;

import repository.MemoryRepository;
import model.MemoryEntry;
import exceptions.*;

import java.util.List;

public class MemoryController {

    private final MemoryRepository repository = new MemoryRepository();

    public void createMemory(long id, String title, String description)
            throws InvalidMemoryEntryException, DuplicateException {
        
        if (id <= 0) {
            throw new InvalidMemoryEntryException("ID must be a positive number.");
        }

        repository.add(new MemoryEntry(id, title, description));
        System.out.println("Added!");
    }

    public List<MemoryEntry> getAll() {
        return repository.findAll();
    }

    public MemoryEntry getById(long id) throws MemoryNotFoundException {
        return repository.findById(id);
    }

    public void delete(long id) throws MemoryNotFoundException {
        repository.delete(id);
        System.out.println("Deleted!");
    }
}
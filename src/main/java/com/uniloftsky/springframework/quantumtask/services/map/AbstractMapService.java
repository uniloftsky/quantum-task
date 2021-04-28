package com.uniloftsky.springframework.quantumtask.services.map;

import com.uniloftsky.springframework.quantumtask.model.BaseEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();
    protected Map<Long, T> cache = new HashMap<>();

    public Set<T> findAll() {
        log.info("Size of found elements: " + map.values().size());
        return new HashSet<>(map.values());
    }

    public T findById(Long id) {
        if (cache.get(id) == null) {
            T foundObject = getObjectFromDB(id);
            cache.clear();
            cache.put(id, foundObject);
            return foundObject;
        }
        log.info("Got object from the cache!");
        return cache.get(id);
    }

    public T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null!");
        }
        log.info("Element: " + object + " saved successfully");
        return object;
    }

    public void deleteById(ID id) {
        Optional<T> tOptional = Optional.ofNullable(map.get(id));
        if (tOptional.isEmpty()) {
            log.error("Cannot find expected element with ID: " + id);
            throw new RuntimeException("Expected element not found!");
        } else {
            log.info("Deleted element with ID: " + id);
            map.remove(id);
        }
    }

    public void delete(T object) {
        log.info("Deleted element: " + object + " with ID: " + object.getId());
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        long nextId;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }

    private T getObjectFromDB(Long id) {
        Optional<T> tOptional = Optional.ofNullable(map.get(id));
        if (tOptional.isEmpty()) {
            log.error("Cannot find expected element with ID: " + id);
            throw new RuntimeException("Expected element not found!");
        } else {
            log.info("Found element with ID: " + id);
            return tOptional.get();
        }
    }
}

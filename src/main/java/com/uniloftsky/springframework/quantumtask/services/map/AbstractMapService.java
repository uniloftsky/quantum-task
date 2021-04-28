package com.uniloftsky.springframework.quantumtask.services.map;

import com.uniloftsky.springframework.quantumtask.model.BaseEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        log.info("Size of found elements: " + map.values().size());
        return new HashSet<>(map.values());
    }

    T findById(Long id) {
        Optional<T> tOptional = Optional.ofNullable(map.get(id));
        if (tOptional.isEmpty()) {
            log.error("Cannot find expected element with ID: " + id);
            throw new RuntimeException("Expected element not found!");
        } else {
            log.info("Found element with ID: " + id);
            return map.get(id);
        }
    }

    T save(T object) {
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

    void deleteById(ID id) {
        Optional<T> tOptional = Optional.ofNullable(map.get(id));
        if (tOptional.isEmpty()) {
            log.error("Cannot find expected element with ID: " + id);
            throw new RuntimeException("Expected element not found!");
        } else {
            log.info("Deleted element with ID: " + id);
            map.remove(id);
        }
    }

    void delete(T object) {
        log.info("Deleted element: " + object + " with ID: " + object.getId());
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }
}

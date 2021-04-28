package com.uniloftsky.springframework.quantumtask.services.map;

import com.uniloftsky.springframework.quantumtask.model.Destination;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DestinationServiceMap extends AbstractMapService<Destination, Long> {

    @Override
    public Set<Destination> findAll() {
        return super.findAll();
    }

    @Override
    public Destination findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Destination save(Destination object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Destination object) {
        super.delete(object);
    }
}

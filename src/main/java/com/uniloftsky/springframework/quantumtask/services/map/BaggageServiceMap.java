package com.uniloftsky.springframework.quantumtask.services.map;

import com.uniloftsky.springframework.quantumtask.model.Baggage;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class BaggageServiceMap extends AbstractMapService<Baggage, Long> {

    public boolean checkIn(Long baggageId, Long destinationId) {
        Baggage foundBaggage = findById(baggageId);
        return foundBaggage.getDestination().getId().equals(destinationId);
    }

    @Override
    public Set<Baggage> findAll() {
        return super.findAll();
    }

    @Override
    public Baggage findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Baggage save(Baggage object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Baggage object) {
        super.delete(object);
    }
}

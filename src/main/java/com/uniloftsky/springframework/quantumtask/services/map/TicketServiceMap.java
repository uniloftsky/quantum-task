package com.uniloftsky.springframework.quantumtask.services.map;

import com.uniloftsky.springframework.quantumtask.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TicketServiceMap extends AbstractMapService<Ticket, Long> {

    public boolean checkIfBooked(Long id) {
        return findById(id).isBooked();
    }

    @Override
    public Set<Ticket> findAll() {
        return super.findAll();
    }

    @Override
    public Ticket findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Ticket save(Ticket object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Ticket object) {
        super.delete(object);
    }
}

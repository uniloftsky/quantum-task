package com.uniloftsky.springframework.quantumtask;

import com.uniloftsky.springframework.quantumtask.model.Ticket;
import com.uniloftsky.springframework.quantumtask.services.map.TicketServiceMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {

    private TicketServiceMap ticketServiceMap;

    //Mock data
    final Long ticketId = 1L;
    final double ticketPrice = 200.0;
    final boolean ticketBooked = true;

    @BeforeEach
    void setUp() {
        ticketServiceMap = new TicketServiceMap();
        ticketServiceMap.save(Ticket.builder().id(ticketId).price(ticketPrice).booked(ticketBooked).build());
    }

    @Test
    void testFindById() {
        Ticket ticket = ticketServiceMap.findById(ticketId);
        assertEquals(ticketId, ticket.getId());
    }

    @Test
    void testFindAll() {
        Set<Ticket> tickets = ticketServiceMap.findAll();
        assertEquals(1, tickets.size());
    }

    @Test
    void testDelete() {
        ticketServiceMap.delete(ticketServiceMap.findById(ticketId));
        assertEquals(0, ticketServiceMap.findAll().size());
    }

    @Test
    void testSaveExistingId() {
        Long id = 2L;
        Ticket ticket = Ticket.builder().id(id).build();
        Ticket savedTicket = ticketServiceMap.save(ticket);
        assertEquals(id, savedTicket.getId());
    }

    @Test
    void testSaveNoId() {
        Ticket savedTicket = ticketServiceMap.save(Ticket.builder().build());
        assertNotNull(savedTicket);
        assertNotNull(savedTicket.getId());
    }

    @Test
    void testDeleteById() {
        ticketServiceMap.deleteById(ticketId);
        assertEquals(0, ticketServiceMap.findAll().size());
    }

    @Test
    void testNullFound() {
        assertThrows(RuntimeException.class, () -> ticketServiceMap.findById(2L));
    }
}

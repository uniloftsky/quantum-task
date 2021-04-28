package com.uniloftsky.springframework.quantumtask;

import com.uniloftsky.springframework.quantumtask.model.Ticket;
import com.uniloftsky.springframework.quantumtask.services.map.TicketServiceMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketLogicTest {

    private TicketServiceMap ticketServiceMap;
    private final Long ticketId = 1L;
    private final double ticketPrice = 200.0;
    private final boolean ticketBooked = true;

    @BeforeEach
    void setUp() {
        ticketServiceMap = new TicketServiceMap();
        ticketServiceMap.save(Ticket.builder().id(1L).price(200.00).booked(true).build());
    }

    @Test
    void testBookedTicket() {
        assertTrue(ticketServiceMap.checkIfBooked(ticketId));
    }
}

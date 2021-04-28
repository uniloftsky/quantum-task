package com.uniloftsky.springframework.quantumtask;

import com.uniloftsky.springframework.quantumtask.model.Baggage;
import com.uniloftsky.springframework.quantumtask.model.Destination;
import com.uniloftsky.springframework.quantumtask.services.map.BaggageServiceMap;
import com.uniloftsky.springframework.quantumtask.services.map.DestinationServiceMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BaggageLogicTest {

    private BaggageServiceMap baggageServiceMap;
    private Baggage baggage;
    private Destination destination;

    @BeforeEach
    void setUp() {
        baggageServiceMap = new BaggageServiceMap();
        DestinationServiceMap destinationServiceMap = new DestinationServiceMap();
        destination = Destination.builder().id(1L).build();
        baggage = Baggage.builder().id(1L).destination(destination).build();

        destinationServiceMap.save(destination);
        baggageServiceMap.save(baggage);

    }

    @Test
    void testCheckIn() {
        assertTrue(baggageServiceMap.checkIn(baggage.getId(), destination.getId()));
    }
}

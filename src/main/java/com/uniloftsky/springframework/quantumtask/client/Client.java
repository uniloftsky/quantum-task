package com.uniloftsky.springframework.quantumtask.client;

import com.uniloftsky.springframework.quantumtask.model.Baggage;
import com.uniloftsky.springframework.quantumtask.model.Coupon;
import com.uniloftsky.springframework.quantumtask.model.Destination;
import com.uniloftsky.springframework.quantumtask.model.Ticket;
import com.uniloftsky.springframework.quantumtask.services.map.BaggageServiceMap;
import com.uniloftsky.springframework.quantumtask.services.map.CouponServiceMap;
import com.uniloftsky.springframework.quantumtask.services.map.DestinationServiceMap;
import com.uniloftsky.springframework.quantumtask.services.map.TicketServiceMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@Component
public class Client implements CommandLineRunner {

    private final TicketServiceMap ticketServiceMap;
    private final DestinationServiceMap destinationServiceMap;
    private final BaggageServiceMap baggageServiceMap;
    private final CouponServiceMap couponServiceMap;

    public Client(TicketServiceMap ticketServiceMap, DestinationServiceMap destinationServiceMap, BaggageServiceMap baggageServiceMap, CouponServiceMap couponServiceMap) {
        this.ticketServiceMap = ticketServiceMap;
        this.destinationServiceMap = destinationServiceMap;
        this.baggageServiceMap = baggageServiceMap;
        this.couponServiceMap = couponServiceMap;
    }

    @Override
    public void run(String... args) throws Exception {
        loadTickets();
        loadDestinations();
        loadBaggages();
        loadCoupons();
    }

    private void loadTickets() {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(200.99, false));
        tickets.add(new Ticket(250.99, true));
        tickets.add(new Ticket(999.99, false));
        tickets.add(new Ticket(250.99, false));

        for (Ticket ticket : tickets) {
            ticketServiceMap.save(ticket);
        }
        log.info("Tickets loaded to DB");
    }

    private void loadDestinations() {
        List<Destination> destinations = new ArrayList<>();
        destinations.add(new Destination("Lviv"));
        destinations.add(new Destination("Kyiv"));
        destinations.add(new Destination("New-York"));
        destinations.add(new Destination("London"));

        for (Destination destination : destinations) {
            destinationServiceMap.save(destination);
        }
        log.info("Destinations loaded to DB");
    }

    private void loadBaggages() {
        List<Baggage> baggages = new ArrayList<>();
        baggages.add(new Baggage(destinationServiceMap.findById(1L)));
        baggages.add(new Baggage(destinationServiceMap.findById(2L)));
        baggages.add(new Baggage(destinationServiceMap.findById(3L)));
        baggages.add(new Baggage(destinationServiceMap.findById(4L)));

        for (Baggage baggage : baggages) {
            baggageServiceMap.save(baggage);
        }
        log.info("Baggages loaded to DB");
    }

    private void loadCoupons() {
        List<Coupon> coupons = new ArrayList<>();
        coupons.add(new Coupon(Set.of(10, 50, 60)));
        coupons.add(new Coupon(Set.of(10, 50, 60)));
        coupons.add(new Coupon(Set.of(10, 50, 60)));
        coupons.add(new Coupon(Set.of(10, 50, 60)));

        for (Coupon coupon : coupons) {
            couponServiceMap.save(coupon);
        }
        log.info("Coupons loaded to DB");
    }
}

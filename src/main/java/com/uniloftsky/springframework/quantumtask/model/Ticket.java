package com.uniloftsky.springframework.quantumtask.model;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ticket extends BaseEntity {

    @Builder
    public Ticket(Long id, @NotNull(message = "Price on 'ticket' cannot be a null!") Double price, @NotNull(message = "Booked field on 'ticket' cannot be a null") boolean booked) {
        super(id);
        this.price = price;
        this.booked = booked;
    }

    @NotNull(message = "Price on 'ticket' cannot be a null!")
    private Double price;

    @NotNull(message = "Booked field on 'ticket' cannot be a null")
    private boolean booked;

}

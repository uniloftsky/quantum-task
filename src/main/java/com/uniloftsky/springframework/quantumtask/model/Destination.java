package com.uniloftsky.springframework.quantumtask.model;

import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Destination extends BaseEntity {

    @Builder
    public Destination(Long id, @NotNull(message = "Destination field on 'destination' cannot be a null!") String destination) {
        super(id);
        this.destination = destination;
    }

    @NotNull(message = "Destination field on 'destination' cannot be a null!")
    private String destination;

}

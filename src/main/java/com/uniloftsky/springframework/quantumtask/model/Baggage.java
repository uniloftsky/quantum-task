package com.uniloftsky.springframework.quantumtask.model;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Baggage extends BaseEntity {

    @Builder
    public Baggage(Long id, @NotNull(message = "Destination field on 'baggage' cannot be a null!") Destination destination) {
        super(id);
        this.destination = destination;
    }

    @NotNull(message = "Destination field on 'baggage' cannot be a null!")
    private Destination destination;

}

package com.uniloftsky.springframework.quantumtask.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Coupon extends BaseEntity {

    @Builder
    public Coupon(Long id, Set<Integer> discounts) {
        super(id);
        this.discounts = discounts;
    }

    @NotNull(message = "Discounts list on 'coupon' cannot be a null!")
    private Set<Integer> discounts = new HashSet<>();

}

package com.uniloftsky.springframework.quantumtask.model;

import lombok.*;

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

    private Set<Integer> discounts = new HashSet<>();

}

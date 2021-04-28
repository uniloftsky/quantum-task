package com.uniloftsky.springframework.quantumtask;

import com.uniloftsky.springframework.quantumtask.model.Coupon;
import com.uniloftsky.springframework.quantumtask.services.map.CouponServiceMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

public class CouponLogicTest {

    private CouponServiceMap couponServiceMap;
    private Coupon coupon;

    @BeforeEach
    void setUp() {
        couponServiceMap = new CouponServiceMap();
        coupon = Coupon.builder().id(1L).discounts(Set.of(10, 50, 60)).build();
        couponServiceMap.save(coupon);
    }

    @Test
    void testDiscountLogic() {
        double currentPrice = 500.00;
        double discountSize = coupon.getDiscounts().stream().findAny().get();
        double newPrice = currentPrice - (currentPrice * (discountSize / 100));

        assertEquals(newPrice, couponServiceMap.getNewPrice(coupon.getId(), currentPrice));

    }
}

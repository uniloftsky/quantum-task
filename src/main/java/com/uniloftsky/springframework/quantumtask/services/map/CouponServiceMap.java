package com.uniloftsky.springframework.quantumtask.services.map;

import com.uniloftsky.springframework.quantumtask.model.Coupon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class CouponServiceMap extends AbstractMapService<Coupon, Long> {

    public double getNewPrice(Long couponId, double currentPrice) {
        Coupon foundCoupon = findById(couponId);
        return recalculatePrice(currentPrice, foundCoupon.getDiscounts().stream().findAny().get());
    }

    @Override
    public Set<Coupon> findAll() {
        return super.findAll();
    }

    @Override
    public Coupon findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Coupon save(Coupon object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Coupon object) {
        super.delete(object);
    }

    private double recalculatePrice(double currentPrice, double discountSize) {
        double newPrice = currentPrice - (currentPrice * (discountSize / 100));
        log.info("Current price: " + currentPrice + ". Discount equals: " + discountSize + "%. New price equals: " + newPrice);
        return newPrice;
    }

}

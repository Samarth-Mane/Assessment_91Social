package com.restapi.app.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.restapi.app.entity.Component;
import com.restapi.app.repository.ComponentRepository;

@Service
public class PricingService {

    private final ComponentRepository componentRepository;

    public PricingService(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    public BigDecimal calculatePrice(
            Long frameId,
            Long gearSetId,
            Long tyreId) {

        Component frame = componentRepository
                .findById(frameId)
                .orElseThrow(() ->
                        new RuntimeException("Frame not found"));

        Component gearSet = componentRepository
                .findById(gearSetId)
                .orElseThrow(() ->
                        new RuntimeException("Gear set not found"));

        Component tyre = componentRepository
                .findById(tyreId)
                .orElseThrow(() ->
                        new RuntimeException("Tyre not found"));

        return frame.getPrice()
                .add(gearSet.getPrice())
                .add(tyre.getPrice());
    }
}
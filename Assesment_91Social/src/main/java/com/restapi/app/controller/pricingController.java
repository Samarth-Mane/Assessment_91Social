package com.restapi.app.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.app.service.PricingService;

@RestController
public class pricingController {
	
	
	private final PricingService pricingService;

    public pricingController(PricingService pricingService) {
        this.pricingService = pricingService;
    }
    
    @PostMapping("/api/admin/priceCalculate")
    public BigDecimal calculatePrice(
            @RequestParam Long frameId,
            @RequestParam Long gearSetId,
            @RequestParam Long tyreId) {

        return pricingService.calculatePrice(
                frameId,
                gearSetId,
                tyreId
        );
    }
    
	
}

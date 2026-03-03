package com.example.electricitybill.controller;

import com.example.electricitybill.model.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*") // allow requests from frontend
@RequestMapping("/api/bill")
public class BillController {

    @PostMapping("/calculate")
    public Customer calculateBill(@RequestBody Customer customer) {
        int units = customer.getCurrReading() - customer.getPrevReading();
        double amount = calculateAmount(units);
        customer.setBillAmount(amount);
        return customer;
    }

    private double calculateAmount(int units) {
        double amount = 0.0;
        int remaining = units;

        int slab = Math.min(remaining, 100);
        amount += slab * 3.5;
        remaining -= slab;

        if (remaining > 0) {
            slab = Math.min(remaining, 100);
            amount += slab * 4.0;
            remaining -= slab;
        }

        if (remaining > 0) {
            slab = Math.min(remaining, 200);
            amount += slab * 5.2;
            remaining -= slab;
        }

        if (remaining > 0) {
            amount += remaining * 6.5;
        }

        amount += 50; // fixed charge
        amount += amount * 0.05; // 5% tax
        return Math.round(amount * 100.0) / 100.0;
    }
}

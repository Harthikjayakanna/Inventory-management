package com.inventory.administration.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.administration.DTO.Billing;
import com.inventory.administration.DTO.ResponseStructure;
import com.inventory.administration.Service.BillingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
public class BillingController {
    @Autowired
    private BillingService service;

    @PostMapping("/bill")
    public ResponseEntity<ResponseStructure<Billing>> saveBilling(@RequestBody Billing bill) {
        return service.saveBilling(bill);
    }

    @GetMapping("/allBill")
    public ResponseEntity<ResponseStructure<List<Billing>>> getAllBills() {
        return service.findAll();
    }

    @GetMapping("/bill/{id}")
    public ResponseEntity<ResponseStructure<Billing>> getBillById(@PathVariable int id) {
        return service.findById(id);
    }

}

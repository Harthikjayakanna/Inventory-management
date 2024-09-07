package com.inventory.administration.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventory.administration.DTO.Billing;
import com.inventory.administration.Repository.BillingRepository;

@Repository
public class BillingDao {
    @Autowired
    private BillingRepository repository;

    public Billing saveBilling(Billing b) {
        return repository.save(b);
    }

    public Optional<Billing> getById(int id) {
        return repository.findById(id);
    }

    public void deleteBilling(Billing b) {
        repository.delete(b);
    }

    public List<Billing> getAll() {
        return repository.findAll();
    }

}

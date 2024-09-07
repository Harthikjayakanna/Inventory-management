package com.inventory.administration.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inventory.administration.DAO.BillingDao;
import com.inventory.administration.DAO.ProductDao;
import com.inventory.administration.DTO.Billing;
import com.inventory.administration.DTO.Items;
import com.inventory.administration.DTO.Product;
import com.inventory.administration.DTO.ResponseStructure;
import com.inventory.administration.Exception.IDnotFoundException;

@Service
public class BillingService {
    @Autowired
    private BillingDao dao;
    @Autowired
    private ProductDao pDao;
    ResponseStructure<Billing> resBilling = new ResponseStructure<>();

    public ResponseEntity<ResponseStructure<Billing>> saveBilling(Billing b) {
        List<Items> items = b.getItems();
        for (Items i : items) {
            int count = i.getCount();
            i.setBilling(b);
            Optional<Product> product = pDao.findbyName(i.getName());
            if (product.isPresent()) {
                Product p = product.get();
                p.setCounts(p.getCounts() - count);
                pDao.updateProduct(p);
            }
        }
        Billing bill = dao.saveBilling(b);
        resBilling.setData(bill);
        resBilling.setMessage("Billing has been saved");
        resBilling.setStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<ResponseStructure<Billing>>(resBilling, HttpStatus.CREATED);
    }

    // Get all the Bill
    public ResponseEntity<ResponseStructure<List<Billing>>> findAll() {
        ResponseStructure<List<Billing>> resBill = new ResponseStructure<>();
        List<Billing> allBillings = dao.getAll();
        resBill.setData(allBillings);
        resBill.setMessage("All the Bills");
        resBill.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<ResponseStructure<List<Billing>>>(resBill, HttpStatus.OK);
    }

    // Get the Particular Bill
    public ResponseEntity<ResponseStructure<Billing>> findById(int id) {
        ResponseStructure<Billing> resBill = new ResponseStructure<>();
        Optional<Billing> optBill = dao.getById(id);
        if (optBill.isPresent()) {
            resBill.setData(optBill.get());
            resBill.setMessage("All the Bills");
            resBill.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<ResponseStructure<Billing>>(resBill, HttpStatus.OK);
        }
        throw new IDnotFoundException();
    }
}

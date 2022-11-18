package com.csi.controller;

import com.csi.exception.ProductRecordNotFound;
import com.csi.model.Product;
import com.csi.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductServiceImpl  productServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<Product>saveData(@RequestBody Product product){
        log.info("*********Trying To Save Data************"+product.getProductName());
        return ResponseEntity.ok(productServiceImpl.saveData(product));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Optional<Product>> getDataById(@PathVariable int productId){
        return ResponseEntity.ok(productServiceImpl.getDataById(productId));

    }
    @PutMapping("/{productId}")
    public ResponseEntity<Product>updateData(@PathVariable int productId, @RequestBody Product product) throws ProductRecordNotFound {
        Product product1=productServiceImpl.getDataById(productId).orElseThrow(()->new ProductRecordNotFound("ID DOES NOT EXIST"));
        product1.setProductName(product.getProductName());
        product1.setProductDate(product.getProductDate());
        product1.setProductArea(product.getProductArea());
        product1.setProductZone(product.getProductZone());

        return ResponseEntity.ok(productServiceImpl.updateData(product1));
    }
    @DeleteMapping("/{productId}")
    public ResponseEntity<String>deleteData(@PathVariable int productId){
        productServiceImpl.deleteData(productId);
        return ResponseEntity.ok("DATA DELETED SUCCESSFULLY");
    }
    @DeleteMapping("/deletealldata")
    public ResponseEntity<String>deleteAllData(@RequestBody  Product product){
        productServiceImpl.deleteAllData(product);
        return ResponseEntity.ok("DELETE ALL DATA SUCCESSFULLY");
    }
}

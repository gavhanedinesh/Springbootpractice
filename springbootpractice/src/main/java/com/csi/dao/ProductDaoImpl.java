package com.csi.dao;

import com.csi.model.Product;
import com.csi.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductDaoImpl {
    @Autowired
    ProductRepository productRepositoryImpl;

    public Product saveData(Product product){
        return productRepositoryImpl.save(product);
    }

    public List<Product>getAllData(){
        return productRepositoryImpl.findAll();
    }
    public Optional<Product>getdataById(int productId){
        return productRepositoryImpl.findById(productId);

    }
    public Product updateData(Product  product){
        return productRepositoryImpl.save(product);
    }
    public void deleteData(int productId){
         productRepositoryImpl.deleteById(productId);

    }
    public void deleteAllData(Product product){
        productRepositoryImpl.deleteAll();
    }


}

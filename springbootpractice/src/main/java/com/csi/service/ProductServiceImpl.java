package com.csi.service;

import com.csi.dao.ProductDaoImpl;
import com.csi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl {
    @Autowired
    ProductDaoImpl productDaoImpl;

    public Product saveData(Product product){
        return productDaoImpl.saveData(product);
    }

    public List<Product> getAllData(){
        return productDaoImpl.getAllData();
    }
    public Optional<Product> getDataById(int productId){
        return productDaoImpl.getdataById(productId);

    }
    public Product updateData(Product  product){
        return productDaoImpl.updateData(product);
    }
    public void deleteData(int productId){
        productDaoImpl.deleteData(productId);

    }
    public void deleteAllData(Product product){
        productDaoImpl.deleteAllData(product);
    }

}

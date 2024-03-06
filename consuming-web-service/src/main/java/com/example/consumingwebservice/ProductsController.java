package com.example.consumingwebservice;

import com.example.consumingwebservice.wsdl.GetProductResponse;
import com.example.consumingwebservice.wsdl.GetProductsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductsController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("get/{product_name}")
    public ResponseEntity<GetProductResponse> getByName(@PathVariable(name = "product_name") String productName){
        return ResponseEntity.ok(productClient.getProduct(productName));
    }

    @GetMapping("/get/products")
    public ResponseEntity<GetProductsResponse> getProducts(){
        return ResponseEntity.ok(productClient.getProducts());
    }

}

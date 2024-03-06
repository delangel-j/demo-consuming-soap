package com.example.consumingwebservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ProductConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.consumingwebservice.wsdl");
        return marshaller;

    }

    @Bean
    public ProductClient productClient(Jaxb2Marshaller marshaller){
        ProductClient productClient = new ProductClient();
        productClient.setDefaultUri("http://localhost:8080/ws");
        productClient.setMarshaller(marshaller);
        productClient.setUnmarshaller(marshaller);
        return productClient;
    }


}

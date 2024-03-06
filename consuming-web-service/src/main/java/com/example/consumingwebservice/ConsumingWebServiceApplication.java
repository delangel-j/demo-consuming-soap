package com.example.consumingwebservice;

import com.example.consumingwebservice.wsdl.GetProductResponse;
import com.example.consumingwebservice.wsdl.GetProductsResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ConsumingWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingWebServiceApplication.class, args);
	}
/**
	@Bean
	CommandLineRunner runner(ProductClient productClient){
		return args -> {
			System.out.println("jajaxd");
			String productName = "Azúcar Paramonga";
			if(args.length>0){
				productName = args[0];
			}
			GetProductResponse response = productClient.getProduct(productName);
			System.out.println(response.getProduct().getName());
			GetProductsResponse getProductsResponseList = productClient.getProducts();

			System.out.println("xd: " + getProductsResponseList.getProducts().get(0).getName());
		};
	}
**/
}

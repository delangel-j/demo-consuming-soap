package com.example.consumingwebservice;

import com.example.consumingwebservice.wsdl.GetProductRequest;
import com.example.consumingwebservice.wsdl.GetProductResponse;
import com.example.consumingwebservice.wsdl.GetProductsRequest;
import com.example.consumingwebservice.wsdl.GetProductsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.List;

public class ProductClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(ProductClient.class);


/*
    El WSDL contiene 2 métodos. Obtener todos los productos y obtener productos por nombre de producto
    los cuales estan asociados al achivo Service generado
    eeeeeeeeeeeeeeeeeeeeeoooooooooooooooooooo
*/
    public GetProductsResponse getProducts() {
        log.info("getproducts");

        //En el caso del GetAll solo se instancia el request
        GetProductsRequest getProductsRequest = new GetProductsRequest();

        return (GetProductsResponse) getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:8080/ws",
                getProductsRequest,
                new SoapActionCallback(null));

    }

    public GetProductResponse getProduct(String productName) {

        //Se crea el request y se le pasa el product name
        GetProductRequest request = new GetProductRequest();
        request.setName(productName);

        log.info("getproduct");
        return (GetProductResponse) getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:8080/ws",
                request,
                new SoapActionCallback(null));

    }

}

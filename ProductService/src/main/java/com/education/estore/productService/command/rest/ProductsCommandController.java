package com.education.estore.productService.command.rest;

import com.education.estore.productService.command.CreateProductCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductsCommandController {

    private final Environment env;
    private final CommandGateway commandGateway;

    @Autowired
    public ProductsCommandController(Environment env, CommandGateway commandGateway) {
        this.env = env;
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createProduct(@Valid @RequestBody CreateProductRestModel createProductRestModel) {
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .title(createProductRestModel.getTitle())
                .price(createProductRestModel.getPrice())
                .quantity((createProductRestModel.getQuantity()))
                .productId(UUID.randomUUID().toString())
        .build();
//        String returnValue;
//        try {
//            returnValue = commandGateway.sendAndWait(createProductCommand);
//        } catch (Exception ex) {
//            returnValue = ex.getLocalizedMessage();
//        }
        return commandGateway.sendAndWait(createProductCommand);
    }

//    @GetMapping
//    public String getProduct() {
//        //Debug
//        return "Http GET is handled on port # " + env.getProperty("local.server.port");
//    }
//
//    @PutMapping
//    public String updateProduct() {
//        return "Http PUT is handled";
//    }
//
//    @DeleteMapping
//    public String deleteProduct() {
//        return "Http DELETE is handled";
//    }
}

package com.education.estore.productService.command;

import com.education.estore.productService.core.data.ProductLookupEntity;
import com.education.estore.productService.core.data.ProductLookupRepository;
import com.education.estore.productService.core.events.ProductCreatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("product-group")
public class ProductLookupEventsHandler {

    private ProductLookupRepository productLookupRepository;

    @Autowired
    public ProductLookupEventsHandler(ProductLookupRepository productLookupRepository) {
        this.productLookupRepository = productLookupRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        ProductLookupEntity productEntity = new ProductLookupEntity(event.getProductId(), event.getTitle());
        productLookupRepository.save(productEntity);
    }
}

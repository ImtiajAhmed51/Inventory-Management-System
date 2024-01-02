package imtiaj.restController;

import imtiaj.model.ProductPricing;
import imtiaj.service.ProductPricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductPricingController {

    @Autowired
    private ProductPricingService productPricingService;

    @GetMapping("/productpricing")
    public List<ProductPricing> getAllProductPricing() {
        return productPricingService.findAll();
    }

    @GetMapping("/productpricing/{id}")
    public ProductPricing searchProductPricing(@PathVariable int id) {
        return productPricingService.findById(id);
    }

    @PostMapping("/productpricing")
    public void addProductPricing(@RequestBody ProductPricing productPricing) {
        productPricingService.create(productPricing);
    }

    @PutMapping("/productpricing/{id}")
    public void updateProductPricing(@RequestBody ProductPricing productPricing) {
        productPricingService.updateProductPricing(productPricing);
    }

    @DeleteMapping("/productpricing/{id}")
    public void deleteProductPricing(@RequestBody ProductPricing productPricing) {
        productPricingService.deleteProductPricing(productPricing);
    }

}

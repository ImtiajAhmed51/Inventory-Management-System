package imtiaj.restController;

import imtiaj.model.Product;
import imtiaj.model.TheLogConverter;
import imtiaj.service.ProductLogService;
import imtiaj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ProductController {


    @Autowired
    public ProductService productService;
    @Autowired
    private ProductLogService productLogService;


    @GetMapping("categories/{id}/products")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("categories/{id}/products/{id}")
    public Product searchProduct(@PathVariable int id) {
        return productService.find(id);
    }

    @PostMapping("categories/{id}/products")
    public void addProduct(@RequestBody Product product) {
        productService.create(product);
        productLogService.create(TheLogConverter.productLogConverter(product));
    }

    @PutMapping("categories/{id}/products/{id}")
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        productLogService.create(TheLogConverter.productLogConverter(product));
    }

    @DeleteMapping("categories/{id}/products/{id}")
    public void deleteProduct(@RequestBody Product product) {
        productService.deleteProduct(product);
        productLogService.create(TheLogConverter.productLogConverter(product));
    }


}

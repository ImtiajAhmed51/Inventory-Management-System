package imtiaj.restController;

import imtiaj.model.ProductInvoice;
import imtiaj.service.ProductInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductInvoiceController {
    @Autowired
    private ProductInvoiceService productInvoiceService;

    @GetMapping("/productinvoice")
    public List<ProductInvoice> getAllProductInvoice() {
        return productInvoiceService.findAll();
    }

    @GetMapping("/productinvoice/{id}")
    public ProductInvoice searchProductInvoice(@PathVariable int id) {
        return productInvoiceService.findById(id);
    }

    @PostMapping("/productinvoice")
    public void addProductInvoice(@RequestBody ProductInvoice productInvoice) {
        productInvoiceService.create(productInvoice);
    }

    @PutMapping("/productinvoice/{id}")
    public void updateProductInvoice(@RequestBody ProductInvoice productInvoice) {
        productInvoiceService.updateProductInvoice(productInvoice);
    }

    @DeleteMapping("/productinvoice/{id}")
    public void deleteProductInvoice(@RequestBody ProductInvoice productInvoice) {
        productInvoiceService.deleteProductInvoice(productInvoice);
    }

}

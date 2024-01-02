package imtiaj.restController;

import imtiaj.model.Supplier;
import imtiaj.model.TheLogConverter;
import imtiaj.service.SupplierLogService;
import imtiaj.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierController {

    @Autowired
    private SupplierService supplierService;
    @Autowired
    private SupplierLogService supplierLogService;

    @GetMapping("/suppliers")
    public List<Supplier> getAllSupplier() {
        return supplierService.findAll();
    }

    @GetMapping("/suppliers/{id}")
    public Supplier searchSupplier(@PathVariable int id) {
        return supplierService.findById(id);
    }

    @PostMapping("/suppliers")
    public void addCategory(@RequestBody Supplier supplier) {
        supplierService.create(supplier);
        supplierLogService.create(TheLogConverter.supplierLogConverter(supplier));
    }

    @PutMapping("/suppliers/{id}")
    public void updateCategory(@RequestBody Supplier supplier) {
        supplierService.updateSupplier(supplier);
        supplierLogService.create(TheLogConverter.supplierLogConverter(supplier));
    }

    @DeleteMapping("/suppliers/{id}")
    public void deleteCategory(@RequestBody Supplier supplier) {
        supplierService.deleteSupplier(supplier);
        supplierLogService.create(TheLogConverter.supplierLogConverter(supplier));
    }


}

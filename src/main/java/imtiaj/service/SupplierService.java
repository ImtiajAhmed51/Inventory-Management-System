package imtiaj.service;

import imtiaj.model.Supplier;
import imtiaj.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public void create(Supplier supplier) {
        supplierRepository.create(supplier);
    }


    public Supplier findById(int id) {
        return supplierRepository.findById(id);
    }

    public List<Supplier> findAll() {
        return supplierRepository.getAll();
    }

    public void updateSupplier(Supplier supplier) {

        supplierRepository.edit(supplier);
    }

    public void deleteSupplier(Supplier supplier) {

        supplierRepository.delete(supplier.getSupplierId());
    }
}

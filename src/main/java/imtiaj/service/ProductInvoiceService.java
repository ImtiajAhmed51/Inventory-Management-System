package imtiaj.service;

import imtiaj.model.ProductInvoice;
import imtiaj.repository.ProductInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProductInvoiceService {

    @Autowired
    private ProductInvoiceRepository productInvoiceRepository;

    public void create(ProductInvoice productInvoice) {
        productInvoiceRepository.create(productInvoice);
    }


    public ProductInvoice findById(int id) {
        return productInvoiceRepository.findById(id);
    }

    public List<ProductInvoice> findAll() {
        return productInvoiceRepository.getAll();
    }

    public void updateProductInvoice(ProductInvoice productInvoice) {
        productInvoiceRepository.edit(productInvoice);
    }

    public void deleteProductInvoice(ProductInvoice productInvoice) {
        productInvoiceRepository.delete(productInvoice.getRefId());
    }


}

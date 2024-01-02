package imtiaj.service;

import imtiaj.model.ProductPricing;
import imtiaj.repository.ProductPricingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProductPricingService {

    @Autowired
    private ProductPricingRepository productPricingRepository;


    public void create(ProductPricing productPricing) {
        productPricingRepository.create(productPricing);
    }


    public ProductPricing findById(int id) {
        return productPricingRepository.findById(id);
    }

    public List<ProductPricing> findAll() {
        return productPricingRepository.getAll();
    }

    public void updateProductPricing(ProductPricing productPricing) {
        productPricingRepository.edit(productPricing);
    }

    public void deleteProductPricing(ProductPricing productPricing) {
        productPricingRepository.delete(productPricing.getRefId());
    }


}

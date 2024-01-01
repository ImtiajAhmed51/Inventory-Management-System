package imtiaj.service;
import imtiaj.model.ProductLogEntity;
import imtiaj.repository.ProductLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProductLogService {
    @Autowired
    private ProductLogRepository productLogRepository;

    public void create(ProductLogEntity pricingLog) {
        productLogRepository.create(pricingLog);
    }


    public ProductLogEntity findById(int id) {
        return productLogRepository.findById(id);
    }

    public List<ProductLogEntity> findAll() {
        return productLogRepository.getAll();
    }

    public void updateProductLog(ProductLogEntity productLog) {
        productLogRepository.edit(productLog);
    }

    public void deleteProductLog(ProductLogEntity productLog) {
        productLogRepository.delete(productLog.getProductId());
    }


}

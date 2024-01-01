package imtiaj.service;
import imtiaj.model.Pricing;
import imtiaj.repository.PricingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PricingService {

    @Autowired
    private PricingRepository pricingRepository;



    public void create(Pricing pricing) {
        pricingRepository.create(pricing);
    }


    public List<Pricing> findAll() {
        return pricingRepository.getAll();
    }

    public Pricing find(int id) {
        return pricingRepository.findById(id);
    }

    public void updatePricing(Pricing pricing) {
        pricingRepository.edit(pricing);
    }

    public void deletePricing(Pricing pricing) {
        pricingRepository.delete(pricing.getPricingId());
    }


}

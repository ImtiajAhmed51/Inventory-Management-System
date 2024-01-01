package imtiaj.restController;
import imtiaj.model.Pricing;
import imtiaj.model.TheLogConverter;
import imtiaj.service.PricingLogService;
import imtiaj.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PricingController {


    @Autowired
    public PricingService pricingService;
    @Autowired
    private PricingLogService pricingLogService;

    @GetMapping("/categories/{id}/products/{id}/pricings")
    public List<Pricing> getAllPricing() {
        return pricingService.findAll();
    }


    @GetMapping("/categories/{id}/products/{id}/pricings/{id}")
    public Pricing searchPricing(@PathVariable int id) {
        return pricingService.find(id);
    }

    @PostMapping("/categories/{id}/products/{id}/pricings")
    public void addPricing(@RequestBody Pricing pricing) {
        pricingService.create(pricing);
        pricingLogService.create(TheLogConverter.pricingLogLogConverter(pricing));
    }

    @PutMapping("/categories/{id}/products/{id}/pricings/{id}")
    public void updateCategory(@RequestBody Pricing pricing) {
        pricingService.updatePricing(pricing);
        pricingLogService.create(TheLogConverter.pricingLogLogConverter(pricing));
    }

    @DeleteMapping("/categories/{id}/products/{id}/pricings/{id}")
    public void deletePricing(@RequestBody Pricing pricing) {
        pricingService.deletePricing(pricing);
        pricingLogService.create(TheLogConverter.pricingLogLogConverter(pricing));
    }


}


package imtiaj.service;

import imtiaj.model.PricingLogEntity;
import imtiaj.repository.PricingLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class PricingLogService {

    @Autowired
    private PricingLogRepository pricingLogRepository;

    public void create(PricingLogEntity pricingLog) {
        pricingLogRepository.create(pricingLog);
    }


    public PricingLogEntity findById(int id) {
        return pricingLogRepository.findById(id);
    }

    public Iterable<PricingLogEntity> findAll() {
        return pricingLogRepository.getAll();
    }

    public void updatePricingLog(PricingLogEntity pricingLog) {
        pricingLogRepository.edit(pricingLog);
    }

    public void deletePricingLog(PricingLogEntity pricingLog) {
        pricingLogRepository.delete(pricingLog.getPricingId());
    }


}

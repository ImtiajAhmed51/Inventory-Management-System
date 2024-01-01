package imtiaj.service;

import imtiaj.model.StockLogEntity;
import imtiaj.repository.StockLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class StockLogService {
    @Autowired
    private StockLogRepository stockLogRepository;

    public void create(StockLogEntity stockLog) {
        stockLogRepository.create(stockLog);
    }


    public StockLogEntity findById(int id) {
        return stockLogRepository.findById(id);
    }

    public List<StockLogEntity> findAll() {
        return stockLogRepository.getAll();
    }

    public void updateStockLog(StockLogEntity stockLog) {
        stockLogRepository.edit(stockLog);
    }

    public void deleteStockLog(StockLogEntity stockLog) {
        stockLogRepository.delete(stockLog.getRefId());
    }


}

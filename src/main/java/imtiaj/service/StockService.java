package imtiaj.service;

import imtiaj.model.Stock;
import imtiaj.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public void create(Stock stock) {
        stockRepository.create(stock);
    }

    public Stock findById(int id) {
        return stockRepository.findById(id);
    }

    public List<Stock> findAll() {
        return stockRepository.getAll();
    }

    public void updateStock(Stock stock) {
        stockRepository.edit(stock);
    }

    public void deleteStock(Stock stock) {
        stockRepository.delete(stock.getRefId());
    }


}

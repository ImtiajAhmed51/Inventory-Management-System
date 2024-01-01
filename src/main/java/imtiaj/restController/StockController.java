package imtiaj.restController;
import imtiaj.model.Stock;
import imtiaj.model.TheLogConverter;
import imtiaj.service.StockLogService;
import imtiaj.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StockController {
    @Autowired
    private StockService stockService;
    @Autowired
    private StockLogService stockLogService;

    @GetMapping("/stocks")
    public List<Stock> getAllStock() {
        return stockService.findAll();
    }

    @GetMapping("/stocks/{id}")
    public Stock searchStock(@PathVariable int id) {
        return stockService.findById(id);
    }

    @PostMapping("/stocks")
    public void addStock(@RequestBody Stock stock) {
        stockService.create(stock);
        stockLogService.create(TheLogConverter.stockLogConverter(stock));
    }

    @PutMapping("/stocks/{id}")
    public void updateStock(@RequestBody Stock stock) {
        stockService.updateStock(stock);
        stockLogService.create(TheLogConverter.stockLogConverter(stock));
    }

    @DeleteMapping("/stocks/{id}")
    public void deleteStock(@RequestBody Stock stock) {
        stockService.deleteStock(stock);
        stockLogService.create(TheLogConverter.stockLogConverter(stock));
    }

}

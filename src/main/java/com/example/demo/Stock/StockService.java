package com.example.demo.Stock;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {
    private final StockRepository stockRepository;
    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getstocks(){
        return stockRepository.findAll();
    }

    public void addNewStock(Stock stock) {
        Optional<Stock> stockBySymbol = stockRepository
                .findStockBySymbol(stock.getSymbol());
        if(stockBySymbol.isPresent()){
            System.out.println("Symbol taken");
            throw new IllegalStateException("Symbol taken");
        }
        stockRepository.save(stock);
        System.out.println(stock);
    }

    public void deleteStock(Long stockId) {
        System.out.println("entered deletestock");
      boolean stockExists =  stockRepository.existsById(stockId);
        System.out.println(stockExists);
      if(!stockExists){
          throw new IllegalStateException("stock with id="+ stockId + " does not exist");
      }
      stockRepository.deleteById(stockId);
    }
    @Transactional
    public  void updateStock(Long stockId){
        boolean stockExists =  stockRepository.existsById(stockId);
        if(!stockExists){
            throw new IllegalStateException("stock with id="+ stockId + " does not exist");
        }
        Stock stock = stockRepository.findById(stockId)
                        .orElseThrow(()->new IllegalStateException(
                                "student with id "+stockId+" does not exist"
        ) );
        stock.setName("NEW");
        stock.setCountry("India");



    }
}

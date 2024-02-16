package com.example.demo.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/stocks")
public class StockController {
    private final StockService stockService;
    @Autowired
    public StockController(StockService stockService){
        this.stockService=stockService;
    }
    @GetMapping
    public List<Stock> getstocks(){
        return stockService.getstocks();
    }
    @PostMapping
    public  void registerNewStock(@RequestBody Stock stock){
        stockService.addNewStock(stock);
    }
    //trying to put stock to html

    @DeleteMapping(path = "{stockId}")
    public  void  deleteStock(@PathVariable("stockId") Long stockId){
        stockService.deleteStock(stockId);
    }
    @PutMapping(path = "{stockId}")
    public  void updateStock(@PathVariable("stockId") Long stockId){
        stockService.updateStock(stockId);
    }
}

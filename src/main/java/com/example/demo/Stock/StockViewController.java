package com.example.demo.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StockViewController {
    private final StockService stockService;
    @Autowired
    public StockViewController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stockList")
    public String getstockshtml(Model model){
        List<Stock> stocks = stockService.getstocks();
        System.out.println("stocks from stock-view"+stocks.toString());
        model.addAttribute("stocks",stocks);
        return "stockView";
    }

}


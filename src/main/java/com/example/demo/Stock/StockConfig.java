package com.example.demo.Stock;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StockConfig {

    @Bean
    CommandLineRunner commandLineRunner(StockRepository stockRepository){
        return args->{
            Stock stock = StockHistoricalData.getStock();
            stockRepository.save(stock);
        };

    }
}

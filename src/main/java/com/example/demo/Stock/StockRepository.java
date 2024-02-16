package com.example.demo.Stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository
        extends JpaRepository<Stock,Long>{
    //checking if stock exist in database
    //same as the query SELECT * FROM Stock where symbol=?
    @Query("SELECT s FROM Stock  s WHERE s.Symbol=?1" )
    Optional<Stock> findStockBySymbol(String symbol);
}

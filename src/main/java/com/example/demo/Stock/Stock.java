package com.example.demo.Stock;

import jakarta.persistence.*;
import org.w3c.dom.Text;

@Entity
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Symbol;
    private String Name;
//    @Lob
//    @Column(name = "Description", columnDefinition="CLOB")
    @Column(length = Integer.MAX_VALUE)
    private String Description;
    private  String Currency;
    private  String Country;
    private  String Sector;
    private Double EPS;
    private Double BookValue;
    private String Address;

    public Stock() { }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getSymbol() {
        return Symbol;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "Id=" + Id +
                ", Symbol='" + Symbol + '\'' +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", Currency='" + Currency + '\'' +
                ", Country='" + Country + '\'' +
                ", Sector='" + Sector + '\'' +
                ", EPS=" + EPS +
                ", BookValue=" + BookValue +
                ", Address='" + Address + '\'' +
                '}';
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String sector) {
        Sector = sector;
    }

    public Double getEPS() {
        return EPS;
    }

    public void setEPS(Double EPS) {
        this.EPS = EPS;
    }

    public Double getBookValue() {
        return BookValue;
    }

    public void setBookValue(Double bookValue) {
        BookValue = bookValue;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Stock(String symbol, String name, String description, String currency, String country, String sector, Double EPS, Double bookValue, String address) {
        Symbol = symbol;
        Name = name;
        Description = description;
        Currency = currency;
        Country = country;
        Sector = sector;
        this.EPS = EPS;
        BookValue = bookValue;
        Address = address;
    }

    public Stock(Long id, String symbol, String name, String description, String currency, String country, String sector, Double EPS, Double bookValue, String address) {
        Id = id;
        Symbol = symbol;
        Name = name;
        Description = description;
        Currency = currency;
        Country = country;
        Sector = sector;
        this.EPS = EPS;
        BookValue = bookValue;
        Address = address;
    }
}

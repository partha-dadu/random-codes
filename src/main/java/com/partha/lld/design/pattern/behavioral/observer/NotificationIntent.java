package com.partha.lld.design.pattern.behavioral.observer;

public class NotificationIntent {
    public String productName;
    public StockType stockType;

    public NotificationIntent(String productName, StockType stockType) {
        this.productName = productName;
        this.stockType = stockType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public StockType getStockType() {
        return stockType;
    }

    public void setStockType(StockType stockType) {
        this.stockType = stockType;
    }
}

enum StockType{
    IN_STOCK, OUT_OF_STOCK;
}

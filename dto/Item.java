package com.sg.vendingmachine.dto;

import java.math.BigDecimal;

public class Item {

    private String itemName;
    private BigDecimal itemPrice;
    private long itemStock;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public long getItemStock() {
        return itemStock;
    }

    public void setItemStock(long itemStock) {
        this.itemStock = itemStock;
    }

    public Item(String itemName, BigDecimal itemPrice, long itemStock) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemStock = itemStock;
    }
}

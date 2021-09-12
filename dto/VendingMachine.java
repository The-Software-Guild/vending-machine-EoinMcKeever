package com.sg.vendingmachine.dto;

import java.math.BigDecimal;

public class VendingMachine {

    private long vendingMachineId;
    private Item mars = new Item("Mars",new BigDecimal("1.2"), 10);
    private Item tayto = new Item("Tayto", new BigDecimal("0.9"), 2);
    private Item haribo = new Item("Haribo", new BigDecimal("1.0"), 1);
    private BigDecimal insertedMoney;

    public BigDecimal getInsertedMoney() {
        return insertedMoney;
    }

    public BigDecimal getRelevantItemUpdateStock(String itemName) {
        if(itemName == mars.getItemName()){
            mars.setItemStock(mars.getItemStock()-1);
            return mars.getItemPrice();
        } else if (itemName == tayto.getItemName()) {
            tayto.setItemStock(tayto.getItemStock()-1);
            return tayto.getItemPrice();
        } else if (itemName == haribo.getItemName()) {
            haribo.setItemStock(haribo.getItemStock() - 1);
            return haribo.getItemPrice();
        }

        return null;
    }

    public BigDecimal getRelevantItemCost(String itemName) {
        if(itemName == mars.getItemName()){
            return mars.getItemPrice();
        } else if (itemName == tayto.getItemName()) {
            return tayto.getItemPrice();
        } else if (itemName == haribo.getItemName()) {
            return haribo.getItemPrice();
        }

        return null;
    }

    public void setInsertedMoney(BigDecimal insertedMoney) {
        this.insertedMoney = insertedMoney;
    }


    public VendingMachine(long vendingMachineId) {
        this.vendingMachineId = vendingMachineId;
    }

    public long getVendingMachineId() {
        return vendingMachineId;
    }

    public Item getMars() {
        return mars;
    }

    public void setMars(Item mars) {
        this.mars = mars;
    }

    public Item getTayto() {
        return tayto;
    }

    public void setTayto(Item tayto) {
        this.tayto = tayto;
    }

    public Item getHaribo() {
        return haribo;
    }

    public void setHaribo(Item haribo) {
        this.haribo = haribo;
    }
    }

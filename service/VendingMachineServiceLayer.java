package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;

import java.math.BigDecimal;

public interface VendingMachineServiceLayer {

    void createVendingMachine();

    int transaction(int choice) throws VendingMachinePersistenceException;

    public void insertMoney(BigDecimal moneys) throws VendingMachinePersistenceException;

    BigDecimal getChange() throws VendingMachinePersistenceException;

    }


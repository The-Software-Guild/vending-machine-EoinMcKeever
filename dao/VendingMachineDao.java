package com.sg.vendingmachine.dao;

import java.math.BigDecimal;

public interface VendingMachineDao {

    BigDecimal insertMoney(BigDecimal insertMoney) throws VendingMachinePersistenceException;

    void createVendingMachine();

    void transaction(String choice) throws VendingMachinePersistenceException;

    int verifyTransaction(String itemName);

    BigDecimal getChange() throws VendingMachinePersistenceException;

    int stockCheck(String itemName);


}

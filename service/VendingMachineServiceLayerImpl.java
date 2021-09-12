package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;

import java.math.BigDecimal;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer{

    VendingMachineDao dao;
    private VendingMachineAuditDao auditDao;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void createVendingMachine() {
        dao.createVendingMachine();
    }

    @Override
    public int transaction(int choice) throws VendingMachinePersistenceException {
        switch (choice) {
            case 1:
                int marsTransactionCheck = 0;
                    int marsStockCheck = dao.stockCheck("Mars");
                    marsTransactionCheck = dao.verifyTransaction( "Mars");
                if (marsTransactionCheck ==  -1 || marsStockCheck == -1) {
                    return -1;
                }else {
                    dao.transaction("Mars");
                    return 1;
                }
            case 2:
                int taytoStockCheck = dao.stockCheck("Tayto");
                int taytoTransactionCheck = dao.verifyTransaction( "Tayto");
                if (taytoTransactionCheck ==  -1 || taytoStockCheck == -1) {
                    return -1;
                }else {
                    dao.transaction("Tayto");
                    return 1;
                }

            case 3:
                int hariboStockCheck = dao.stockCheck("Haribo");
                int hariboTransactionCheck = dao.verifyTransaction( "Haribo");
                if (hariboTransactionCheck ==  -1 || hariboStockCheck == -1 )  {
                    return -1;
                }else {
                    dao.transaction("Haribo");
                    return 1;
                }

            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
    }

    public void insertMoney(BigDecimal moneys) throws VendingMachinePersistenceException {
        dao.insertMoney(moneys);
    }

    public BigDecimal getChange() throws VendingMachinePersistenceException {
        return dao.getChange();
    }
}

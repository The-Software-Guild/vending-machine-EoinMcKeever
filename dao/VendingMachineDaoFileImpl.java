package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.VendingMachine;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VendingMachineDaoFileImpl implements VendingMachineDao{

    private VendingMachine theVendoExtrodo;


    @Override
    public void createVendingMachine() {
        theVendoExtrodo = new VendingMachine(1);
    }

    public VendingMachineDaoFileImpl(VendingMachine theVendoExtrodo) {
        this.theVendoExtrodo = theVendoExtrodo;
    }

    @Override
    public BigDecimal insertMoney(BigDecimal insertMoney) throws VendingMachinePersistenceException {
        theVendoExtrodo.setInsertedMoney(insertMoney);
        return insertMoney;
    }

    @Override
    public BigDecimal getChange() throws VendingMachinePersistenceException {
        return theVendoExtrodo.getInsertedMoney();

    }

    @Override
    public int stockCheck(String itemName) {
        if(theVendoExtrodo.getMars().getItemName() == itemName && (theVendoExtrodo.getMars().getItemStock()-1) < 0 ) {
            return -1;
        } else if (theVendoExtrodo.getTayto().getItemName() == itemName && theVendoExtrodo.getTayto().getItemStock()-1 < 0 ) {
            return -1;
        } else if (theVendoExtrodo.getHaribo().getItemName() == itemName && theVendoExtrodo.getHaribo().getItemStock()-1 < 0 ) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public void transaction(String choice) throws VendingMachinePersistenceException {
        BigDecimal cost = theVendoExtrodo.getRelevantItemUpdateStock(choice);
        writeAuditEntry(theVendoExtrodo.getMars().getItemName() + " price:" + theVendoExtrodo.getMars().getItemPrice() +  ", stock:" + theVendoExtrodo.getMars().getItemStock());
        writeAuditEntry(theVendoExtrodo.getTayto().getItemName() + " price:" + theVendoExtrodo.getTayto().getItemPrice() +  ", stock:" + theVendoExtrodo.getTayto().getItemStock());
        writeAuditEntry(theVendoExtrodo.getHaribo().getItemName() + " price:" + theVendoExtrodo.getHaribo().getItemPrice() +  ", stock:" + theVendoExtrodo.getHaribo().getItemStock());
        BigDecimal insertedMoney = (theVendoExtrodo.getInsertedMoney()) ;
        insertedMoney = insertedMoney.subtract(cost);
        System.out.println("You have "+ insertedMoney + " remaining" );
        theVendoExtrodo.setInsertedMoney(insertedMoney);

    }


    @Override
    public int verifyTransaction(String choice) {

            if (theVendoExtrodo.getInsertedMoney().subtract(theVendoExtrodo.getRelevantItemCost(choice)).compareTo(BigDecimal.ZERO) == -1 && choice == theVendoExtrodo.getMars().getItemName()) {
                return -1;
            } else if (theVendoExtrodo.getInsertedMoney().subtract(theVendoExtrodo.getRelevantItemCost(choice)).compareTo(BigDecimal.ZERO) == -1 && choice == theVendoExtrodo.getTayto().getItemName()) {
                return -1;
            } else if (theVendoExtrodo.getInsertedMoney().subtract(theVendoExtrodo.getRelevantItemCost(choice)).compareTo(BigDecimal.ZERO) == -1 && choice == theVendoExtrodo.getHaribo().getItemName()) {
                return -1;
            } else {
                return 1;}

        }





    public static final String AUDIT_FILE = "audit.txt";
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("Could not persist audit information.", e);
        }

        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }



}

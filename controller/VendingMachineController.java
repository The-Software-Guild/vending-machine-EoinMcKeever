package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.ui.VendingMachineView;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;

import java.math.BigDecimal;

public class VendingMachineController {

    private VendingMachineView view;
    private VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }

    public void run() throws VendingMachinePersistenceException {
        boolean keepGoing = true;
        int menuSelection = 0;

        createVendingMachine();

        insertMoneyCommand();
        while (keepGoing) {



            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    transaction(1);
                    break;
                case 2:
                    transaction(2);
                    break;
                case 3:
                    transaction(3);
                    break;
                case 4:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();

            }

        }

        getChange();
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void insertMoneyCommand() throws VendingMachinePersistenceException {
        BigDecimal moneys = view.printInsertMoneyAndGetInsertMoney();
        service.insertMoney(moneys);
    }

    private void createVendingMachine() {
        service.createVendingMachine();
    }

    private void transaction(int choice) throws VendingMachinePersistenceException {
        int valid = service.transaction(choice);
        if(valid == -1) {
            view.DisplayInsufficientMessage();
        }
        else {
            view.displayVendedItemBanner();
            view.DisplaySuccessfulTransactionMessage();
        }

    }

    private void getChange() throws VendingMachinePersistenceException {
        BigDecimal change = service.getChange();
        view.displayChange(change);
    }

}





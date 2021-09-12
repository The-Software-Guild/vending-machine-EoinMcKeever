package com.sg.vendingmachine.ui;

import java.math.BigDecimal;

public class VendingMachineView {

    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("1. Mars: 1.2" );
        io.print("2. Tayto: 0.9");
        io.print("3. Haribos: 1.0");
        io.print("4. Exit and get change");


        return io.readInt("Please select from the above choices of delicacies .", 1, 4);
    }
    public void displayVendedItemBanner() {
        io.print("Vending... ");
    }

    public void displayChange(BigDecimal change) {
        System.out.println("Your change is " + change);
    }

    public void DisplayInsufficientMessage() {
        io.print("Transaction failed, please check you have sufficient funds for this item. We may also be out of stock of this item. If so please select another item. ");
    }

    public void DisplaySuccessfulTransactionMessage() {
        io.print("Great success");
    }


    public BigDecimal printInsertMoneyAndGetInsertMoney() {
        BigDecimal inserted = io.readBigDecimal("Please insert the funds you plan on spending");
        System.out.println("You inserted " + inserted + " moneys");
        return inserted;


    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }


    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

}

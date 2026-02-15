package org.example.LLD_Design_pattern.Chain_of_Responsibility.ATM_Cash_Dispenser;

public class ATMDemo {
    public static void main(String[] args) {
        ATMMachine atm = new ATMMachine();

        System.out.println("--- Scenario 1: Successful Withdrawal ---");
        atm.insertCard();
        atm.enterPin(1234);
        atm.withdraw(3700); // Should use 1x2000, 3x500, 1x200

        System.out.println("\n--- Scenario 2: Try to withdraw without card ---");
        atm.withdraw(500);

        System.out.println("\n--- Scenario 3: Incorrect PIN ---");
        atm.insertCard();
        atm.enterPin(1111);
        atm.enterPin(1234); // Correct now
        atm.withdraw(100000); // Should fail due to inventory

        System.out.println("\n--- Scenario 4: Multiple of 100 check ---");
        atm.insertCard();
        atm.enterPin(1234);
        atm.withdraw(550); // Should fail (no 50 rupee notes)


    }
}
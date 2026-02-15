package org.example.LLD_Design_pattern.Chain_of_Responsibility.ATM_Cash_Dispenser;

public class AuthenticatedState implements ATMState {
    private final ATMMachine atm;

    public AuthenticatedState(ATMMachine atm) { this.atm = atm; }

    @Override
    public void withdrawCash(int amount) {
        if (amount <= 0 || amount % 100 != 0) {
            System.err.println("Invalid amount. Must be a multiple of 100.");
            return;
        }

        System.out.println("Processing withdrawal of ₹" + amount + "...");
        
        // Step 1: Validate if the chain can actually fulfill the request
        if (atm.getDispenserChain().canHandle(amount)) {
            atm.getDispenserChain().dispense(amount);
            System.out.println("Transaction Successful.");
            ejectCard(); // Auto-eject on success
        } else {
            System.err.println("Transaction Failed: Inadequate denomination breakdown or cash exhausted.");
        }
    }

    @Override public void insertCard() { System.out.println("Error: Card already present."); }
    @Override public void authenticatePin(int pin) { System.out.println("Note: Already authenticated."); }
    
    @Override
    public void ejectCard() {
        System.out.println("Ejecting card... Please collect it.");
        atm.setCurrentState(atm.getIdleState());
    }
}
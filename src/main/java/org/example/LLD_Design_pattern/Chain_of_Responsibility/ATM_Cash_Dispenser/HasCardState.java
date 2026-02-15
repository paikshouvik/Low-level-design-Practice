package org.example.LLD_Design_pattern.Chain_of_Responsibility.ATM_Cash_Dispenser;

class HasCardState implements ATMState {
    private final ATMMachine atm;

    public HasCardState(ATMMachine atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Error: Card already in slot.");
    }

    @Override
    public void authenticatePin(int pin) {
        // In a real app, you'd validate against a DB/Service here
        if (pin == 1234) {
            System.out.println("PIN Correct. Access Granted.");
            atm.setCurrentState(atm.getAuthenticatedState());
        } else {
            System.out.println("Incorrect PIN. Try again.");
            // Optional: eject card after 3 failed attempts
        }
    }

    @Override
    public void withdrawCash(int amount) {
        System.out.println("Please enter PIN first.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card Ejected.");
        atm.setCurrentState(atm.getIdleState());
    }
}
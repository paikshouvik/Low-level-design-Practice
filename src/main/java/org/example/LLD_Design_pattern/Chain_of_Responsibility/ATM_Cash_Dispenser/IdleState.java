package org.example.LLD_Design_pattern.Chain_of_Responsibility.ATM_Cash_Dispenser;

class IdleState implements ATMState {
    private ATMMachine atm;

    public IdleState(ATMMachine atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Card Inserted.");
        atm.setCurrentState(atm.getHasCardState());
    }

    @Override
    public void authenticatePin(int pin) {
        System.out.println("Insert card first.");
    }

    @Override
    public void withdrawCash(int amount) {
        System.out.println("Insert card first.");
    }

    @Override
    public void ejectCard() {
        System.out.println("No card to eject.");
    }
}

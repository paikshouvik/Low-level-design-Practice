package org.example.LLD_Design_pattern.Chain_of_Responsibility.ATM_Cash_Dispenser;

public interface ATMState {
    void insertCard();
    void authenticatePin(int pin);
    void withdrawCash(int amount);
    void ejectCard();
}
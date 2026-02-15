package org.example.LLD_Design_pattern.Chain_of_Responsibility.ATM_Cash_Dispenser;

import lombok.Getter;
import lombok.Setter;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@Setter
public class ATMMachine {
    private ATMState idleState;
    private ATMState hasCardState;
    private ATMState authenticatedState;

    private ATMState currentState;
    private CashHandler dispenserChain;
    private final ReentrantLock lock = new ReentrantLock();

    public ATMMachine() {
        idleState = new IdleState(this);
        hasCardState = new HasCardState(this);
        authenticatedState = new AuthenticatedState(this);
        
        currentState = idleState;
        initializeDispenserChain();
    }

    private void initializeDispenserChain() {
        CashHandler c2000 = new Rupee2000Handler(10); // 10 notes
        CashHandler c500 = new Rupee500Handler(20);  // 20 notes
        CashHandler c100 = new Rupee100Handler(50);  // 50 notes
        CashHandler c200 = new Rupee200Handler(50);  // 50 notes

        c2000.setNextHandler(c500);
        c500.setNextHandler(c200);
        c200.setNextHandler(c100);

        this.dispenserChain = c2000;
    }

    // Thread-safe entry points
    public void insertCard() { 
        lock.lock();
        try { currentState.insertCard(); } 
        finally { lock.unlock(); }
    }

    public void enterPin(int pin) {
        lock.lock();
        try { currentState.authenticatePin(pin); }
        finally { lock.unlock(); }
    }

    public void withdraw(int amount) {
        lock.lock();
        try { currentState.withdrawCash(amount); }
        finally { lock.unlock(); }
    }
}
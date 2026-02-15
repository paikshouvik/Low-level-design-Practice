package org.example.LLD_Design_pattern.Chain_of_Responsibility.ATM_Cash_Dispenser;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class CashHandler {
    protected CashHandler nextHandler;
    protected final int denomination;
    protected AtomicInteger inventory;

    public CashHandler(int denomination, int initialStock) {
        this.denomination = denomination;
        this.inventory = new AtomicInteger(initialStock);
    }

    public void setNextHandler(CashHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // New logic: Check if the amount can be handled BEFORE deducting inventory
    public boolean canHandle(int amount) {
        int notesNeeded = amount / denomination;
        int notesToUse = Math.min(notesNeeded, inventory.get());
        int remaining = amount - (notesToUse * denomination);

        if (remaining == 0) return true;
        return nextHandler != null && nextHandler.canHandle(remaining);
    }

    public void dispense(int amount) {
        int notesNeeded = amount / denomination;
        int available = inventory.get();
        int notesToDispense = Math.min(notesNeeded, available);
        
        if (notesToDispense > 0) {
            inventory.addAndGet(-notesToDispense);
            System.out.println("   - Dispensing " + notesToDispense + " notes of ₹" + denomination);
            amount -= (notesToDispense * denomination);
        }

        if (amount > 0 && nextHandler != null) {
            nextHandler.dispense(amount);
        }
    }
}
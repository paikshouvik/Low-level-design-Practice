package org.example.LLD_Design_pattern.State.Order_Tracking;

import java.util.Map;
import java.util.HashMap;
import java.util.function.Supplier;

/**
 * OrderStateFactory: Responsible for rehydrating State objects
 * from persistence (Database strings).
 */
public class OrderStateFactory {

    // Using a Map of Suppliers to avoid creating new objects unnecessarily
    // or to handle complex instantiation if needed.
    private static final Map<String, Supplier<OrderState>> STATE_MAP = new HashMap<>();

    static {
        STATE_MAP.put("CREATED", CreatedState::new);
        STATE_MAP.put("CONFIRMED", ConfirmedState::new);
        STATE_MAP.put("SHIPPED", ShippedState::new);
        STATE_MAP.put("DELIVERED", DeliveredState::new);
        STATE_MAP.put("CANCELLED", CancelledState::new);
    }

    /**
     * Reconstructs the state object based on the status string from the DB.
     * @param status The string status stored in the database.
     * @return The concrete implementation of OrderState.
     */
    public static OrderState getResolvedState(String status) {
        Supplier<OrderState> stateSupplier = STATE_MAP.get(status.toUpperCase());

        if (stateSupplier == null) {
            // Lead Tip: Use a custom Domain Exception for better error tracking
            throw new IllegalArgumentException("Invalid Order Status: " + status);
        }

        return stateSupplier.get();
    }
}
package org.example.LLD_Design_pattern.State.Elevator_System;

public class HighTechBuilding {
    public static void main(String[] args) {
        ElevatorManager manager = ElevatorManager.getInstance();

        // Scenario 1: Someone on floor 10 wants to go UP
        manager.externalRequest(10, Direction.UP);

        // Scenario 2: Someone on floor 50 wants to go DOWN
        manager.externalRequest(50, Direction.DOWN);

        // Scenario 3: Someone already inside Elevator 1 wants floor 15
        // (Typically managed by the elevator instance itself)
        
        // Let's trigger movement simulation
        // In a real system, this would be a thread or event-loop
    }
}
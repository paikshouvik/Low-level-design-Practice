package org.example.LLD_Design_pattern.State.Elevator_System;

import lombok.Data;

import java.util.TreeSet;

@Data
public class Elevator {
    private final int id;
    private int currentFloor = 0;
    private Direction direction = Direction.IDLE;
    private ElevatorState currentState;

    // Use TreeSets to keep stops sorted (SCAN algorithm)
    private TreeSet<Integer> upStops = new TreeSet<>();
    private TreeSet<Integer> downStops = new TreeSet<>((a, b) -> b - a);

    public Elevator(int id) {
        this.id = id;
        this.currentState = new IdleState();
    }

    public void addRequest(int floor) {
        if (floor > currentFloor) upStops.add(floor);
        else if (floor < currentFloor) downStops.add(floor);
        
        // If IDLE, trigger movement
        if (direction == Direction.IDLE) {
            this.pressButton(floor); 
        }
    }

    // Delegation to State
    public void pressButton(int floor) { currentState.pressButton(this, floor); }
    public void openDoor() { currentState.openDoor(this); }
    public void closeDoor() { currentState.closeDoor(this); }
    public void move() { currentState.move(this); }
    public void stop() { currentState.stop(this); }

    // Logic to decide next destination
    public Integer getNextTarget() {
        if (direction == Direction.UP || direction == Direction.IDLE) {
            if (!upStops.isEmpty()) return upStops.first();
            if (!downStops.isEmpty()) return downStops.first();
        } else {
            if (!downStops.isEmpty()) return downStops.first();
            if (!upStops.isEmpty()) return upStops.first();
        }
        return null;
    }

    public void popTarget(int floor) {
        upStops.remove(floor);
        downStops.remove(floor);
    }

    public void setTargetFloor(int floor) {
        if (floor > currentFloor) upStops.add(floor);
        else if (floor < currentFloor) downStops.add(floor);
    }
}


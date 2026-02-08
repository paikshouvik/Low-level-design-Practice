package org.example.LLD_Design_pattern.State.Elevator_System;

class DoorOpenState implements ElevatorState {
    public void pressButton(Elevator e, int f) {
        System.out.println("Close doors first.");
    }

    public void openDoor(Elevator e) {
        System.out.println("Already open.");
    }

    public void closeDoor(Elevator e) {
        e.setCurrentState(new IdleState());
    }

    public void move(Elevator e) {
        System.out.println("Safety Alert: Cannot move with doors open!");
    }

    public void stop(Elevator e) {
        System.out.println("Stopped.");
    }

    public String getStatus() {
        return "DOOR_OPEN";
    }
}
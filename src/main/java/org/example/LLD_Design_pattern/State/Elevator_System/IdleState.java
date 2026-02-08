package org.example.LLD_Design_pattern.State.Elevator_System;

// --- IDLE STATE ---
class IdleState implements ElevatorState {
    public void pressButton(Elevator e, int f) {
        e.setTargetFloor(f);
        e.setCurrentState(new MovingState());
        e.move();
    }
    public void openDoor(Elevator e) { e.setCurrentState(new DoorOpenState()); }
    public void closeDoor(Elevator e) { System.out.println("Doors already closed."); }
    public void move(Elevator e) { e.setCurrentState(new MovingState()); }
    public void stop(Elevator e) { System.out.println("Already idle."); }
    public String getStatus() { return "IDLE"; }
}

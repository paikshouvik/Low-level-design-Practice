package org.example.LLD_Design_pattern.State.Elevator_System;

public interface ElevatorState {
    void pressButton(Elevator elevator, int floor);
    void openDoor(Elevator elevator);
    void closeDoor(Elevator elevator);
    void move(Elevator elevator);
    void stop(Elevator elevator);
    String getStatus();
}
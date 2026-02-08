package org.example.LLD_Design_pattern.State.Elevator_System;

import java.util.List;

public interface FindElevatorStrategy {

    public Elevator findBestElevator(List<Elevator> elevators, int floor, Direction direction);
}

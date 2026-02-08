package org.example.LLD_Design_pattern.State.Elevator_System;

import java.util.List;

public class SimpleFindElevatorStrategy implements FindElevatorStrategy {

    public Elevator findBestElevator(List<Elevator> elevators, int floor, Direction direction) {
        Elevator selected = null;
        int minDistance = 101; // Max floors + 1

        for (Elevator e : elevators) {
            int distance = Math.abs(e.getCurrentFloor() - floor);

            // SCORE LOGIC:
            // 1. If Elevator is IDLE, it's a good candidate.
            // 2. If Elevator is moving TOWARDS the floor in the SAME direction, it's perfect.
            boolean isMovingTowards = (e.getDirection() == Direction.UP && e.getCurrentFloor() <= floor && direction == Direction.UP) ||
                    (e.getDirection() == Direction.DOWN && e.getCurrentFloor() >= floor && direction == Direction.DOWN);

            if (e.getDirection() == Direction.IDLE || isMovingTowards) {
                if (distance < minDistance) {
                    minDistance = distance;
                    selected = e;
                }
            }
        }
        return (selected != null) ? selected : elevators.get(0);
    }
}

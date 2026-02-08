package org.example.LLD_Design_pattern.State.Elevator_System;

import java.util.*;

public class ElevatorManager {
    private List<Elevator> elevators;
    private static ElevatorManager instance;
    private FindElevatorStrategy findElevatorStrategy;

    private ElevatorManager(int count) {
        elevators = new ArrayList<>();
        for (int i = 1; i <= count; i++) elevators.add(new Elevator(i));
    }

    public static ElevatorManager getInstance() {
        if (instance == null) instance = new ElevatorManager(20);
        return instance;
    }

    public void externalRequest(int floor, Direction direction) {
        System.out.println("\n[External Call] Floor " + floor + " wants to go " + direction);
        Elevator best = findElevatorStrategy.findBestElevator(elevators, floor, direction);
        best.addRequest(floor);
    }


}
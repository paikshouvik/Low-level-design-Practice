package org.example.LLD_Design_pattern.State.Elevator_System;

class MovingState implements ElevatorState {
    @Override
    public void move(Elevator e) {
        Integer target = e.getNextTarget();
        if (target == null) {
            e.setDirection(Direction.IDLE);
            e.setCurrentState(new IdleState());
            return;
        }

        e.setDirection(target > e.getCurrentFloor() ? Direction.UP : Direction.DOWN);
        System.out.println("Elevator " + e.getId() + " moving " + e.getDirection() + " to floor " + target);
        
        // Simulate movement
        e.setCurrentFloor(target);
        e.stop();
    }

    @Override
    public void stop(Elevator e) {
        System.out.println("Elevator " + e.getId() + " stopped at " + e.getCurrentFloor());
        e.popTarget(e.getCurrentFloor());
        e.setCurrentState(new DoorOpenState());
    }

    @Override public void pressButton(Elevator e, int f) { e.addRequest(f); }
    @Override public void openDoor(Elevator e) { System.out.println("Cannot open while moving!"); }
    @Override public void closeDoor(Elevator e) {}
    @Override public String getStatus() { return "MOVING"; }
}
package dev.lpa;

enum FlightStages implements Trackable{
    GROUNDED,LAUNCH,CRUISE,DATA_COLLECTION;

    @Override
    public void track() {
        if(this != GROUNDED){
            System.out.println("Monitoring " + this);
        }
    }

    public FlightStages getNextStage(){
        FlightStages[] allStages = values();
        return allStages[(ordinal() + 1) % allStages.length];
    }
}

record DragonFly(String name, String type) implements FlightEnable{
    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

class Satellite implements OrbitEarth{

    public void achieveOrbit(){
        System.out.println("Orbit achieved!");
    }

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

interface OrbitEarth extends FlightEnable {
    void achieveOrbit();
}

interface FlightEnable{
    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;
    public abstract void takeOff(); // public & abstract modifiers are redundant, meaning unnecessary to declare
    abstract void land(); // abstract modifier is redundant
    void fly(); // this is preferred declaration, public and abstract is implied

    default FlightStages transition(FlightStages stage){
//        System.out.println("transition not implemented on " + getClass().getName());
//        return null;
        FlightStages nextStage = stage.getNextStage();
        System.out.println("Transition from " + stage + " to " + nextStage);
        return nextStage;
    };
}

interface Trackable{
    void track();
}
public abstract class Animal {
    public abstract void move();
}

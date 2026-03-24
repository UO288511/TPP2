package spaceLeaf;

import spaceComponent.SpaceUnit;

public class Ship implements SpaceUnit{

    private String name;
    private double fuelConsumption;

    public Ship(String name, double fuelConsumption) {
        this.name = name;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public void showDetails() {
        System.out.println("Ship: " + name + " | Fuel consumption: " + fuelConsumption);
    }

    @Override
    public double getFuelConsumption() {
        return fuelConsumption;
    }
}
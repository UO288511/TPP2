package spaceComposite;

import java.util.ArrayList;
import java.util.List;

import spaceComponent.SpaceUnit;

public class Fleet implements SpaceUnit {

    private String name;
    private List<SpaceUnit> units;

    public Fleet(String name) {
        this.name = name;
        this.units = new ArrayList<>();
    }

    public void addSpaceUnit(SpaceUnit ship) {
    	units.add(ship);
    }
    
    public void removeSpaceUnit(SpaceUnit ship) {
    	units.remove(ship);
    }

    public void showDetails() {
        System.out.println("Fleet: " + name);
        for (SpaceUnit unit : units) {
            unit.showDetails();
        }
    }

    public double getFuelConsumption() {
        double total = 0.0;
        for (SpaceUnit unit : units) {
            total += unit.getFuelConsumption();
        }
        return total;
    }
}
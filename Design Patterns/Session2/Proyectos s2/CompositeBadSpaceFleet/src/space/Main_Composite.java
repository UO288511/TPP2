package space;

import spaceComponent.SpaceUnit;
import spaceComposite.Fleet;
import spaceLeaf.Ship;

public class Main_Composite {

    private static void processUnit(SpaceUnit unit) {
        unit.showDetails();
        System.out.println("Fuel consumption: " + unit.getFuelConsumption());
    }

    public static void main(String[] args) {

        SpaceUnit ship1 = new Ship("Falcon-1", 10.0);
        SpaceUnit ship2 = new Ship("Falcon-2", 12.0);
        SpaceUnit ship3 = new Ship("Command-1", 20.0);

        Fleet squadron = new Fleet("Alpha Squadron");
        squadron.addSpaceUnit(ship1);
        squadron.addSpaceUnit(ship2);

        Fleet mainFleet = new Fleet("Main Fleet");
        mainFleet.addSpaceUnit(squadron);
        mainFleet.addSpaceUnit(ship3);

        System.out.println("=== WITH Composite ===");

        processUnit(ship1);
        System.out.println();
        processUnit(mainFleet);
    }
}
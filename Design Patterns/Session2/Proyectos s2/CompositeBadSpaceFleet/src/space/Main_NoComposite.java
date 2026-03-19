/*package space;

import spaceComposite.Fleet;
import spaceLeaf.Ship;

public class Main_NoComposite {
	
	private static void processUnit(Object unit) {

	    if (unit instanceof Ship) {
	        Ship ship = (Ship) unit;
	        System.out.println("Processing a single ship:");
	        ship.showDetails();
	        System.out.println("Fuel consumption: " + ship.getFuelConsumption());

	    } else if (unit instanceof Fleet) {
	        Fleet fleet = (Fleet) unit;
	        System.out.println("Processing a fleet:");
	        fleet.showDetails();
	        System.out.println("Fuel consumption: " + fleet.getFuelConsumption());

	    } else {
	        System.out.println("Unknown space unit.");
	    }
	}

    public static void main(String[] args) {

        Ship ship1 = new Ship("Falcon-1", 10.0);
        Ship ship2 = new Ship("Falcon-2", 12.0);

        Fleet squadron = new Fleet("Alpha Squadron");
        squadron.addShip(ship1);
        squadron.addShip(ship2);

        System.out.println("=== WITHOUT Composite ===");

        // Operation on a single ship
        System.out.println("Single ship operation:");
        ship1.showDetails();
        System.out.println("Fuel consumption: " + ship1.getFuelConsumption());

        System.out.println();

        // Operation on a fleet
        System.out.println("Fleet operation:");
        squadron.showDetails();
        System.out.println("Fuel consumption: " + squadron.getFuelConsumption());

        System.out.println();
        System.out.println("Problem:");
        System.out.println("The application must treat ships and fleets differently.");
        System.out.println("There is no common type for both.");
        
        
        //  Version trying to use a common method
        
        
        Ship ship3 = new Ship("Falcon-3", 10.0);
        Ship ship4 = new Ship("Falcon-4", 12.0);

        Fleet squadronB = new Fleet("Beta Squadron");
        squadronB.addShip(ship3);
        squadronB.addShip(ship4);

        System.out.println("=== WITHOUT Composite ===");

        processUnit(ship3);
        System.out.println();
        processUnit(ship4);
        System.out.println();

        processUnit(squadronB);

        System.out.println();

    }
}*/
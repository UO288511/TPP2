package space;

import spaceSubsistem.EngineSystem;
import spaceSubsistem.FuelSystem;
import spaceSubsistem.NavigationSystem;

public class Main_NoFacade {

    public static void main(String[] args) {

        FuelSystem fuel = new FuelSystem();
        NavigationSystem navigation = new NavigationSystem();
        EngineSystem engines = new EngineSystem();

        System.out.println("=== Launch sequence WITHOUT Facade ===");

        fuel.checkFuel();
        navigation.initializeRoute();
        engines.startEngines();
    }
}
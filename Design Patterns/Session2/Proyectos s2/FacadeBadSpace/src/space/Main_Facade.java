package space;

import spaceFachada.MissionFacade;
import spaceSubsistem.EngineSystem;
import spaceSubsistem.FuelSystem;
import spaceSubsistem.NavigationSystem;

public class Main_Facade {
	public static void main(String[] args) {

        MissionFacade missionFacade = new MissionFacade();

        System.out.println("=== WITH Facade ===");
        missionFacade.launchMission();
    }

}

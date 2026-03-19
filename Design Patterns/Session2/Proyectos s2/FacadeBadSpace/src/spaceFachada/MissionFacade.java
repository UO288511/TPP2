package spaceFachada;

import spaceSubsistem.EngineSystem;
import spaceSubsistem.FuelSystem;
import spaceSubsistem.NavigationSystem;

public class MissionFacade {
	private FuelSystem fuel;
	private NavigationSystem navigation;
	private EngineSystem engine;
	
	public MissionFacade() {
		this.fuel=new FuelSystem();
		this.navigation=new NavigationSystem();
		this.engine=new EngineSystem();
	}
	
	public void launchMission() {
		fuel.checkFuel();
		navigation.initializeRoute();
		engine.startEngines();
	}
}

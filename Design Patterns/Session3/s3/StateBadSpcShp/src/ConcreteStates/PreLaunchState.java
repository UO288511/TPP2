package ConcreteStates;

import Context.Spacecraft;
import State.SpaceCraftState;

public class PreLaunchState implements SpaceCraftState{
	
	private Spacecraft spacecraft;

    public PreLaunchState(Spacecraft spacecraft) {
        this.spacecraft = spacecraft;
    }

	@Override
	public void advance() {
		System.out.println("[PRE_LAUNCH] Igniting engines...");
        spacecraft.changeState(new InFlightState(spacecraft));
		
	}

	@Override
	public void abort() {
        System.out.println("[PRE_LAUNCH] Mission aborted safely (before launch).");
		
	}
	@Override
    public String status() {
        return "Current phase: PRE_LAUNCH";
    }

	
}

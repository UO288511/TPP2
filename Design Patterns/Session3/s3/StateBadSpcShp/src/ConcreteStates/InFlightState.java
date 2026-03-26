package ConcreteStates;

import Context.Spacecraft;
import State.SpaceCraftState;

public class InFlightState implements SpaceCraftState {
	private Spacecraft spacecraft;

    public InFlightState(Spacecraft spacecraft) {
        this.spacecraft = spacecraft;
    }

    @Override
    public void advance() {
        System.out.println("[IN_FLIGHT] Preparing landing procedures...");
        spacecraft.changeState(new LandingState(spacecraft));
    }

    @Override
    public void abort() {
        System.out.println("[IN_FLIGHT] Emergency abort! Returning to safe pre-launch state.");
        spacecraft.changeState(new PreLaunchState(spacecraft));
    }

    @Override
    public String status() {
        return "Current phase: IN_FLIGHT";
    }
}

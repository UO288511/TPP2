package ComandosConcretos;

import Comando.Command;
import Receivers.ThrusterSystem;

public class IncreaseThrust implements Command{
	private ThrusterSystem thrusterSystem;

    public IncreaseThrust(ThrusterSystem thrusterSystem) {
        this.thrusterSystem = thrusterSystem;
    }

	@Override
	public void execute() {
		thrusterSystem.increaseThrust();
	}

}

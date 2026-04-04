package ComandosConcretos;

import Comando.Command;
import Receivers.ThrusterSystem;

public class DecreaseThrust implements Command {
	private ThrusterSystem thrusterSystem;

    public DecreaseThrust(ThrusterSystem thrusterSystem) {
        this.thrusterSystem = thrusterSystem;
    }

	@Override
	public void execute() {
		thrusterSystem.decreaseThrust();
	}
}

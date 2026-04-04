package ComandosConcretos;

import Comando.Command;
import Receivers.StabilizerSystem;

public class IncreaseStabilization implements Command {
	
	private StabilizerSystem stabilizerSystem;

    public IncreaseStabilization(StabilizerSystem stabilizerSystem) {
        this.stabilizerSystem = stabilizerSystem;
    }

    @Override
    public void execute() {
        stabilizerSystem.increaseStabilization();
    }

}

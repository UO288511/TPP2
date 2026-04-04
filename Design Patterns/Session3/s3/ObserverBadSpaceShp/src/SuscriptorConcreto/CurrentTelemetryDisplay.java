package SuscriptorConcreto;

import Publisher.SpacecraftTelemetry;
import Subscriber.Observer;

public class CurrentTelemetryDisplay  implements Observer{

	private SpacecraftTelemetry telemetry;

    public CurrentTelemetryDisplay(SpacecraftTelemetry telemetry) {
        this.telemetry = telemetry;
        telemetry.registerObserver(this);
    }
	
	
    public void display(double x, double y, double angle,
                        double speed, double rotationSpeed) {
        System.out.println("Current telemetry:");
        System.out.println("Position: (" + x + ", " + y + ")");
        System.out.println("Angle: " + angle);
        System.out.println("Speed: " + speed);
        System.out.println("Rotation speed: " + rotationSpeed);
    }

	@Override
	public void update() {
		double x = telemetry.getX();
        double y = telemetry.getY();
        double angle = telemetry.getAngle();
        double speed = telemetry.getSpeed();
        double rotationSpeed = telemetry.getRotationSpeed();

        display(x, y, angle, speed, rotationSpeed);
	}
}

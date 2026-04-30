
package tpp.rxjava.smartcity;

import io.reactivex.rxjava3.core.*;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.TimeUnit;

record IncidentEvent(String roadId,String type,Instant timestamp){};
record TrafficSensorEvent(String roadId,int vehicleCount,double avgSpeed,Instant timestamp){}
record WeatherEvent(String condition,double temperature,Instant timestamp) {};
record VehiclePosition(String vehicleId,double lat,double lon,Instant timestamp){};


public class EventStreams {	
	
	private static final long seed = 783;

	private static String[] roads = { "A1", "A2", "A3", "B1", "B2", "C1" };
	private static String[] weatherTypes = { "SUN", "RAIN", "WIND", "FOG" };
	private static String[] incidentTypes = { "ACCIDENT", "ROADWORK", "POLICE" };

	public static Observable<TrafficSensorEvent> trafficSensors() {
		Random r = new Random(seed);
		return Observable.interval(300, TimeUnit.MILLISECONDS)
				.map(i -> new TrafficSensorEvent(roads[r.nextInt(roads.length)], r.nextInt(80), r.nextGaussian(40, 20),
						Instant.now()));
	}

	public static Flowable<VehiclePosition> gpsVehicles() {
		Random r = new Random(seed);
		return Flowable.interval(5, TimeUnit.MILLISECONDS)
					   .map(i -> new VehiclePosition("V" + r.nextInt(50),
							   -5.85 + r.nextGaussian()/100,
							   43.36 + r.nextGaussian()/100,
							   Instant.now()));
	}

	public static Observable<WeatherEvent> weather() {
		Random r = new Random(seed);
		return Observable.interval(5, TimeUnit.SECONDS)
				.map(i -> new WeatherEvent(weatherTypes[r.nextInt(weatherTypes.length)], 10 + r.nextDouble() * 20,
						Instant.now()))
				.map(w -> { // This source has a 20% chance to provoke an error
					if (Math.random() < 0.2)
						throw new RuntimeException("API error");
					return w;
				});
	}

	public static Observable<IncidentEvent> incidents() {
		Random r = new Random(seed);
		return Observable.interval(7, TimeUnit.SECONDS).map(i -> new IncidentEvent(roads[r.nextInt(roads.length)],
				incidentTypes[r.nextInt(incidentTypes.length)], Instant.now()));
	}
}

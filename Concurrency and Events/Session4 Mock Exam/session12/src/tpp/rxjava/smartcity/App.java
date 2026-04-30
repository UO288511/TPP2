package tpp.rxjava.smartcity;

import java.time.Instant;
import java.util.Scanner;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class App {
	
	public static final int TIME = 30; // 30 seconds of processing time 

	// -----------------------------------------------------------------------
	// Prints the main menu.
	// -----------------------------------------------------------------------
	private static void printMenu() {
		System.out.println("----------- MENU -----------");
		System.out.println("1. Average speed per road");
		System.out.println("2. Average speed in the last seconds");
		System.out.println("3. Incidents enriched with weather condition");
		System.out.println("4. Fartherst vehicle");
		System.out.println("5. High volume of vehicles");
		System.out.println("6. Congestion alert");
		System.out.println("0. Exit");
	}

	// -----------------------------------------------------------------------
	// Safe integer input
	// -----------------------------------------------------------------------
	private static int readInt(Scanner sc, String message) {
		while (true) {
			System.out.print(message + " ");
			String line = sc.nextLine();
			try {
				return Integer.parseInt(line.trim());
			} catch (NumberFormatException e) {
				System.out.println("Please enter an integer number.");
			}
		}
	}
	
	private static void waitFor(int seconds) {
		try {
			Thread.sleep(seconds*1_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Observable<TrafficSensorEvent> traffic;
		Flowable<VehiclePosition> gps;
		Observable<WeatherEvent> weather;
		Observable<IncidentEvent> incidents;
		
		Disposable dis;

		Scanner sc = new Scanner(System.in);
        boolean exit = false;

        System.out.println("---SMART CITY EVENT ANALYSIS---");

        while (!exit) {
            printMenu();
            int option = readInt(sc, "Choose an option:");

            switch (option) {
                case 1 :
                	traffic = EventStreams.trafficSensors();
                	dis = speedPerRoad(clean(traffic));
                	waitFor(TIME);
                	dis.dispose();
                    break;
                case 2 :
                	traffic = EventStreams.trafficSensors();
                	dis = avgSpeedLastSeconds(clean(traffic));
                	waitFor(TIME);
                	dis.dispose();
                    break;
                case 3 :
                	incidents = EventStreams.incidents();
                	weather = EventStreams.weather();
                	dis = combineIncidentsWeather(incidents,weatherErrorRecovery(weather));
                	waitFor(TIME);
                	dis.dispose();
                    break;
                case 4 :
                	gps = EventStreams.gpsVehicles();
                	dis = maxDistanceBatch(gps.take(TIME, TimeUnit.SECONDS));
                	waitFor(TIME);
                	dis.dispose();
                    break;
                case 5 :
                	traffic = EventStreams.trafficSensors();
                	dis = highTraffic(clean(traffic.take(TIME, TimeUnit.SECONDS)));
                	waitFor(TIME);
                	dis.dispose();
                    break;
                case 6 :
                	traffic = EventStreams.trafficSensors();
                	dis = congestionAlert(clean(traffic.take(TIME, TimeUnit.SECONDS)));
                	waitFor(TIME);
                	dis.dispose();
                    break;
                case 0 :
                    exit = true;
                    System.out.println("Exiting.");
                    break;
                default :
                    System.out.println("Unknown option.");
            }
            
        }
	}

	// Remove invalid + duplicate events
	private static Observable<TrafficSensorEvent> clean(Observable<TrafficSensorEvent> traffic) {
		return traffic
				.filter(x -> x.vehicleCount() >= 0)
				.filter(x -> x.avgSpeed() > 0)
				.distinct(x -> x.timestamp());
	}
	
	// Handle failures in the weather observable gracefully
	private static Observable<WeatherEvent> weatherErrorRecovery(Observable<WeatherEvent> weather) {
		return weather
				.retry(3)
				.onErrorResumeNext(e-> Observable.just(new WeatherEvent("DEFAULT", 20.0, Instant.now())));
	}

	// Obtain the speed per road sampled every 5 seconds
	private static Disposable speedPerRoad(Observable<TrafficSensorEvent> traffic) {
		Disposable dis = traffic
				.groupBy(event -> event.roadId())
				.flatMap(group -> group.sample(5, TimeUnit.SECONDS)
							.map(e-> group.getKey() + " -> " + e.avgSpeed()))
				.subscribe(System.out::println);

		return dis;
	}

	// Compute the maximum speed in the last 5 seconds
	private static Disposable avgSpeedLastSeconds(Observable<TrafficSensorEvent> traffic) {
		Disposable dis = traffic
				.window(5, TimeUnit.SECONDS)
				.flatMapSingle(e -> e.map(a -> a.avgSpeed()).reduce(0d, Math::max))
				.subscribe(max -> System.out.println("Window max speed = " + max));

		return dis;
	}

	// Combine context streams, add the current weather condition to each incident
	// event
	private record CombineIncidents(IncidentEvent incident, WeatherEvent event) {}
	private static Disposable combineIncidentsWeather(Observable<IncidentEvent> incidents, Observable<WeatherEvent> weather) {
		Disposable dis = Observable.zip(incidents, weather, CombineIncidents::new)
						.subscribe(System.out::println);
		
		
		return dis;
	}

	// Helper method to compute the euclidean distance in km to the reference coordinate
	// 43.36 -5.85
	private static double distance(VehiclePosition pos) {
		
		double R = 6371; // Earth radius in km
	    
	    double x = Math.toRadians(pos.lon() - 43.36) * Math.cos(Math.toRadians((-5.85 + pos.lat()) / 2));
	    double y = Math.toRadians(pos.lat() + 5.85 );
	    
	    return Math.sqrt(x * x + y * y) * R;
	}
	
	// Compute the maximum distance of the vehicle in batches every 500 ms.
	private static Disposable maxDistanceBatch(Flowable<VehiclePosition> gps) {
		Disposable dis = gps
				.onBackpressureBuffer() 
				.window(500, TimeUnit.MILLISECONDS) 
				.flatMapSingle(window -> window
						.observeOn(Schedulers.computation())
						.map(pos -> distance(pos))
						.reduce(0d, Math::max)
				)
				.subscribe(max -> System.out.println("Window max distance = " + max));

		return dis;
	}

	// Identify events with high traffic, that is, more than 60 vehicles in a road
	private static Disposable highTraffic(Observable<TrafficSensorEvent> traffic) {
		Disposable dis = null;
		
		// TODO
		
		return dis;
	}

	// Show a congestion alert when the average speed in a road is lower than 40
	private static Disposable congestionAlert(Observable<TrafficSensorEvent> traffic) {
		Disposable dis = null;
		
		// TODO
		
		return dis;
	}
}

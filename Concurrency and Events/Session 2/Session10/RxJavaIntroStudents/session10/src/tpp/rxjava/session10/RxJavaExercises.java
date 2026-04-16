package tpp.rxjava.session10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class RxJavaExercises {

	public static void main(String[] args) throws InterruptedException {
		// Uncomment the exercise you want to run
		ex1_BasicStream();
		ex2_JustVsFrom();
		ex3_Equivalence();
		ex4_Single();
		ex5_Maybe();
		ex6_Completable();
		ex7_Interval();
		ex8_Lazyness();
		Disposing();
		ex10_ColdObservable();
		ex11_Connectable();
		ex12_RefCount();
		ex13_Subject();
		ex14_Map();
		ex15_TempConverter();
		ex16_FlatMap();
		ex17_Filter();
		ex18_Distinct();
		ex19_TakeWhile();
	}

	// --- MODULE 1: CREATION ---
	private static void ex1_BasicStream() {
		System.out.println("----- EXERCISE 1 -----" );
		Observable.just("Mercury", "Venus", "Earth", "Mars", "Jupiter")
			//.map(String::toUpperCase)
			.subscribe( 
					item -> System.out.println("Planet: " + item),
					error -> System.err.println(error),
					() -> System.out.println("Completed")
					);
		
		System.out.println();

		var list = List.of(1,2,3,4,5);
		list.parallelStream().forEach(System.out::println);
		System.out.println();
	}

	private static void ex2_JustVsFrom() {
		List<String> list = Arrays.asList("A", "B", "C");
		// TODO
		System.out.println("----- EXERCISE 2 -----" );
		System.out.println("Observable.just(list): ");
		Observable.just(list)
			.subscribe(
					item -> System.out.println(item));
		
		System.out.println("Observable.fromIterable(list): ");
		Observable.fromIterable(list)
			.subscribe(
					item -> System.out.println(item));
		
		System.out.println();
	}

	private static void ex3_Equivalence() {
		// TODO
		System.out.println("----- EXERCISE 3 -----" );

		System.out.println("Observable.just(): ");
		Observable.just(1,2,3)
			.subscribe(item -> System.out.println(item));
		
		System.out.println("Observable.fromArray(): ");
		Observable.fromArray(1,2,3)
			.subscribe(System.out::println);
		
		System.out.println("Observable.range(): ");
		Observable.range(1,3)
			.subscribe(System.out::println);
		
		System.out.println("Observable.create(): ");
		Observable.create(emitter ->{
			emitter.onNext(1);
			emitter.onNext(2);
			emitter.onNext(3);
			emitter.onComplete();
			}).subscribe(System.out::println);

		System.out.println();

	}
	private static Path resolveFilePath() throws IOException{
		Path local = Path.of("file.txt");
		if (Files.exists(local)) {
			return local;
		}
		Path sessionFolfer = Path.of("session10", "file.txt");
		if(Files.exists(sessionFolfer)) {
			return sessionFolfer;
		}
		throw new IOException("file.txt not found");
	}

	private static void ex4_Single() {
		// TODO
		System.out.println("----- EXERCISE 4 -----" );
		var single = Single.fromCallable(() -> {
	        Path path = resolveFilePath();
	        return Files.lines(path);
	    });

	    single.subscribe(
	        item -> item.forEach(System.out::println),
	        err -> System.err.println("Error" + err)
	      );
	    
		System.out.println();
	}

	private static void ex5_Maybe() {
		// TODO
		System.out.println("----- EXERCISE 5 -----" );
		Maybe.create(emitter -> {
			double value = Math.random();
			System.out.println("Random value: " + value);
			if (value > 0.5) {
				emitter.onSuccess("Ok");
			} else {
				emitter.onError(new RuntimeException("Value was not greater than 0.5"));
			}
		}).subscribe(
				item -> System.out.println("Success: " + item),
				error -> System.out.println("Error: " + error.getMessage()),
				() -> System.out.println("Completed without value")
		);
		
		System.out.println();
	}

	private static void ex6_Completable() {
		// TODO
		System.out.println("----- EXERCISE 6 -----" );

		Completable.fromAction(() -> {
			System.out.println("Start the disk write");
			Thread.sleep(2000);
			System.out.println("Done the 2 seconds");
		}).subscribe(
				() -> System.out.println("Completed"),
				error -> System.err.println(error)
		);
		
		System.out.println();
		
		
	}

	private static void ex7_Interval() throws InterruptedException {
		// TODO
		System.out.println("----- EXERCISE 7 -----" );

		var d = Observable.interval(500, TimeUnit.MILLISECONDS)
				.take(6)
				.subscribe(item -> System.out.println("Event: " + item));
		Thread.sleep(5000);
		d.dispose();
		
		System.out.println();

	}

	private static void ex8_Lazyness() {
		// TODO
		System.out.println("----- EXERCISE 8 -----" );

		var obs = Observable.create(emitter -> {
			System.out.println("Generating a value");
			emitter.onNext(Math.random());
			emitter.onComplete();
		});
		
		obs.subscribe(value -> System.out.println("Observer 1 received: " + value));
		obs.subscribe(value -> System.out.println("Observer 2 received: " + value));
		
		System.out.println();

	}

	private static void Disposing() throws InterruptedException {
		// TODO
		System.out.println("----- EXERCISE 9 -----" );
		var d = Observable.interval(1, TimeUnit.SECONDS)
				.subscribe(item -> System.out.println( item));

		Thread.sleep(3500);
		System.out.println("Ending subscription");
		d.dispose();
		Thread.sleep(1000);
		System.out.println();

	}

	// --- MODULE 2: HOT VS COLD ---
	/*
	//cold
	Observable<Double> o = Observable.just("a","b","c").map(String::toUpperCase);
	//hot
	o.publish().connect();
	o.subscribe();*/
	
	private static void ex10_ColdObservable() throws InterruptedException {
		// TODO
		System.out.println("----- EXERCISE 10 -----" );
		var cold = Observable.fromCallable(() -> {
			double value = Math.random();
			System.out.println("Generated: " + value);
			return value;
		});

		cold.subscribe(value -> System.out.println("Observer 1: " + value));

		Thread.sleep(1000);

		cold.subscribe(value -> System.out.println("Observer 2: " + value));
		
		System.out.println();

	}

	private static void ex11_Connectable() throws InterruptedException {
		// TODO
		System.out.println("----- EXERCISE 11 -----" );
		var hot = Observable.interval(1, TimeUnit.SECONDS).publish();

		hot.subscribe(value -> System.out.println("Observer 1: " + value));

		Thread.sleep(2000);

		hot.subscribe(value -> System.out.println("Observer 2: " + value));

		System.out.println("connect");
		hot.connect();

		Thread.sleep(5000);
		
		System.out.println();


	}

	private static void ex12_RefCount() {
		// TODO
	}

	private static void ex13_Subject() {
		// TODO
	}

	// --- MODULE 3: OPERATORS ---
	private static void ex14_Map() {
		// TODO
	}

	private static void ex15_TempConverter() {
		// TODO
	}

	private static List<Integer> getOrderIds(int clientId) {
		Random rnd = new Random();
		return List.of(rnd.nextInt(0, 100), rnd.nextInt(0, 100), rnd.nextInt(0, 100));
	}

	private static void ex16_FlatMap() {
		// TODO
	}

	private static boolean isPrime(long x) {
		return LongStream.rangeClosed(2, (long) (Math.sqrt(x))).allMatch(n -> x % n != 0);
	}

	private static void ex17_Filter() {
		// TODO
	}

	private static void ex18_Distinct() {
		// TODO
	}

	private static void ex19_TakeWhile() {
		// TODO
	}
}

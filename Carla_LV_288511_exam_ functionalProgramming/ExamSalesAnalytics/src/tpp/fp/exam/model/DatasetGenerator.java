package tpp.fp.exam.model;

import java.time.*;
import java.util.*;
import java.util.stream.*;

public class DatasetGenerator {
	private static Random rnd = new Random(84);
	
    private static final List<String> COUNTRIES = List.of(
            "Spain", "Germany", "France", "Italy", "UK", "USA"
    );

    private static final List<String> CATEGORIES = List.of(
            "Electronics", "Books", "Clothing", "Home", "Sports", "Toys"
    );

    public static List<Customer> generateCustomers(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Customer(
                        "C" + i,
                        "Customer-" + i,
                        randomFrom(COUNTRIES),
                        randomTier()
                ))
                .toList();
    }

    public static List<Product> generateProducts(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Product(
                        "P" + i,
                        "Product-" + i,
                        randomFrom(CATEGORIES),
                        randomPrice()
                ))
                .toList();
    }

    public static List<Order> generateOrders(
            int count,
            List<Customer> customers,
            List<Product> products) {

        return IntStream.range(0, count)
                .mapToObj(i -> new Order(
                        "O" + i,
                        randomFrom(customers),
                        generateItems(products),
                        randomDate()
                ))
                .toList();
    }

    private static List<OrderItem> generateItems(List<Product> products) {
        int itemsCount = rnd.nextInt(1, 6);

        return IntStream.range(0, itemsCount)
                .mapToObj(i -> new OrderItem(
                        randomFrom(products),
                        rnd.nextInt(1, 4)
                ))
                .toList();
    }

    private static Tier randomTier() {
        double r = rnd.nextDouble();
        if (r < 0.7) return Tier.STANDARD;
        if (r < 0.9) return Tier.PREMIUM;
        return Tier.VIP;
    }

    private static double randomPrice() {
        return rnd.nextDouble(5, 1500);
    }

    private static LocalDateTime randomDate() {
        LocalDateTime start = LocalDateTime.now().minusYears(2);
        long days = rnd.nextLong(0, 730);
        return start.plusDays(days);
    }

    private static <T> T randomFrom(List<T> list) {
        return list.get(rnd.nextInt(list.size()));
    }
}

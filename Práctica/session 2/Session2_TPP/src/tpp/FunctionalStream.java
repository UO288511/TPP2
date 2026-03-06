package tpp;

import java.util.function.*;
import java.util.*;
import java.util.stream.*;

public class FunctionalStream {

    public static void main(String[] args) {
        System.out.println("=== BLOCK 1: Functional Interfaces without Streams ===\n");

        ejercicio1PredicateStringIsEmpty();
        ejercicio2PredicateCharacterIsUpperCase();
        ejercicio3FunctionStringToLength();
        ejercicio4FunctionStringToIntegerParse();
        ejercicio5ConsumerPrintWithSystemOut();
        ejercicio6ConsumerAddToList();
        ejercicio7SupplierRandomNumber();
        ejercicio8SupplierCreateStringBuilder();

        System.out.println("=== END BLOCK 1 ===\n");

        System.out.println("=== BLOCK 2: Basic Streams (no map/flatMap/reduce) ===\n");
        runBlock2StreamsBasics();
        System.out.println("=== END BLOCK 2 ===\n");

        System.out.println("=== MINI TEXT STREAM LAB ===\n");
        runMiniTextStreamLab();
        System.out.println("=== END MINI TEXT STREAM LAB ===");
    }

    // =========================================================
    // BLOCK 1 - FUNCTIONAL INTERFACES AND METHOD REFERENCES
    // =========================================================

    /**
     * Exercise 1:
     * Predicate<String> using object instance method reference (String::isEmpty)
     * and its equivalent lambda (s -> s.isEmpty()).
     */
    public static void ejercicio1PredicateStringIsEmpty() {
        System.out.println("Exercise 1: Predicate<String> with String::isEmpty");
        // TODO: implement Predicate<String> using String::isEmpty
        // and its equivalent lambda, testing with empty and non-empty strings.
        System.out.println();
    }

    /**
     * Exercise 2:
     * Predicate<Character> using static method reference (Character::isUpperCase)
     * and its equivalent lambda (c -> Character.isUpperCase(c)).
     */
    public static void ejercicio2PredicateCharacterIsUpperCase() {
        System.out.println("Exercise 2: Predicate<Character> with Character::isUpperCase");
        // TODO: implement Predicate<Character> using Character::isUpperCase
        // and its equivalent lambda, testing with uppercase and lowercase letters.
        System.out.println();
    }

    /**
     * Exercise 3:
     * Function<String,Integer> using type instance method reference (String::length)
     * and its equivalent lambda (s -> s.length()).
     */
    public static void ejercicio3FunctionStringToLength() {
        System.out.println("Exercise 3: Function<String,Integer> with String::length");
        // TODO: implement Function<String,Integer> using String::length
        // and its equivalent lambda, testing with various words.
        System.out.println();
    }

    /**
     * Exercise 4:
     * Function<String,Integer> using static method reference (Integer::parseInt)
     * and its equivalent lambda (s -> Integer.parseInt(s)).
     */
    public static void ejercicio4FunctionStringToIntegerParse() {
        System.out.println("Exercise 4: Function<String,Integer> with Integer::parseInt");
        // TODO: implement Function<String,Integer> using Integer::parseInt
        // and its equivalent lambda, testing with various numeric strings.
        System.out.println();
    }

    /**
     * Exercise 5:
     * Consumer<String> using object instance method reference (System.out::println)
     * and its equivalent lambda (s -> System.out.println(s)).
     */
    public static void ejercicio5ConsumerPrintWithSystemOut() {
        System.out.println("Exercise 5: Consumer<String> with System.out::println");
        // TODO: implement Consumer<String> using System.out::println
        // and its equivalent lambda, printing various messages.
        System.out.println();
    }

    /**
     * Exercise 6:
     * Consumer<String> using object instance method reference (list::add)
     * and its equivalent lambda (s -> list.add(s)).
     */
    public static void ejercicio6ConsumerAddToList() {
        System.out.println("Exercise 6: Consumer<String> with list::add");
        // TODO: create a List of String, define a Consumer<String> using list::add
        // and another using lambda, and show the final content of the list.
        System.out.println();
    }

    /**
     * Exercise 7:
     * Supplier<Double> using static method reference (Math::random)
     * and its equivalent lambda (() -> Math.random()).
     */
    public static void ejercicio7SupplierRandomNumber() {
        System.out.println("Exercise 7: Supplier<Double> with Math::random");
        // TODO: implement Supplier<Double> using Math::random
        // and its equivalent lambda, showing various generated values.
        System.out.println();
    }

    /**
     * Exercise 8:
     * Supplier<StringBuilder> using constructor reference (StringBuilder::new)
     * and its equivalent lambda (() -> new StringBuilder()).
     */
    public static void ejercicio8SupplierCreateStringBuilder() {
        System.out.println("Exercise 8: Supplier<StringBuilder> with StringBuilder::new");
        // TODO: implement Supplier<StringBuilder> using StringBuilder::new
        // and its equivalent lambda, building and showing strings.
        System.out.println();
    }

    // =========================================================
    // BLOCK 2 - BASIC STREAMS 
    // =========================================================

    /**
     * This method groups the Block 2 exercises on streams:
     * - stream creation,
     * - terminal operations (forEach, count, anyMatch, allMatch, noneMatch),
     * - chains of intermediate operations (filter, sorted, distinct, limit)
     *   followed by a terminal one.
     *
     * Students must write the code corresponding to each exercise.
     */
    public static void runBlock2StreamsBasics() {

        // -----------------------------------------------------
        // Exercise 1: Create streams in different ways
        // -----------------------------------------------------
        System.out.println("Exercise 1 (Block 2): Create streams in different ways");
        // TODO:
        // - Create a Stream<String> from a list of names.
        // - Create an IntStream from an array of integers.
        // - Traverse both streams with forEach to show their content.
        System.out.println();

        // -----------------------------------------------------
        // Exercise 2: Only terminal operations (count, anyMatch, allMatch)
        // -----------------------------------------------------
        System.out.println("Exercise 2 (Block 2): Only terminal operations");
        // TODO:
        // - Define a list of integers.
        // - Use count() to count elements.
        // - Use anyMatch() to check if there is any even number.
        // - Use allMatch() to check if all are positive.
        System.out.println();

        // -----------------------------------------------------
        // Exercise 3: Use of noneMatch
        // -----------------------------------------------------
        System.out.println("Exercise 3 (Block 2): Use of noneMatch");
        // TODO:
        // - Define another list of integers.
        // - Use noneMatch() to check that no element is even.
        System.out.println();

        // -----------------------------------------------------
        // Exercise 4: Chain with filter + forEach
        // -----------------------------------------------------
        System.out.println("Exercise 4 (Block 2): filter + forEach");
        // TODO:
        // - Define a list of words.
        // - Create a stream, filter those with length > 3 and show them with forEach.
        System.out.println();

        // -----------------------------------------------------
        // Exercise 5: Chain with filter + sorted + forEach
        // -----------------------------------------------------
        System.out.println("Exercise 5 (Block 2): filter + sorted + forEach");
        // TODO:
        // - Define a list of strings (e.g., city names).
        // - Filter based on a condition and sort alphabetically before showing.
        System.out.println();

        // -----------------------------------------------------
        // Exercise 6: Chain with distinct + filter + count
        // -----------------------------------------------------
        System.out.println("Exercise 6 (Block 2): distinct + filter + count");
        // TODO:
        // - Define a list of integers with repetitions.
        // - Use distinct() to remove duplicates.
        // - Filter only even ones and count how many there are.
        System.out.println();

        // -----------------------------------------------------
        // Exercise 7: Chain with filter + limit + forEach
        // -----------------------------------------------------
        System.out.println("Exercise 7 (Block 2): filter + limit + forEach");
        // TODO:
        // - Define a list of integers.
        // - Filter greater than a certain value.
        // - Use limit() to keep the first results and show them.
        System.out.println();
    }

    // =========================================================
    // BASE TEXT FOR THE TEXT STREAM MINI-APP
    // =========================================================

    /**
     * Base text for the mini-application.
     * Teachers can substitute these lines for the real monologue if desired.
     */
    private static final List<String> TEXT_LINES = Arrays.asList(
        "I've seen things you people wouldn't believe.",
        "Attack ships on fire off the shoulder of Orion.",
        "I watched C-beams glitter in the dark near the Tannhauser Gate.",
        "All those moments will be lost in time, like tears in rain.",
        "Time to die."
    );

    // ---------------------------------------------------------
    // Helper methods for the text mini-application
    // ---------------------------------------------------------

    /**
     * Returns a list with all words from the text in TEXT_LINES,
     * splitting by spaces.
     */
    private static List<String> getAllWordsFromText() {
        List<String> words = new ArrayList<>();
        for (String line : TEXT_LINES) {
            String[] parts = line.split("\\s+");
            for (String p : parts) {
                if (!p.isEmpty()) {
                    words.add(p);
                }
            }
        }
        return words;
    }

    /**
     * Returns true if the string contains at least one digit.
     */
    private static boolean containsDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    // =========================================================
    // MINI-APP: MINI TEXT STREAM LAB (SKELETON)
    // =========================================================

    /**
     * Main method of the text lab.
     * Shows a menu and calls the different options.
     */
    public static void runMiniTextStreamLab() {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printTextLabMenu();
            System.out.print("Choose an option: ");
            String line = sc.nextLine().trim();
            int option;
            try {
                option = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid option, try again.");
                System.out.println();
                continue;
            }

            List<String> words = getAllWordsFromText();

            switch (option) {
                case 1:
                    runOption1ShowOriginalText();
                    break;
                case 2:
                    runOption2BasicStatistics(words);
                    break;
                case 3:
                    runOption3WordsStartingWith(sc, words);
                    break;
                case 4:
                    runOption4DistinctSortedWords(words);
                    break;
                case 5:
                    runOption5CheckWordConditions(words);
                    break;
                case 6:
                    runOption6FirstWordsWithMinLength(sc, words);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Exiting text stream lab.");
                    break;
                default:
                    System.out.println("Unknown option, try again.");
            }
            System.out.println();
        }
        
    }

    private static void printTextLabMenu() {
        System.out.println("=== Mini Text Stream Lab ===");
        System.out.println("1. Show original text (lines)");
        System.out.println("2. Basic statistics about words");
        System.out.println("3. List words starting with a given letter");
        System.out.println("4. List distinct words sorted alphabetically");
        System.out.println("5. Check conditions on words (anyMatch / allMatch / noneMatch)");
        System.out.println("6. Show first 5 words with minimum length");
        System.out.println("0. Exit text lab");
    }

    // ---------------------------------------------------------
    // Option 1: show original text line by line
    // ---------------------------------------------------------
    private static void runOption1ShowOriginalText() {
        System.out.println("Original text (lines):");
        // TODO: create a stream from TEXT_LINES and show each line with forEach.
    }

    // ---------------------------------------------------------
    // Option 2: statistics about words
    // ---------------------------------------------------------
    private static void runOption2BasicStatistics(List<String> words) {
        // TODO:
        // - Calculate total words with count().
        // - Calculate distinct words with distinct().count().
        // - Calculate how many have length > 5 with filter().count().
        // - Show results.
    }

    // ---------------------------------------------------------
    // Option 3: words starting with a given letter
    // ---------------------------------------------------------
    private static void runOption3WordsStartingWith(Scanner sc, List<String> words) {
        // TODO:
        // - Ask the user for a letter (use only the first character).
        // - Filter words starting with that letter ignoring case.
        // - Show resulting words.
    }

    // ---------------------------------------------------------
    // Option 4: distinct words sorted alphabetically
    // ---------------------------------------------------------
    private static void runOption4DistinctSortedWords(List<String> words) {
        // TODO:
        // - Create a stream from words.
        // - Apply distinct() and then sorted().
        // - Show result with forEach.
    }

    // ---------------------------------------------------------
    // Option 5: anyMatch / allMatch / noneMatch on words
    // ---------------------------------------------------------
    private static void runOption5CheckWordConditions(List<String> words) {
        // TODO:
        // - Use anyMatch to check if there is any word with length > 10.
        // - Use allMatch to check if all words have length > 1.
        // - Use noneMatch together with containsDigit to check that no word has digits.
        // - Show results.
    }

    // ---------------------------------------------------------
    // Option 6: first 5 words with a minimum length
    // ---------------------------------------------------------
    private static void runOption6FirstWordsWithMinLength(Scanner sc, List<String> words) {
        // TODO:
        // - Ask user for an integer with the minimum length.
        // - Create a stream, filter words with length >= minimum length.
        // - Use limit(5) to show only the first 5 words matching the condition.
    }
}


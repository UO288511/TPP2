package tpp;

// FOR COMPOSITION IN FUNCTIONAL INTERFACES

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// FOR LAZY EVALUATION IN STREAMS
import java.util.stream.Stream;

/**
 * Exercises about composition of functional interfaces in Java:
 * - Function: compose and andThen with simple mathematical examples.
 * - Predicate: logical composition and De Morgan's laws.
 * - Consumer: andThen to chain side effects.
 * - Comparator: reversed, thenComparing and nullsLast.
 *
 * Each exercise is isolated in its own method.
 */
public class CompLazyExercices {

    public static void main(String[] args) {

        System.out.println("=== EXERCISE 1: Function (same result with compose/andThen) ===");
        exercise1_FunctionSameResult();

        System.out.println();
        System.out.println("=== EXERCISE 2: Function (different result) ===");
        exercise2_FunctionDifferentResult();

        System.out.println();
        System.out.println("=== EXERCISE 3: Predicate (De Morgan laws) ===");
        exercise3_PredicateDeMorgan();

        System.out.println();
        System.out.println("=== EXERCISE 4: Consumer (order of effects) ===");
        exercise4_ConsumerOrderEffects();

        System.out.println();
        System.out.println("=== EXERCISE 5: Comparator reversed() ===");
        exercise5_ComparatorReversed();

        System.out.println();
        System.out.println("=== EXERCISE 6: Comparator with two criteria ===");
        exercise6_ComparatorTwoCriteria();

        System.out.println();
        System.out.println("=== EXERCISE 7: Comparator nullsLast() ===");
        exercise7_ComparatorNullsLast();
        
        
        // =========================================================
        // ABOUT LAZY EVALUATION 
        // ========================================================= 
        System.out.println("=== LAZY EVALUATION EXERCISES ===");
        System.out.println();

        System.out.println("=== EXERCISE 1: No execution without terminal operation ===");
        exercise1_NoTerminalNoExecution();
        System.out.println();

        System.out.println("=== EXERCISE 2: Short-circuit with anyMatch ===");
        exercise2_ShortCircuitAnyMatch();
        System.out.println();

        System.out.println("=== EXERCISE 3: Short-circuit with limit ===");
        exercise3_ShortCircuitLimit();
        System.out.println();

        System.out.println("=== EXERCISE 4: sorted() vs element-by-element processing ===");
        exercise4_SortedBehavior();
        System.out.println();

        System.out.println("=== EXERCISE 5: noneMatch with an \"expensive\" predicate ===");
        exercise5_NoneMatchExpensivePredicate();
        System.out.println();

        System.out.println("=== EXERCISE 6: findFirst and lazy search ===");
        exercise6_FindFirstLazy();
        System.out.println();

        System.out.println("=== EXERCISE 7: Stream cannot be reused ===");
        exercise7_StreamCannotBeReused();   
        
        
        // =========================================================
        // MINI APPLICATION 
        // =========================================================      
        
        System.out.println();
        System.out.println("=== MINIAPP: TRUTH TABLE LAB ===");
        TruthTableLab lab = new TruthTableLab();
        lab.runLab();
    }

    // =========================================================
    // EXERCISE 1 — Function: same result with g(f(x))
    // =========================================================

    private static void exercise1_FunctionSameResult() {
        // TODO: implement this exercise
    	Function <Integer, Integer> f = x -> x +3;
    	Function <Integer, Integer> g = x -> 2 * x;
    	
    	Function <Integer, Integer> h1 = f.andThen(g);
    	Function <Integer, Integer> h2 = g.compose(f);
    	
    	List <Integer> list1 = List.of(1,2,3,4,5,0);
    	
    	for(var i: list1) {
    		System.out.println("x = " + i +" | h1 = " + h1.apply(i) +" | h2 = " + h2.apply(i));
        }    	
    }


    // =========================================================
    // EXERCISE 2 — Function: different result
    // =========================================================

    private static void exercise2_FunctionDifferentResult() {
        // TODO: implement this exercise
    	Function<Integer, Integer> f = x -> x * x;
        Function<Integer, Integer> g = x -> x + 10;

        Function<Integer, Integer> h1 = f.andThen(g);
        Function<Integer, Integer> h2 = g.compose(f);
        Function<Integer, Integer> h3 = g.andThen(f);

        List<Integer> list2 =List.of(1, 2, 3, 4);
        
        for(var i: list2) {
    		System.out.println("x = " + i +" | h1 = " + h1.apply(i) +" | h2 = " + h2.apply(i)  +" | h3 = " + h3.apply(i));
        } 
    }


    // =========================================================
    // EXERCISE 3 — Predicate: De Morgan
    // =========================================================

    private static void exercise3_PredicateDeMorgan() {
        // TODO: implement this exercise
    	Predicate<Integer> p = x -> x > 5;
        Predicate<Integer> q = x -> x % 2 == 0;
        
        Predicate<Integer> pAndQ = p.and(q);
        
        Predicate<Integer> notPAndQ = pAndQ.negate();
        Predicate<Integer> notP_or_notQ = p.negate().or(q.negate());
        
        Predicate<Integer> pOrQ = p.or(q);
        Predicate<Integer> notPOrQ = pOrQ.negate();
        Predicate<Integer> notP_and_notQ = p.negate().and(q.negate());
        
        List<Integer> list3 =List.of( 3, 4, 6, 9, 10);
        
        for (Integer x : list3) {
        	System.out.println("x = " + x);

            System.out.println("p(x): " + p.test(x));
            System.out.println("q(x): " + q.test(x));

            System.out.println("!(p && q): " + notPAndQ.test(x));
            System.out.println("!p || !q: " + notP_or_notQ.test(x));

            System.out.println("!(p || q): " + notPOrQ.test(x));
            System.out.println("!p && !q: " + notP_and_notQ.test(x));

            System.out.println();
        }

        
    }


    // =========================================================
    // EXERCISE 4 — Consumer: chaining effects
    // =========================================================

    private static void exercise4_ConsumerOrderEffects() {
        // TODO: implement this exercise
    	Consumer<String> print = x-> System.out.println(x);
    	Consumer<String> upper = x-> System.out.println(x.toUpperCase());

    	Consumer<String> printThenUpper = print.andThen(upper);
    	Consumer<String> upperThemPrint = upper.andThen(print);
    	
    	printThenUpper.accept("print then upper");
    	upperThemPrint.accept("upper then print");
    	
    }


    // =========================================================
    // EXERCISE 5 — Comparator: reversed()
    // =========================================================

    private static void exercise5_ComparatorReversed() {
        // TODO: implement this exercise
    	List<String> list5 = new ArrayList<>();
        list5.add("hola");
        list5.add("xilofono");
        list5.add("manzana");
        list5.add("casa");
        
        System.out.println("inicial: " + list5);
        
        list5.sort(Comparator.naturalOrder());
        System.out.println("Natural order: " + list5);
        
        list5.sort(Comparator.<String>naturalOrder().reversed());
        System.out.println("Reversed order: " + list5);
        

    }


    // =========================================================
    // EXERCISE 6 — Comparator: two criteria
    // =========================================================

    private static void exercise6_ComparatorTwoCriteria() {
        // TODO: implement this exercise
    	List<Person> people = new ArrayList<>();
        people.add(new Person("carla", 30));
        people.add(new Person("laura", 25));
        people.add(new Person("raquel", 15));
        
        Comparator<Person> byAge= Comparator.comparing(Person::getAge);
        Comparator<Person> byName= Comparator.comparing(Person::getName);

        Comparator<Person> byAgeThenbyName = byAge.thenComparing(byName);
        
        System.out.println("people: " + people);
        people.sort(byAgeThenbyName);
        System.out.println("people sorted: " + people);

        
        
        
    }


    // =========================================================
    // EXERCISE 7 — Comparator: nullsLast
    // =========================================================

    private static void exercise7_ComparatorNullsLast() {
        // TODO: implement this exercise
    	List<String> list7 = new ArrayList<>();
    	list7.add("hola");
    	list7.add(null);
    	list7.add("casa");
    	list7.add("mundo");
    	list7.add(null);
    	list7.add("movil");
        
        Comparator<String> byLength = Comparator.comparing(String::length);

        Comparator<String> nullsLastComparator = Comparator.nullsLast(byLength);

        System.out.println("list  : " + list7);
        list7.sort(nullsLastComparator);

        System.out.println("list sorted : " + list7);
    }

    
    
    // =========================================================
    // ABOUT LAZY EVALUATION
    // =========================================================

    // =========================================================
    // EXERCISE 1 — Nothing happens without a terminal operation
    // =========================================================

    /**
     * Build a stream pipeline with several intermediate operations and show
     * (using peek) that:
     *   - If we do NOT call a terminal operation, nothing is printed.
     *   - If we add a terminal operation later (forEach), the whole pipeline runs.
     */
    private static void exercise1_NoTerminalNoExecution() {
        // TODO: implement this exercise
    	var list = List.of(1,2,3,4,5,6,7,8,9,10,11);
    	
    	var stream = list.stream().peek(x-> System.out.println("Peek 1 Element: " + x))
    			.filter(x->x>5).peek(x-> System.out.println("Peek 2 Element: " + x))
    			.filter(x->x<9).peek(x->System.out.println("Peek 3 Element: " + x));
    	
    	stream.forEach(System.out::println);
    }


    // =========================================================
    // EXERCISE 2 — Short-circuit with anyMatch
    // =========================================================

    /**
     * Demonstrate that anyMatch() stops the pipeline as soon as it finds
     * a matching element.
     */
    private static void exercise2_ShortCircuitAnyMatch() {
        // TODO: implement this exercise
    	var list = List.of(1,2,3,4,5,6,7,8,9,10,11);
		System.out.println("list: " + list );
    	
		var countAll = list.stream()
                .peek(x -> System.out.println("Counting: " + x))
                .count();
		System.out.println("countAll: " + countAll );
		
		var hasEven = list.stream()
                .peek(x -> System.out.println("element anyMatch: " + x))
                .anyMatch(x -> x % 2 == 0);
		System.out.println(" even number? " + hasEven);
		
		var allPositive = list.stream()
                .peek(x -> System.out.println("allMatch : " + x))
                .allMatch(x -> x > 0);
		System.out.println("All positive? " + allPositive);
		
    }


    // =========================================================
    // EXERCISE 3 — Short-circuit with limit
    // =========================================================

    /**
     * Show that limit(n) stops processing the rest of the elements
     * after the first n values have passed through the pipeline.
     */
    private static void exercise3_ShortCircuitLimit() {
        // TODO: implement this exercise
        var words = List.of("ola", "ola", "manual", "Manual", "Manzana", "manzana", "telefono", "Telefono");
        
        words.stream()
        .peek(w -> System.out.println("word: " + w))       
        .filter(w -> w.length() >= 4)                                
        .peek(w -> System.out.println("filter length>=4: " + w))
        .map(String::toLowerCase)                                     
        .distinct()                                                   
        .peek(w -> System.out.println("distinct: " + w))
        .sorted()                                                     
        .peek(w -> System.out.println("sorted: " + w))
        .forEach(w -> System.out.println("final word: " + w));       

    }


    // =========================================================
    // EXERCISE 4 — Behavior of sorted()
    // =========================================================

    /**
     * Show that sorted() needs to see all elements before producing any
     * output downstream. With peek() before and after sorted(), we can
     * see that all "before" peeks appear before any "after" peek.
     */
    private static void exercise4_SortedBehavior() {
        // TODO: implement this exercise
        var nums = List.of(1,2,3,4,5,6,7,8,9,10);
        
        var anyGreater5 = nums.stream()
                .peek(n -> System.out.println("check anyMatch: " + n))
                .anyMatch(n -> n > 5);
        System.out.println("anyMatch >5? : " + anyGreater5);
      
        System.out.println();
            
        var allLessThan4 = nums.stream()
                .peek(n -> System.out.println("check allMatch: " + n))
                .allMatch(n -> n < 4);
        System.out.println("allMatch <4 ?: " + allLessThan4);
        
        System.out.println();
        
        boolean noneNegative = nums.stream()
                .peek(n -> System.out.println("check noneMatch: " + n))
                .noneMatch(n ->  n < 0);
        System.out.println("noneMatch <0?: " + noneNegative);

    }


    // =========================================================
    // EXERCISE 5 — noneMatch with an \"expensive\" predicate
    // =========================================================

    /**
     * Simulate an expensive predicate by printing a message for each check.
     * Show that noneMatch() stops as soon as it finds a match (and returns false).
     */
    private static void exercise5_NoneMatchExpensivePredicate() {
        // TODO: implement this exercise
        var nums = List.of(1,2,3,4,5,6,7,8,9,10);

        System.out.println("list: " + nums);
        
        nums.stream()
        .skip(3)  
        .limit(4) 
        .forEach(n -> System.out.println("number: " + n));
    }


    /**
     * Helper method that checks if a string contains any digit.
     */
    private static boolean containsDigit(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    // =========================================================
    // EXERCISE 6 — findFirst and lazy search
    // =========================================================

    /**
     * Use findFirst() to locate the first matching element and show
     * that the pipeline stops once that element is found.
     */
    private static void exercise6_FindFirstLazy() {
        // TODO: implement this exercise
        var words = List.of("ola", "manual", "manzana", "telefono", "casa");

        var stream  = words.stream()
                .peek(w -> System.out.println("checking: " + w))
                .filter(w -> w.length()>5)
                .findFirst();
    }


    // =========================================================
    // EXERCISE 7 — A Stream cannot be reused
    // =========================================================

    /**
     * Demonstrate that once a Stream has been consumed by a terminal operation,
     * it cannot be used again. Trying to do so throws IllegalStateException.
     */
    private static void exercise7_StreamCannotBeReused() {
        // TODO: implement this exercise
    }
    
    
}

/**
 * Auxiliary class used in exercise 6.
 */
class Person {
    private final String name;
    private final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}


// =========================================================
// MINI APPLICATION 
// =========================================================

class TruthTableLab {

    // ---------------------------------------------------------
    // Basic configuration
    // ---------------------------------------------------------

    // Number of propositional variables (p, q, r)
    private static final int N_VARS = 3;

    // Variable names by position: index 0 -> "p", 1 -> "q", 2 -> "r"
    private static final String[] VAR_NAMES = { "p", "q", "r" };

    /**
     * Possible classifications for a formula.
     */
    public enum FormulaType {
        TAUTOLOGY,
        CONTRADICTION,
        CONTINGENT
    }

    /**
     * Helper class to store a formula together with a human-readable name.
     */
    public static class NamedFormula {
        private final String name;
        private final Predicate<boolean[]> predicate;

        public NamedFormula(String name, Predicate<boolean[]> predicate) {
            this.name = name;
            this.predicate = predicate;
        }

        public String getName() {
            return name;
        }

        public Predicate<boolean[]> getPredicate() {
            return predicate;
        }
    }

    // ---------------------------------------------------------
    // For running the mini-application
    // ---------------------------------------------------------

    /**
     * Run the Truth Table Lab:
     *  - generate all interpretations,
     *  - define base predicates for p, q, r,
     *  - build a list of formulas by composition,
     *  - classify each formula using Streams,
     *  - print the result.
     */
    public void runLab() {
        System.out.println("=== Truth Table Lab ===");
        System.out.println();

        // 1) Generate all interpretations for N_VARS variables
        List<boolean[]> interpretations = generateInterpretations(N_VARS);

        // 2) Define base predicates for variables p, q, r
        Predicate<boolean[]> p = vals -> vals[0];
        Predicate<boolean[]> q = vals -> vals[1];
        Predicate<boolean[]> r = vals -> vals[2];

        // 3) Build formulas by composing p, q, r
        List<NamedFormula> formulas = buildFormulas(p, q, r);

        // 4) Classify each formula using Streams
        //for (NamedFormula f : formulas) {
        //    FormulaType type = classifyFormula(f, interpretations);
        //    printClassification(f, type);
        //}
        
        formulas.stream()
        .forEach(f -> printClassification(f, classifyFormula(f, interpretations)));
    }

    // ---------------------------------------------------------
    // Step 1: generate all interpretations
    // ---------------------------------------------------------

    /**
     * Imperative helper: decode an integer into a boolean[] of length n.
     * Each bit of num corresponds to the truth value of one variable.
     *
     * For example, with n = 3:
     *   num = 0 (binary 000) -> [false, false, false]
     *   num = 5 (binary 101) -> [true, false, true]
     *
     * This method is intentionally written in a simple imperative style.
     * Students will receive this method already implemented and will only
     * be asked to use it inside generateInterpretations().
     */
    private static boolean[] decode(int num, int n) {
        boolean[] vals = new boolean[n];
        for (int i = 0; i < n; i++) {
            // Check bit i of num: if it is 1 -> true, otherwise false
            vals[i] = ((num >> i) & 1) == 1;
        }
        return vals;
    }

    /**
     * Generate all possible interpretations (truth assignments) for n
     * propositional variables.
     *
     * The result is a List<boolean[]> of size 2^n. Each boolean[]
     * represents one interpretation, where vals[0] is the value of the
     * first variable, vals[1] of the second, and so on.
     *
     * This method uses Streams (iterate + limit + forEach), but students
     * are not required to use map or mapToObj.
     */
    private static List<boolean[]> generateInterpretations(int n) {
        // TODO: implement this method using Streams as described in the worksheet
    	
    	List<boolean[]> result = new ArrayList<>();
    	
    	
    	return result;
    }


    // ---------------------------------------------------------
    // Step 2 and 3: build formulas by composition
    // ---------------------------------------------------------

    /**
     * Build a list of NamedFormula objects by composing predicates
     * for p, q, r. Here we show several example formulas:
     *
     *  - p AND q
     *  - p OR NOT p        (tautology)
     *  - p AND NOT p       (contradiction)
     *  - (p AND q) -> r
     *  - p -> (q OR r)
     */
    private static List<NamedFormula> buildFormulas(
            Predicate<boolean[]> p,
            Predicate<boolean[]> q,
            Predicate<boolean[]> r) {
        // TODO: build the list of NamedFormula objects by composing predicates p, q, r
    	List<NamedFormula> formulas = new ArrayList<>();
    	
        return formulas;
    }


    // ---------------------------------------------------------
    // Step 4: classify formulas using Streams
    // ---------------------------------------------------------

    /**
     * Classify a formula as TAUTOLOGY, CONTRADICTION or CONTINGENT
     * using the list of interpretations and a Stream pipeline.
     *
     *  - TAUTOLOGY: true in all interpretations.
     *  - CONTRADICTION: false in all interpretations.
     *  - CONTINGENT: true in some interpretations and false in others.
     */
    private static FormulaType classifyFormula(
            NamedFormula formula,
            List<boolean[]> interpretations) {
        // TODO: classify the formula as TAUTOLOGY, CONTRADICTION or CONTINGENT using Streams
    	
    	return FormulaType.TAUTOLOGY;
    }


    /**
     * Print a short summary for the given formula and its classification.
     */
    private static void printClassification(NamedFormula formula, FormulaType type) {
        System.out.println("Formula: " + formula.getName());
        System.out.println("  Type: " + type);
        System.out.println();
    }

    // ---------------------------------------------------------
    // Optional: helper to format an interpretation (for future use or demos)
    // ---------------------------------------------------------


}
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
    }


    // =========================================================
    // EXERCISE 2 — Function: different result
    // =========================================================

    private static void exercise2_FunctionDifferentResult() {
        // TODO: implement this exercise
    }


    // =========================================================
    // EXERCISE 3 — Predicate: De Morgan
    // =========================================================

    private static void exercise3_PredicateDeMorgan() {
        // TODO: implement this exercise
    }


    // =========================================================
    // EXERCISE 4 — Consumer: chaining effects
    // =========================================================

    private static void exercise4_ConsumerOrderEffects() {
        // TODO: implement this exercise
    }


    // =========================================================
    // EXERCISE 5 — Comparator: reversed()
    // =========================================================

    private static void exercise5_ComparatorReversed() {
        // TODO: implement this exercise
    }


    // =========================================================
    // EXERCISE 6 — Comparator: two criteria
    // =========================================================

    private static void exercise6_ComparatorTwoCriteria() {
        // TODO: implement this exercise
    }


    // =========================================================
    // EXERCISE 7 — Comparator: nullsLast
    // =========================================================

    private static void exercise7_ComparatorNullsLast() {
        // TODO: implement this exercise
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
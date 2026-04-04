package Client;

import Context.Spacecraft;

public class Application_NoState {

    public static void main(String[] args) {
        Spacecraft spacecraft = new Spacecraft();

        System.out.println("=== Demo WITHOUT State pattern ===");
        System.out.println(spacecraft.status());

        System.out.println("\nAction: advance()");
        spacecraft.advance();
        System.out.println(spacecraft.status());

        System.out.println("\nAction: abort()");
        spacecraft.abort();
        System.out.println(spacecraft.status());

        System.out.println("\nAction: advance()");
        spacecraft.advance();
        System.out.println(spacecraft.status());

        System.out.println("\nAction: advance()");
        spacecraft.advance();
        System.out.println(spacecraft.status());

        System.out.println("\nAction: abort()");
        spacecraft.abort();
        System.out.println(spacecraft.status());

        System.out.println("\nObservation:");
        System.out.println("- The behavior of advance()/abort() depends on the current phase.");
        System.out.println("- The logic is implemented using switch(phase) inside multiple methods.");
    }
}


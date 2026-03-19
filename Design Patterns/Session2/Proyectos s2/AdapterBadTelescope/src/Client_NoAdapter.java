import AdapterBadTelescope.ModernLocator;

public class Client_NoAdapter {

    public static void main(String[] args) {

        ModernLocator modern = new ModernLocator();

        System.out.println("=== Demo WITHOUT Adapter pattern ===");

        locateGranules(modern);
        locatePlanars(modern);
        locateSemiQuanta(modern);
    }

    // --- Legacy-like operations implemented directly in the client ---

    private static void locatePlanars(ModernLocator modern) {
        System.out.println("Client: BEGIN locating planars ==========>");
        modern.tuneGammas();
        System.out.println("Client: gamma tuned; now completing planars with alpha");
        modern.tuneAlphas();
        System.out.println("<========== Client: END locating planars");
    }

    private static void locateGranules(ModernLocator modern) {
        System.out.println("Client: BEGIN locating granules ==========>");
        modern.tuneAlphas();
        System.out.println("Client: alpha tuned to complete granules");
        System.out.println("<========== Client: END locating granules");
    }

    private static void locateSemiQuanta(ModernLocator modern) {
        System.out.println("Client: BEGIN locating semi-quanta ==========>");
        modern.tuneGammas();
        System.out.println("Client: gamma tuned to complete semi-quanta");
        System.out.println("<========== Client: END locating semi-quanta");
    }
}

import AdapterBadTelescope.ModernLocator;
import adapter.ModernToLegacyLocatorAdapter;
import interfaz.LegacyLocator;

public class Main_Adapter {
	public static void main(String[] args) {
		ModernLocator modern = new ModernLocator();
        LegacyLocator locator = new ModernToLegacyLocatorAdapter(modern);

        System.out.println("=== Demo WITH Adapter pattern ===");

        locator.locateGranules();
        locator.locatePlanars();
        locator.locateSemiQuanta();
    }
}



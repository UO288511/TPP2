package adapter;

import AdapterBadTelescope.ModernLocator;
import interfaz.LegacyLocator;

public class ModernToLegacyLocatorAdapter implements LegacyLocator{
	
	private ModernLocator modernLocator;
	
	public ModernToLegacyLocatorAdapter(ModernLocator modernLocator) {
        this.modernLocator = modernLocator;
    }

	@Override
	public void locatePlanars() {
		System.out.println("Adapter: locating planars");
		modernLocator.tuneGammas();
		modernLocator.tuneAlphas();
		
	}

	@Override
	public void locateGranules() {
		System.out.println("Adapter: locating granules");
		modernLocator.tuneAlphas();
		
	}

	@Override
	public void locateSemiQuanta() {
		System.out.println("Adapter: locating Semi Quanta");
		modernLocator.tuneAlphas();
		
	}

}

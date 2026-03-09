package tpp.fp.exam.model;

public class Customer {

	private String id;
	private String name;
	private String country;
	private Tier tier;

	public Customer(String id, String name, String country, Tier tier) {
		this.id = id;
		this.name = name;
		this.country = country;
		this.tier = tier;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return the tier
	 */
	public Tier getTier() {
		return tier;
	}

	@Override
	public String toString() {
		return String.format("Customer [id=%s, name=%s, country=%s, tier=%s]", id, name, country, tier);
	}
}

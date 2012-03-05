package creative.fire.jsfrf.jsf.selection;

public class Province {
	private String name;
	private String abbreviation;
	private String capital;

	public Province(String name, String abbreviation, String capital) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.capital = capital;
	}

	public String getAbbreviation() {
		return this.abbreviation;
	}

	public String getCapital() {
		return this.capital;
	}

	public String getName() {
		return this.name;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public void setName(String name) {
		this.name = name;
	}

}

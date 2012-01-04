package creative.fire.jsfrf.jsf.input;

public class Yijing {

	private String sequence;
	private String name;
	private String pronounce;

	public Yijing(String sequence, String name, String pronounce) {
		this.sequence = sequence;
		this.name = name;
		this.pronounce = pronounce;
	}

	public String getSequence() {
		return sequence;
	}

	public String getName() {
		return name;
	}

	public String getPronounce() {
		return pronounce;
	}

}

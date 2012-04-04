package creative.fire.jsfrf.jsf.input;

import java.io.Serializable;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
public class Yijing implements Serializable {
	private static final long serialVersionUID = 8121085939736428628L;
	private String sequence;
	private String name;
	private String pronounce;

	public Yijing() {

	}

	public Yijing(String sequence, String name, String pronounce) {
		this.sequence = sequence;
		this.name = name;
		this.pronounce = pronounce;
	}

	public String getName() {
		return name;
	}

	public String getPronounce() {
		return pronounce;
	}

	public String getSequence() {
		return sequence;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return sequence + ":" + name + ":" + pronounce;
	}
}

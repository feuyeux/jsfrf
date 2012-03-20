package creative.fire.jsfrf.jsf.input;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
public class Player {
	private String name;
	private String number;
	private String position;
	private boolean checked;

	public Player() {
	}

	public Player(String number, String name, String position) {
		super();
		this.name = name;
		this.number = number;
		this.position = position;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (obj instanceof Player) {
			Player other = (Player) obj;
			return name.equals(other.getName());
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public String getPosition() {
		return position;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return number + ":" + name + ":" + position;
	}
}

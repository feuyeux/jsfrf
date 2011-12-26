package creative.fire.jsfrf.jsf.input;

public class Player {
	private String name;
	private String number;
	private String position;
	private boolean checked;

	public Player(String number, String name, String position) {
		super();
		this.name = name;
		this.number = number;
		this.position = position;
	}

	public Player() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj instanceof Player) {
			Player other = (Player) obj;
			return this.name.equals(other.getName());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public String toString() {
		return this.number + ":" + this.name + ":" + this.position;
	}
}
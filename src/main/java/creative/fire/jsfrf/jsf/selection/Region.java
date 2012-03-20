package creative.fire.jsfrf.jsf.selection;

import java.util.ArrayList;

public class Region {
	private String name;
	private ArrayList<Province> provinces;

	public Region(String name, ArrayList<Province> provinces) {
		super();
		this.name = name;
		this.provinces = provinces;
	}

	public int getCount() {
		return provinces.size();
	}

	public String getName() {
		return name;
	}

	public ArrayList<Province> getProvinces() {
		return provinces;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProvinces(ArrayList<Province> provinces) {
		this.provinces = provinces;
	}
}

package creative.fire.jsfrf.jsf.input;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "testList")
@ViewScoped
public class TestList {
	private List<String> item = new ArrayList<String>();
	private String selected;

	public TestList() {
		item.add("1");
		item.add("11");
		item.add("111");
	}

	public List<String> getItem() {
		return item;
	}

	public void setItem(List<String> item) {
		this.item = item;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public void print() {
		System.out.println(this.selected);
	}

}

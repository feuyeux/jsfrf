package creative.fire.jsfrf.jsf.input;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean(name = "testList")
@ViewScoped
public class TestList {
	private java.util.HashSet<String> item = new java.util.HashSet<String>();
	private String selected;

	public TestList() {
		item.add("1");
		item.add("11");
		item.add("111");
	}

	public java.util.HashSet<String> getItem() {
		return item;
	}

	public void setItem(java.util.HashSet<String> item) {
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

package creative.fire.jsfrf.jsf.input;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean(name = "testList")
@ViewScoped
public class TestList implements Serializable {
	private static final long serialVersionUID = -7167737890795683649L;
	private java.util.HashSet<String> item = new java.util.HashSet<String>();
	private java.util.Collection<String> list = new java.util.ArrayList<String>();
	private String selected;

	public TestList() {
		this.item.add("1");
		this.item.add("21");
		this.item.add("11");
		this.item.add("31");
		this.item.add("111");
		this.list.add("a");
		this.list.add("aa");
		this.list.add("b");
	}

	public java.util.HashSet<String> getItem() {
		return this.item;
	}

	public java.util.Collection<String> getList() {
		return this.list;
	}

	public String getSelected() {
		return this.selected;
	}

	public void print() {
		System.out.println(this.selected);
	}

	public void setItem(java.util.HashSet<String> item) {
		this.item = item;
	}

	public void setList(java.util.ArrayList<String> list) {
		this.list = list;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

}

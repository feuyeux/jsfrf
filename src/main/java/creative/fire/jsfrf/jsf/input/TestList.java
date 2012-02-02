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
public class TestList implements Serializable{
	private static final long serialVersionUID = -7167737890795683649L;
	private java.util.HashSet<String> item = new java.util.HashSet<String>();
	private java.util.Collection<String> list = new java.util.ArrayList<String>();
	private String selected;

	public TestList() {
		item.add("1");
		item.add("21");
		item.add("11");
		item.add("31");
		item.add("111");
		list.add("a");
		list.add("aa");
		list.add("b");
	}

	public java.util.HashSet<String> getItem() {
		return item;
	}

	public void setItem(java.util.HashSet<String> item) {
		this.item = item;
	}

	public java.util.Collection<String> getList() {
		return list;
	}

	public void setList(java.util.ArrayList<String> list) {
		this.list = list;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public void print() {
		System.out.println(selected);
	}

}

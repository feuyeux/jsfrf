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
		list.add("1 乾 qián");
		list.add("2 坤 kūn");
		list.add("29 坎 kǎn");
		list.add("30 离 lí");
		list.add("51 震 zhèn");
		list.add("52 艮 gèn");
		list.add("57 巽 xùn");
		list.add("58 兑 duì");		
		item.addAll(list);
	}

	public java.util.HashSet<String> getItem() {
		return item;
	}

	public java.util.Collection<String> getList() {
		return list;
	}

	public String getSelected() {
		return selected;
	}

	public void print() {
		System.out.println(selected);
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

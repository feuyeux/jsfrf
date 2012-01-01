package creative.fire.jsfrf.jsf.input;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean(name = "text")
@SessionScoped
public class TextBean implements Serializable {
	private static final long serialVersionUID = 7515550212656544309L;
	private String value;
	@ManagedProperty(value="123456")
	private String secretValue;
	private boolean rendered;
	private ArrayList<String> testList;
	private Map<String, String> testMap;

	@PostConstruct
	public void initialize() {
		testList = new ArrayList<String>();
		testMap = new HashMap<String, String>();
		testList.add("甲");
		testList.add("乙");
		testList.add("丙");
		testList.add("丁");

		testMap.put("a", "甲");
		testMap.put("b", "乙");
		testMap.put("c", "丙");
		testMap.put("d", "丁");
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSecretValue() {
		return secretValue;
	}

	public void setSecretValue(String secretValue) {
		this.secretValue = secretValue;
	}

	public ArrayList<String> getTestList() {
		return testList;
	}

	public void setTestList(ArrayList<String> testList) {
		this.testList = testList;
	}

	public Map<String, String> getTestMap() {
		return testMap;
	}

	public void setTestMap(Map<String, String> testMap) {
		this.testMap = testMap;
	}

	public boolean isRendered() {
		return rendered;
	}

	public void setRendered(boolean rendered) {
		this.rendered = rendered;
	}

	public void foo() {
		System.out.println(value);
	}

	public void foo0(ValueChangeEvent e) {
		Object oldone = e.getOldValue();
		Object newone = e.getOldValue();
		String oldValue = "";
		String newValue = "";
		if (oldone != null)
			oldValue = oldone.toString();
		if (newone != null)
			newValue = newone.toString();
		System.out.format("原值=%s 新值=%s 周期阶段=%s 来自：%s 组件：%s\t", oldValue, newValue, e.getPhaseId(), e.getSource(), e.getComponent());
		System.out.println(value);
	}

	public void update(String rendered, String value) {
		System.out.println(this.value);
		this.value = value;
		this.rendered = rendered.equals("true");
	}

	public void update0() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String rendered = params.get("rendered");
		this.value = params.get("textValue");
		this.rendered = rendered.equals("true");
	}
}

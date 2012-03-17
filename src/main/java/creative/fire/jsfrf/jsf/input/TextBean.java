package creative.fire.jsfrf.jsf.input;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.apache.log4j.Logger;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean(name = "text")
@RequestScoped
public class TextBean implements Serializable {
	private static final long serialVersionUID = 7515550212656544309L;
	transient static Logger logger = Logger.getLogger(TextBean.class);
	private String value;
	@ManagedProperty(value = "123456")
	private String secretValue;
	private boolean rendered;
	private ArrayList<String> testList;
	private Map<String, String> testMap;
	@ManagedProperty(value = "1")
	private int intValue;

	public void foo() {
		TextBean.logger.info(this.value);
	}

	public void foo0(ValueChangeEvent e) {
		Object oldone = e.getOldValue();
		Object newone = e.getOldValue();
		String oldValue = "";
		String newValue = "";
		if (oldone != null) {
			oldValue = oldone.toString();
		}
		if (newone != null) {
			newValue = newone.toString();
		}
		TextBean.logger.info(String.format("原值=%s 新值=%s 周期阶段=%s 来自组件：%s\t", oldValue, newValue, e.getPhaseId(), e.getSource().getClass()));
		TextBean.logger.debug(this.value);
	}

	public String foo1() {
		TextBean.logger.info(this.intValue);
		return "end";// end?faces-redirect=true";
	}

	public int getIntValue() {
		return this.intValue;
	}

	public String getSecretValue() {
		return this.secretValue;
	}

	public ArrayList<String> getTestList() {
		return this.testList;
	}

	public Map<String, String> getTestMap() {
		return this.testMap;
	}

	public String getValue() {
		return this.value;
	}

	@PostConstruct
	public void initialize() {
		this.testList = new ArrayList<String>();
		this.testMap = new HashMap<String, String>();
		this.testList.add("甲");
		this.testList.add("乙");
		this.testList.add("丙");
		this.testList.add("丁");

		this.testMap.put("a", "甲");
		this.testMap.put("b", "乙");
		this.testMap.put("c", "丙");
		this.testMap.put("d", "丁");
	}

	public boolean isRendered() {
		return this.rendered;
	}

	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	public void setRendered(boolean rendered) {
		this.rendered = rendered;
	}

	public void setSecretValue(String secretValue) {
		this.secretValue = secretValue;
	}

	public void setTestList(ArrayList<String> testList) {
		this.testList = testList;
	}

	public void setTestMap(Map<String, String> testMap) {
		this.testMap = testMap;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void update(String rendered, String value) {
		this.rendered = rendered.equals("true");
		this.value = value;
	}

	public void update0() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String rendered = params.get("rendered");
		this.rendered = "true".equals(rendered);
		this.value = params.get("textValue");
	}

	public void update1(javax.faces.event.ActionEvent event) {
		TextBean.logger.info(event.getSource().getClass().getName());
		UIComponent component = event.getComponent();
		HtmlCommandButton button1 = (HtmlCommandButton) event.getSource();
		HtmlCommandButton button2 = (HtmlCommandButton) component;
		TextBean.logger.debug(button1.getClientId());
		TextBean.logger.debug(button2.getParent().getClientId());
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String rendered = params.get("rendered");
		this.rendered = "true".equals(rendered);
		this.value = params.get("textValue");
	}

	public void update2(javax.faces.event.ActionEvent event) {
		TextBean.logger.info(this.testList.get(0));
	}
}

package creative.fire.jsfrf.jsf.input;

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
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
	private String secretValue="123456";
	
	private boolean rendered;

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

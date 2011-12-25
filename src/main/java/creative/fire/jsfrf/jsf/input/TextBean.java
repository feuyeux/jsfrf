package creative.fire.jsfrf.jsf.input;

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "text")
@ViewScoped
public class TextBean implements Serializable {
	private static final long serialVersionUID = 7515550212656544309L;
	private String value = "1-2-3-4-5-6-7-8-9-0";
	private boolean rendered;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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

	public void update(String rendered, String value) {
		System.out.println(value);
		this.value = value;
	}

	public void update0() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String rendered = params.get("rendered");
		value = params.get("value");
		this.rendered = rendered.equals("true");
	}
}

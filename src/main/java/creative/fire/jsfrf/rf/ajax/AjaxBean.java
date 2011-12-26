package creative.fire.jsfrf.rf.ajax;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "poll")
@ViewScoped
public class AjaxBean {
	private boolean enabled;
	private String value = "Start...";

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void update() {
		if (enabled) {
			value = "DONE.";
			enabled = true;
		}
	}
}

package creative.fire.jsfrf.rf.ajax;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "a4jBean")
@ViewScoped
public class AjaxBean implements Serializable{
	private static final long serialVersionUID = -8466210162305133523L;
	private boolean enabled;
	private String value = "初始";

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
			this.value = "完毕";
			enabled = true;
		}
	}

	
	public void walk() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.value = "[" + value + "]";
	}
}

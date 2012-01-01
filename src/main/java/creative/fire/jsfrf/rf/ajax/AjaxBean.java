package creative.fire.jsfrf.rf.ajax;

import java.io.Serializable;
 
public class AjaxBean implements Serializable {
	private static final long serialVersionUID = -8466210162305133523L;

	private boolean enabled;
 
	private String value;

	private int increase = 0;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getValue() {
		return value + increase++;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void update(String toggle) {
		if (toggle.equals("1")) {
			enabled = true;
		} else {
			enabled = false;
		}
	}

	public void forceUpdate() {
		this.value = "完毕";
	}

	public void walk() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.enabled = true;
		this.value = "[" + value + "]";
	}
}
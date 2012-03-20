package creative.fire.jsfrf.rf.output;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean
@ViewScoped
public class ProgressBarBean implements Serializable {
	private static final long serialVersionUID = -7792734089907881292L;
	private boolean enabled = false;
	private int current;

	public int getCurrent() {
		if (isEnabled()) {
			if (current > 100) {
				enabled = false;
				current = -1;
			} else {
				current += 5;
			}
		} else {
			current = -1;
		}
		return current;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void start() {
		enabled = true;
		current++;
	}
}

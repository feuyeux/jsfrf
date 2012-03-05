package creative.fire.jsfrf.rf.ajax;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
// a4jBean see faces-config.xml
@ManagedBean(name = "a4jBean")
@ViewScoped
public class AjaxBean implements Serializable {
	private static final long serialVersionUID = -8466210162305133523L;
	static Logger logger = Logger.getLogger(AjaxBean.class);
	private boolean enabled;
	private String value;
	private int increase = 0;

	public AjaxBean() {
		AjaxBean.logger.debug("a4jBean is creating.");
	}

	public void bar() {
		this.increase++;
	}

	public void foo() {
		AjaxBean.logger.info("foo bar baz");
	}

	public void forceUpdate() {
		this.value = "完毕";
	}

	public int getIncrease() {
		return this.increase;
	}

	public String getValue() {
		this.increase++;
		return this.value;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void update(String toggle) {
		if (toggle.equals("1")) {
			this.enabled = true;
		} else {
			this.enabled = false;
		}
		AjaxBean.logger.info("enabled=" + this.enabled);
	}

	public void walk() {
		try {
			AjaxBean.logger.info("休眠2秒");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.enabled = true;
		this.value = "[" + this.value + "]";
	}
}
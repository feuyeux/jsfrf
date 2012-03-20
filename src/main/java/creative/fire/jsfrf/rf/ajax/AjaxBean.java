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
	transient static Logger logger = Logger.getLogger(AjaxBean.class);
	private boolean enabled;
	private String value;
	private int increase = 0;

	public AjaxBean() throws Exception {
		AjaxBean.logger.debug("a4jBean is creating.");
		//throw new Exception("luh test.");
	}

	public void bar() {
		increase++;
	}

	public void foo() {
		AjaxBean.logger.info("foo bar baz");
	}

	public void forceUpdate() {
		value = "完毕";
	}

	public int getIncrease() {
		return increase;
	}

	public String getValue() {
		increase++;
		return value;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
		AjaxBean.logger.info("enabled=" + enabled);
	}

	public void walk() {
		try {
			AjaxBean.logger.info("休眠2秒");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		enabled = true;
		value = "[" + value + "]";
	}
}
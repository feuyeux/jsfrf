package creative.fire.jsfrf.el;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

import creative.fire.jsfrf.global.JSFRFFaces;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean(name = "jsfrfFlash")
@RequestScoped
public class JSFRFFlash {
	transient static Logger logger = Logger.getLogger(JSFRFFlash.class);

	public String forward() {
		logger.info("forward测试");
		return "flashKeep";
	}

	public String redirect() {
		logger.info("redirect测试");
		return "flashKeep?faces-redirect=true";
	}

	public String test() {
		String value0 = (String) JSFRFFaces.getFlash().get("value0");
		logger.info("flash.value0=" + value0);
		JSFRFFaces.getFlash().put("value1", "123456");
		return "flashKeep?faces-redirect=true";
	}

}

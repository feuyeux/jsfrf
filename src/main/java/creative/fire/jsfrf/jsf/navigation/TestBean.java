package creative.fire.jsfrf.jsf.navigation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean
@RequestScoped
public class TestBean {
	transient static Logger logger = Logger.getLogger(TestBean.class);
	private double param1;
	private boolean lived;

	public String foo() {
		logger.info("导航测试");
		return "nav1";
	}

	public String bar() {
		logger.info("导航测试");
		return "nav2";
	}

	public String baz(boolean lived) {
		logger.info("导航测试 " + lived);
		this.lived = lived;
		return "nav3";
	}

	public double getParam1() {
		return param1;
	}

	public void setParam1(double param1) {
		this.param1 = param1;
	}

	public boolean isLived() {
		return lived;
	}

	public void setLived(boolean lived) {
		this.lived = lived;
	}

}

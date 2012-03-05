package creative.fire.jsfrf.jsf.ecss;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean(name = "ecss")
@ApplicationScoped
public class ECSS {
	private String vendor;
	private String color;

	public String getColor() {
		return this.color;
	}

	public String getVendor() {
		return this.vendor;
	}

	@PostConstruct
	public void init() {
		this.vendor = "vendor1";
		this.color = "blue";
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
}

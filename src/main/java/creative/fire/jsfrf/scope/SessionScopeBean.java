package creative.fire.jsfrf.scope;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SessionScopeBean implements Serializable {
	private static final long serialVersionUID = -7304920026236057607L;
	private String param1;

	public SessionScopeBean() {
		param1 = "";
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String foo() {
		return "";
	}
}

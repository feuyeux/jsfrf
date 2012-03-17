package creative.fire.jsfrf.scope;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class AppScopeBean implements Serializable {
	private static final long serialVersionUID = 6330752654507445185L;
	private String param1;

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}
}

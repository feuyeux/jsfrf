/**
 * 
 */
package creative.fire.jsfrf.profile;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * @author Administrator
 *
 */
@ManagedBean
@RequestScoped
public class ConfigBean {
	Map attributes;
	Map parameters;

	public ConfigBean() {
		attributes = FacesContext.getCurrentInstance().getAttributes();
		parameters = FacesContext.getCurrentInstance().getExternalContext().getInitParameterMap();
	}

	public Map getAttributes() {
		return attributes;
	}

	public Map getParameters() {
		return parameters;
	}
}

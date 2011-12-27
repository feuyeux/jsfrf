package creative.fire.jsfrf.global;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name = "jsfrfEnv")
@ApplicationScoped
public class JSFRFEnvironment {
	private String contextPath;
	private String cssPath;
	private String imagePath;
	private String jsPath;

	public String getContextPath() {
		if (contextPath == null) {
			final ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			contextPath = externalContext.getRequestContextPath();
		}
		return contextPath;
	}

	public String getCssPath() {
		if (cssPath == null) {
			cssPath = getContextPath() + "/resources/css/";
		}
		return cssPath;
	}

	public String getImagePath() {
		if (imagePath == null) {
			imagePath = getContextPath() + "/resources/img/";
		}
		return imagePath;
	}

	public String getJsPath() {
		if (jsPath == null)
			jsPath = getContextPath() + "/resources/javascript/";
		return jsPath;
	}
}

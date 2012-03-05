package creative.fire.jsfrf.global;

import java.util.TimeZone;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean(name = "jsfrfEnv")
@ApplicationScoped
public class JSFRFEnvironment {
	private String contextPath;
	private String cssPath;
	private String imagePath;
	private String jsPath;

	public String getContextPath() {
		if (this.contextPath == null) {
			final ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			this.contextPath = externalContext.getRequestContextPath();
		}
		return this.contextPath;
	}

	public String getCssPath() {
		if (this.cssPath == null) {
			this.cssPath = getContextPath() + "/resources/css/";
		}
		return this.cssPath;
	}

	public String getImagePath() {
		if (this.imagePath == null) {
			this.imagePath = getContextPath() + "/resources/img/";
		}
		return this.imagePath;
	}

	public String getJsPath() {
		if (this.jsPath == null) {
			this.jsPath = getContextPath() + "/resources/javascript/";
		}
		return this.jsPath;
	}

	public String getLanguage() {
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		return viewRoot.getLocale().getLanguage();
	}

	public String getTimeZoneId() {
		// String[] ids=TimeZone.getAvailableIDs();
		String zoneId = TimeZone.getDefault().getID();
		return zoneId;
	}
}

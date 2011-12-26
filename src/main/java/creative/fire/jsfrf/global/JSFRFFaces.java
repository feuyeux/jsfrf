package creative.fire.jsfrf.global;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class JSFRFFaces {
	public static String ERROR = "jsfrf_error";
	private String cssFilePath;
	private String imageFilePath;
	private String jsFilePath;

	public static HttpSession getSession() {
		final ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession session = (HttpSession) externalContext.getSession(true);
		return session;
	}

	public String getContextPath() {
		final ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		return externalContext.getRequestContextPath();
	}

	public String getCssFilePath() {
		if (cssFilePath == null) {
			cssFilePath = getContextPath() + "/resources/css/";
		}
		return cssFilePath;
	}

	public String getImagePath() {
		if (imageFilePath == null) {
			imageFilePath = getContextPath() + "/resources/images/";
		}
		return imageFilePath;
	}

	public String getJsFilePath() {
		if (jsFilePath == null)
			jsFilePath = getContextPath() + "/resources/javascript/";
		return jsFilePath;
	}
}

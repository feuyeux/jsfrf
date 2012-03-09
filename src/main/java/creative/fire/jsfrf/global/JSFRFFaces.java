package creative.fire.jsfrf.global;

import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.faces.application.Application;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
public class JSFRFFaces {
	public static String ERROR = "jsfrf_error";

	public static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public static ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}

	public static ELContext getELContext() {
		return getFacesContext().getELContext();
	}

	public static Application getApplication() {
		return getFacesContext().getApplication();
	}

	public static HttpSession getSession() {
		return (HttpSession) getExternalContext().getSession(true);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) getExternalContext().getRequest();
	}

	public static Map<String, String> getRequestParameterMap() {
		return getExternalContext().getRequestParameterMap();
	}

	public static ExpressionFactory getExpressionFactory() {
		return getApplication().getExpressionFactory();
	}
}
package creative.fire.jsfrf.global;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
public class JSFRFFaces {
	public static String ERROR = "jsfrf_error";

	public static ELContext getELContext() {
		return JSFRFFaces.getFacesContext().getELContext();
	}

	public static ExpressionFactory getExpressionFactory() {
		ExpressionFactory factory = JSFRFFaces.getFacesContext().getApplication().getExpressionFactory();
		return factory;
	}

	public static ExternalContext getExternalContext() {
		return JSFRFFaces.getFacesContext().getExternalContext();
	}

	public static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public static HttpSession getSession() {
		HttpSession session = (HttpSession) JSFRFFaces.getExternalContext().getSession(true);
		return session;
	}
}

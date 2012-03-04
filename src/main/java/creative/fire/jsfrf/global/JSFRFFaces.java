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

	public static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public static ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}

	public static ELContext getELContext() {
		return getFacesContext().getELContext();
	}

	public static HttpSession getSession() {
		HttpSession session = (HttpSession) getExternalContext().getSession(true);
		return session;
	}

	public static ExpressionFactory getExpressionFactory() {
		ExpressionFactory factory = getFacesContext().getApplication().getExpressionFactory();
		return factory;
	}
}

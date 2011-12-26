package creative.fire.jsfrf.global;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class JSFRFFaces {
	public static String ERROR = "jsfrf_error";
	public static HttpSession getSession() {
		final ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession session = (HttpSession) externalContext.getSession(true);
		return session;
	}
}

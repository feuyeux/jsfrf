package creative.fire.jsfrf.jsf.lifecycle;

import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.application.ViewExpiredException;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import javax.servlet.http.HttpSession;

import creative.fire.jsfrf.global.JSFRFFaces;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
public class JSFRFExceptionHandler extends ExceptionHandlerWrapper {

	private ExceptionHandler wrapped;

	public JSFRFExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return wrapped;
	}

	@Override
	public void handle() throws FacesException {
		for (Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator(); i.hasNext();) {
			ExceptionQueuedEvent event = i.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
			Throwable t = context.getException();
			if (t instanceof ViewExpiredException) {
				FacesContext fc = FacesContext.getCurrentInstance();
				NavigationHandler nav = fc.getApplication().getNavigationHandler();
				try {
					ViewExpiredException e = (ViewExpiredException) t;
					fc.getExternalContext().getFlash().put("currentViewId", e.getViewId());
					nav.handleNavigation(fc, null, "error");
					try {
						HttpSession session = JSFRFFaces.getSession();
						session.setAttribute(JSFRFFaces.ERROR, t.getLocalizedMessage());
					} catch (Exception se) {
						// TODO
					}
					fc.renderResponse();
				} finally {
					i.remove();
				}
			} else if (t instanceof javax.faces.view.facelets.FaceletException) {
				FacesContext fc = FacesContext.getCurrentInstance();
				NavigationHandler nav = fc.getApplication().getNavigationHandler();
				try {
					UIViewRoot root = fc.getViewRoot();
					if (root == null) {
						UIViewRoot viewRoot = fc.getApplication().getViewHandler().createView(fc, "fake");
						fc.setViewRoot(viewRoot);
					}
					nav.handleNavigation(fc, null, "error?faces-redirect=true");
					HttpSession session = JSFRFFaces.getSession();
					session.setAttribute(JSFRFFaces.ERROR, t.getLocalizedMessage());
					fc.renderResponse();
				} finally {
					i.remove();
				}
			}
		}
		getWrapped().handle();
	}
}
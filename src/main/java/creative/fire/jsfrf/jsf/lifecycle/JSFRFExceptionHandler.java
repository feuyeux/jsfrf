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

import org.apache.log4j.Logger;

import creative.fire.jsfrf.global.JSFRFFaces;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
public class JSFRFExceptionHandler extends ExceptionHandlerWrapper {
	private Logger logger = org.apache.log4j.Logger.getLogger(JSFRFExceptionHandler.class);
	private ExceptionHandler wrapped;

	public JSFRFExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;
	}

	@Override
	public void handle() throws FacesException {
		Iterator<ExceptionQueuedEvent> iter = getUnhandledExceptionQueuedEvents().iterator();
		while (iter.hasNext()) {
			ExceptionQueuedEvent event = iter.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
			Throwable t = context.getException();
			this.logger.error(t.getMessage());

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
					iter.remove();
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
					nav.handleNavigation(fc, null, "error");
					HttpSession session = JSFRFFaces.getSession();
					session.setAttribute(JSFRFFaces.ERROR, t.getLocalizedMessage());
					fc.renderResponse();
				} finally {
					iter.remove();
				}
			}
		}
		getWrapped().handle();
	}
}
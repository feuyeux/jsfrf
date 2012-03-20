package creative.fire.jsfrf.jsf.error;

import java.util.ArrayDeque;
import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIComponent;
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
	transient Logger logger = org.apache.log4j.Logger.getLogger(JSFRFExceptionHandler.class);
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
		Iterator<ExceptionQueuedEvent> unHandledEvents = getUnhandledExceptionQueuedEvents().iterator();
		while (unHandledEvents.hasNext()) {
			ExceptionQueuedEvent event = unHandledEvents.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
			Throwable t = context.getException();
			logger.error(t);
			FacesContext fc = context.getContext();
			if (fc.getPartialViewContext().isPartialRequest()) {
				continue;
			}

			if (fc.getRenderResponse()) {
				continue;
			}

			try {
				UIViewRoot root = fc.getViewRoot();
				if (root == null) {
					UIViewRoot viewRoot = fc.getApplication().getViewHandler().createView(fc, "fake");
					fc.setViewRoot(viewRoot);
				}
				NavigationHandler nav = fc.getApplication().getNavigationHandler();
				nav.handleNavigation(fc, null, "error");//?faces-redirect=true

				String phase = context.getPhaseId().toString();
				StringBuilder errorInfo = new StringBuilder();
				errorInfo.append("error: ").append(t.getLocalizedMessage());
				errorInfo.append("\r\nphase: ").append(phase);
				@SuppressWarnings("unchecked")
				ArrayDeque<UIComponent> deque = (ArrayDeque<UIComponent>) JSFRFFaces.getAttributes().get("javax.faces.component.CURRENT_COMPONENT_STACK");

				if (deque != null) {
					errorInfo.append("\r\ncomponent stack:");
					for (UIComponent comp : deque) {
						errorInfo.append("\r\nclass:").append(comp.getClass().getSimpleName());
						errorInfo.append("\tid:").append(comp.getId());
						errorInfo.append("\tclientId:").append(comp.getClientId());
					}
				}
				HttpSession session = JSFRFFaces.getSession();
				session.setAttribute(JSFRFFaces.ERROR, errorInfo.toString());
				//可选方案 TODO
				//JSFRFFaces.getFlash().put(JSFRFFaces.ERROR, errorInfo.toString());
				fc.renderResponse();
			} finally {
				unHandledEvents.remove();
			}
		}
		getWrapped().handle();
	}
}
package creative.fire.jsfrf.jsf.event;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.log4j.Logger;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
public class JSFRFPhaseListener implements PhaseListener {
	private static final long serialVersionUID = -4520688723151960719L;
	static Logger logger = Logger.getLogger(JSFRFPhaseListener.class);

	public void afterPhase(PhaseEvent event) {
		logger.info("after " + event.getPhaseId());
		if (PhaseId.RESTORE_VIEW == event.getPhaseId()) {
			String viewId = event.getFacesContext().getViewRoot().getViewId();
			String path = event.getFacesContext().getExternalContext().getRequestServletPath();
			logger.info("1 path: " + path);
			logger.info("1 viewId: " + viewId);
		}
	}

	public void beforePhase(PhaseEvent event) {
		logger.info("beforePhase " + event.getPhaseId());
		if (PhaseId.RENDER_RESPONSE == event.getPhaseId()) {
			String path = event.getFacesContext().getExternalContext().getRequestServletPath();
			String viewId = event.getFacesContext().getViewRoot().getViewId();
			logger.info("6 path: " + path);
			logger.info("6 viewId: " + viewId);
		}
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}

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
	transient static Logger logger = Logger.getLogger(JSFRFPhaseListener.class);

	@Override
	public void afterPhase(PhaseEvent event) {
		JSFRFPhaseListener.logger.info("after " + event.getPhaseId());
		if (PhaseId.RESTORE_VIEW == event.getPhaseId()) {
			try {
				String viewId = event.getFacesContext().getViewRoot().getViewId();
				String path = event.getFacesContext().getExternalContext().getRequestServletPath();
				JSFRFPhaseListener.logger.info("1 path: " + path);
				JSFRFPhaseListener.logger.info("1 viewId: " + viewId);
			} catch (Exception e) {
				logger.error(e.getLocalizedMessage());
			}

		}
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		JSFRFPhaseListener.logger.info("beforePhase " + event.getPhaseId());
		if (PhaseId.RENDER_RESPONSE == event.getPhaseId()) {
			try {
				String path = event.getFacesContext().getExternalContext().getRequestServletPath();
				String viewId = event.getFacesContext().getViewRoot().getViewId();
				JSFRFPhaseListener.logger.info("6 path: " + path);
				JSFRFPhaseListener.logger.info("6 viewId: " + viewId);
			} catch (Exception e) {
				logger.error(e.getLocalizedMessage());
			}
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}

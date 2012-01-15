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
	}

	public void beforePhase(PhaseEvent event) {
		if (PhaseId.RESTORE_VIEW == event.getPhaseId()) {
			// TODO
		}
		if (PhaseId.RENDER_RESPONSE == event.getPhaseId()) {
			// TODO
		}
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}

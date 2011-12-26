package creative.fire.jsfrf.jsf.lifecycle;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class JSFRFPhaseListener implements PhaseListener {
	private static final long serialVersionUID = -4520688723151960719L;

	public void afterPhase(PhaseEvent event) {
		// TODO

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

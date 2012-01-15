package creative.fire.jsfrf.jsf.event;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.log4j.Logger;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
public class TestPhaseListener implements PhaseListener {
	private static final long serialVersionUID = 7970894311410478241L;
	static Logger logger = Logger.getLogger(TestPhaseListener.class);

	public void beforePhase(PhaseEvent event) {
		logger.info("before " + event.getPhaseId());
	}

	public void afterPhase(PhaseEvent event) {
		//logger.info("after " + event.getPhaseId());
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}

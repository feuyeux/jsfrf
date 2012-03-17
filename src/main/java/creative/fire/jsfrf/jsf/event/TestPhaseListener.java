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
	transient static Logger logger = Logger.getLogger(TestPhaseListener.class);

	@Override
	public void afterPhase(PhaseEvent event) {
		// logger.info("after " + event.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		TestPhaseListener.logger.info("before " + event.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}

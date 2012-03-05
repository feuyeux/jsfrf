package creative.fire.jsfrf.rf.output;

import javax.faces.event.AbortProcessingException;

import org.apache.log4j.Logger;
import org.richfaces.event.PanelToggleEvent;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
public class JSFRFToggledListener implements org.richfaces.event.PanelToggleListener {
	private Logger logger = Logger.getLogger(JSFRFToggledListener.class);

	@Override
	public void processPanelToggle(PanelToggleEvent event) throws AbortProcessingException {
		this.logger.debug(event.getComponent().getClientId());
	}

}

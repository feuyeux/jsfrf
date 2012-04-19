package creative.fire.jsfrf.rf.output;

import javax.faces.event.AbortProcessingException;

import org.apache.log4j.Logger;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
public class JSFRFToggledListener implements org.richfaces.event.PanelToggleListener {
	private transient Logger logger = Logger.getLogger(JSFRFToggledListener.class);

	@Override
	public void processPanelToggle(org.richfaces.event.PanelToggleEvent event) throws AbortProcessingException {
		logger.debug(event.getComponent().getClientId());
	}
}

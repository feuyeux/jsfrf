package creative.fire.jsfrf.rf.output;

import javax.faces.event.AbortProcessingException;

import org.apache.log4j.Logger;
import org.richfaces.event.ItemChangeEvent;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
public class JSFRFItemChangeListener implements org.richfaces.event.ItemChangeListener {
	private transient Logger logger = Logger.getLogger(JSFRFItemChangeListener.class);

	@Override
	public void processItemChange(ItemChangeEvent event) throws AbortProcessingException {
		logger.debug(event.getNewItemName());
	}
}

package creative.fire.jsfrf.jsf.event;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import org.apache.log4j.Logger;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
public class TestValueChangeListener implements ValueChangeListener {
	static Logger logger = Logger.getLogger(TestValueChangeListener.class);

	@Override
	public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
		TestValueChangeListener.logger.info("id=" + event.getComponent().getClientId() + " class=" + event.getComponent().getClass().getName() + " 原值="
				+ event.getOldValue() + " 新值=" + event.getNewValue());
	}
}

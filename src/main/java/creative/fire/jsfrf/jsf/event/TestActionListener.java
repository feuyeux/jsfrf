package creative.fire.jsfrf.jsf.event;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import org.apache.log4j.Logger;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
public class TestActionListener implements ActionListener {
	transient static Logger logger = Logger.getLogger(TestActionListener.class);

	@Override
	public void processAction(ActionEvent actionEvent) throws AbortProcessingException {
		String id = actionEvent.getComponent().getClientId();
		TestActionListener.logger.info(id);
	}
}

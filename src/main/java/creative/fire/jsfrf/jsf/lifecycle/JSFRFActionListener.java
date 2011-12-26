package creative.fire.jsfrf.jsf.lifecycle;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.servlet.http.HttpSession;

import creative.fire.jsfrf.global.JSFRFFaces;

public class JSFRFActionListener implements ActionListener {
	public void processAction(ActionEvent actionEvent) throws AbortProcessingException {
		HttpSession session = JSFRFFaces.getSession();
		session.removeAttribute(JSFRFFaces.ERROR);
	}
}

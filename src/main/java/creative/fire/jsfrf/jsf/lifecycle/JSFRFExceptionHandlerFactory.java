package creative.fire.jsfrf.jsf.lifecycle;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
public class JSFRFExceptionHandlerFactory extends ExceptionHandlerFactory {

	private ExceptionHandlerFactory parent;

	public JSFRFExceptionHandlerFactory(ExceptionHandlerFactory parent) {
		this.parent = parent;
	}

	@Override
	public ExceptionHandler getExceptionHandler() {
		ExceptionHandler result = parent.getExceptionHandler();
		result = new JSFRFExceptionHandler(result);
		return result;
	}
}
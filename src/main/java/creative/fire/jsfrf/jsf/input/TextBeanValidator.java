package creative.fire.jsfrf.jsf.input;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@FacesValidator(value = "textValidator")
public class TextBeanValidator implements Validator {
	static Logger logger = Logger.getLogger(TextBeanValidator.class);

	@Override
	public void validate(FacesContext context, UIComponent component, Object obj) throws ValidatorException {
		String value = (String) obj;
		TextBeanValidator.logger.debug("validate: " + value);
		if (value.equals("feuyeux")) {
			FacesMessage message = new FacesMessage();
			message.setDetail("非法输入");
			message.setSummary("非法输入");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);

			throw new ValidatorException(message);
		}
	}
}

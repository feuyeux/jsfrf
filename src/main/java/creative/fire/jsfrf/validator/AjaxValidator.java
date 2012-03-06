package creative.fire.jsfrf.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import creative.fire.jsfrf.rf.ajax.AjaxBean;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@FacesValidator(value = "ajaxBeanValidator")
public class AjaxValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object obj) throws ValidatorException {
		if (null == obj)
			return;
		
		AjaxBean a4jBean = (AjaxBean) obj;
		String value = a4jBean.getValue();

		if (value.equals("feuyeux")) {
			FacesMessage message = new FacesMessage();
			message.setDetail("非法输入");
			message.setSummary("非法输入");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);

			throw new ValidatorException(message);
		}
	}
}

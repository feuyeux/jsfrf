package creative.fire.jsfrf.rf.ajax;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

 
@FacesValidator(value="ajaxConverter")
public class AjaxValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object obj) throws ValidatorException {
		String value=(String)obj;
		
		if(value.equals("feuyeux")){
			FacesMessage message=new FacesMessage();
			message.setDetail("非法输入");
			message.setSummary("非法输入");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			
			throw new ValidatorException(message);
		}
	}
}

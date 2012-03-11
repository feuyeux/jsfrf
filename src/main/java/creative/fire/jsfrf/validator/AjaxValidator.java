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
	public void validate(FacesContext fc, UIComponent c, Object obj) throws ValidatorException {
		if (null == obj)
			return;

		AjaxBean a4jBean = (AjaxBean) obj;
		String value = a4jBean.getValue();

		try {
			Integer.valueOf(value);
		}catch(java.lang.NumberFormatException ne){
			String summary = "验证处理中出现数值获取异常 NumberFormatException:"+ne.getMessage();
			throw new ValidatorException(new FacesMessage(summary), ne);
		} catch (Exception e) {
			String summary = "验证处理中出现意外:"+e.getMessage();
			throw new ValidatorException(new FacesMessage(summary), e);
		}

		if (value.equals("feuyeux")) {
			FacesMessage message = new FacesMessage();
			message.setDetail("非法输入");
			message.setSummary("非法输入");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);

			throw new ValidatorException(message);
		}
	}
}

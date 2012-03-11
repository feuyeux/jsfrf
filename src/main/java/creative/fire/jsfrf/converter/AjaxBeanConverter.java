package creative.fire.jsfrf.converter;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import creative.fire.jsfrf.global.JSFRFFaces;
import creative.fire.jsfrf.rf.ajax.AjaxBean;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@FacesConverter(value = "ajaxBeanConverter")
public class AjaxBeanConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (context == null || component == null) {
			throw new NullPointerException();
		}
		if (null == value || value.isEmpty()) {
			return null;
		}

		ELContext elContext = JSFRFFaces.getELContext();
		ExpressionFactory factory = JSFRFFaces.getExpressionFactory();
		String expression = "#{a4jBean}";
		ValueExpression valueExpression = factory.createValueExpression(elContext, expression, AjaxBean.class);
		AjaxBean a4jBean = (AjaxBean) valueExpression.getValue(elContext);

		if (a4jBean == null) {
			return null;
		}

		try {
			Integer.valueOf(value);
		} catch (java.lang.NumberFormatException ne) {
			FacesMessage message = new FacesMessage("转换处理中出现数值获取异常 NumberFormatException:" + ne.getMessage());
			throw new ConverterException(message, ne);
		} catch (Exception e) {
			String summary = "转换处理中出现意外:" + e.getLocalizedMessage();
			throw new ConverterException(new FacesMessage(summary), e);
		}

		a4jBean.setValue(value);
		return a4jBean;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Integer.valueOf(value.toString());
		if (context == null || component == null) {
			throw new NullPointerException();
		}
		if (null == value || 0 == value.toString().length()) {
			return null;
		}
		AjaxBean a4jBean = (AjaxBean) value;
		return a4jBean.getValue();
	}
}
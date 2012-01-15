package creative.fire.jsfrf.rf.ajax;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@FacesConverter(value = "ajaxBeanConverter")
public class AjaxBeanConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return (String) value;
	}
}
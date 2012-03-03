package creative.fire.jsfrf.jsf.input;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@FacesConverter(value = "textConverter")
public class TestBeanConverter implements Converter {
	static Logger logger = Logger.getLogger(TestBeanConverter.class);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		logger.debug("getAsObject");
		return value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		logger.debug("getAsString");
		return (String) value;
	}
}

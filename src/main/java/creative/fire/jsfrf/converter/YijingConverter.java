package creative.fire.jsfrf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import creative.fire.jsfrf.jsf.input.Yijing;
import creative.fire.jsfrf.jsf.input.YijingCollection;

@FacesConverter("yiConverter")
public class YijingConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String s) {
		for (Yijing yi : YijingCollection.getYijings()) {
			if (yi.getName().equals(s)) {
				return yi;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object o) {
		if (o == null) {
			return null;
		}
		return ((Yijing) o).getName();
	}
}
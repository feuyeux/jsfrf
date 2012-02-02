package creative.fire.jsfrf.jsf.input;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("yiConverter")
public class YijingConverter implements Converter {

	public Object getAsObject(FacesContext facesContext, UIComponent component, String s) {
		for (Yijing yi : YijingCollection.getYijings()) {
			if (yi.getName().equals(s)) {
				return yi;
			}
		}
		return null;
	}

	public String getAsString(FacesContext facesContext, UIComponent component, Object o) {
		if (o == null) {
			return null;
		}
		return ((Yijing) o).getName();
	}
}
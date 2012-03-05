package creative.fire.jsfrf.jsf.locale;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean(name = "jsfrfLocale")
@ApplicationScoped
public class JSFRFLocale {
	private List<Locale> localeList;
	private String selected;

	public List<Locale> getLocaleList() {
		if (this.localeList == null) {
			this.localeList = new ArrayList<Locale>();
			this.localeList.add(Locale.ENGLISH);
			this.localeList.add(Locale.SIMPLIFIED_CHINESE);
		}
		return this.localeList;
	}

	public String getSelected() {
		return this.selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public void updateLocale() {
		for (Locale locale : this.localeList) {
			if (this.selected.equals(locale.getLanguage())) {
				UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
				viewRoot.setLocale(locale);
				break;
			}
		}
	}
}

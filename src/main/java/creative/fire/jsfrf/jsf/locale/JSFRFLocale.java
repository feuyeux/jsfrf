package creative.fire.jsfrf.jsf.locale;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

@ManagedBean(name = "jsfrfLocale")
@ApplicationScoped
public class JSFRFLocale {
	private List<Locale> localeList;
	private String selected;

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public void updateLocale() {
		for (Locale locale : localeList) {
			if (selected.equals(locale.getLanguage())) {
				UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
				viewRoot.setLocale(locale);
				break;
			}
		}
	}

	public List<Locale> getLocaleList() {
		if (localeList == null) {
			localeList = new ArrayList<Locale>();
			localeList.add(Locale.ENGLISH);
			localeList.add(Locale.SIMPLIFIED_CHINESE);
		}
		return localeList;
	}
}

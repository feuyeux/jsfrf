package creative.fire.jsfrf.rf.menu;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.richfaces.component.UIPanelMenuGroup;
import org.richfaces.component.UIPanelMenuItem;
import org.richfaces.event.ItemChangeEvent;

@ManagedBean
@ViewScoped
public class PanelMenuBean {
	Logger logger = Logger.getLogger(PanelMenuBean.class);
	private String menuSelected;

	public String getMenuSelected() {
		return menuSelected;
	}

	public PanelMenuBean() {
	}

	public void itemChange(ItemChangeEvent event) {
		UIComponent component = event.getNewItem();
		if (component instanceof org.richfaces.component.UIPanelMenuItem) {
			org.richfaces.component.UIPanelMenuItem menuItem = (UIPanelMenuItem) component;
			logger.debug(menuItem.getClientId());
			menuSelected = event.getNewItemName() + " " + menuItem.getLabel();
		}
	}

	public void groupSelect(ActionEvent event) {
		org.richfaces.component.UIPanelMenuGroup menuGroup = (UIPanelMenuGroup) event.getComponent();
		menuSelected = menuGroup.getLabel();
	}

	public void itemSelect(String value) {
		menuSelected = value;
	}
}

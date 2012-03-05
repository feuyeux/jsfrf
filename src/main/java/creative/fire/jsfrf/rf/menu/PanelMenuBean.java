package creative.fire.jsfrf.rf.menu;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.richfaces.component.UIPanelMenuGroup;
import org.richfaces.component.UIPanelMenuItem;
import org.richfaces.event.ItemChangeEvent;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean
@ViewScoped
public class PanelMenuBean {
	Logger logger = Logger.getLogger(PanelMenuBean.class);
	private String menuSelected;

	public PanelMenuBean() {
	}

	public String getMenuSelected() {
		return this.menuSelected;
	}

	public void groupSelect(ActionEvent event) {
		org.richfaces.component.UIPanelMenuGroup menuGroup = (UIPanelMenuGroup) event.getComponent();
		this.menuSelected = menuGroup.getLabel();
	}

	public void itemChange(ItemChangeEvent event) {
		UIComponent component = event.getNewItem();
		if (component instanceof org.richfaces.component.UIPanelMenuItem) {
			org.richfaces.component.UIPanelMenuItem menuItem = (UIPanelMenuItem) component;
			this.logger.debug(menuItem.getClientId());
			this.menuSelected = event.getNewItemName() + " " + menuItem.getLabel();
		}
	}

	public void itemSelect(String value) {
		this.menuSelected = value;
	}
}

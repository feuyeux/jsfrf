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
	transient Logger logger = Logger.getLogger(PanelMenuBean.class);
	private String menuSelected;
	private String groupSeparator;
	private String groupItemSeparator;

	public PanelMenuBean() {
	}

	public String getMenuSelected() {
		return menuSelected;
	}

	public void groupChoose(ActionEvent event) {
		org.richfaces.component.UIPanelMenuGroup menuGroup = (UIPanelMenuGroup) event.getComponent();
		menuSelected = menuGroup.getLabel();
	}

	public void itemChoose(String value) {
		menuSelected = value;
	}

	public void itemChange(ItemChangeEvent event) {
		UIComponent component = event.getNewItem();
		if (component instanceof org.richfaces.component.UIPanelMenuItem) {
			org.richfaces.component.UIPanelMenuItem menuItem = (UIPanelMenuItem) component;
			logger.debug(menuItem.getClientId());
			menuSelected = event.getNewItemName() + " " + menuItem.getLabel();
		}
	}

	public void itemChange2(ActionEvent event) {
		event.getComponent();
	}

	public String getGroupSeparator() {
		return groupSeparator;
	}

	public void setGroupSeparator(String groupSeparator) {
		this.groupSeparator = groupSeparator;
	}

	public String getGroupItemSeparator() {
		return groupItemSeparator;
	}

	public void setGroupItemSeparator(String groupItemSeparator) {
		this.groupItemSeparator = groupItemSeparator;
	}

}

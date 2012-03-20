package creative.fire.jsfrf.rf.output;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.richfaces.event.PanelToggleEvent;
import org.richfaces.renderkit.util.PanelIcons;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean
@ViewScoped
public class CollapsedBean {
	private String status;
	private String icon0;
	private String icon1;

	private PanelIcons[] icons0 = { PanelIcons.disc, PanelIcons.grid, PanelIcons.none, PanelIcons.transparent };
	private PanelIcons[] icons1 = { PanelIcons.chevron, PanelIcons.chevronLeft, PanelIcons.chevronUp, PanelIcons.chevronDown, PanelIcons.triangle,
			PanelIcons.triangleLeft, PanelIcons.triangleUp, PanelIcons.triangleDown };

	public CollapsedBean() {
		icon0 = icons0[0].name();
		icon1 = icons1[0].name();
	}

	public void doToggled(PanelToggleEvent event) {
		org.richfaces.component.UICollapsiblePanel panel = (org.richfaces.component.UICollapsiblePanel) event.getSource();
		Object o = panel.getValue();
		status = icon0 + " " + icon1 + " " + o + " " + event.getExpanded();
	}

	public String getIcon0() {
		return icon0;
	}

	public String getIcon1() {
		return icon1;
	}

	public PanelIcons[] getIcons0() {
		return icons0;
	}

	public PanelIcons[] getIcons1() {
		return icons1;
	}

	public String getStatus() {
		return status;
	}

	public void setIcon0(String icon0) {
		this.icon0 = icon0;
	}

	public void setIcon1(String icon1) {
		this.icon1 = icon1;
	}

	public void setIcons0(PanelIcons[] icons0) {
		this.icons0 = icons0;
	}

	public void setIcons1(PanelIcons[] icons1) {
		this.icons1 = icons1;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

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

	private PanelIcons[] icons0 = { PanelIcons.none, PanelIcons.chevron, PanelIcons.disc, PanelIcons.grid, PanelIcons.triangle, PanelIcons.transparent };
	private PanelIcons[] icons1 = { PanelIcons.chevronLeft, PanelIcons.chevronUp, PanelIcons.chevronDown, PanelIcons.triangleLeft, PanelIcons.triangleUp,
			PanelIcons.triangleDown };

	public void doToggled(PanelToggleEvent event) {
		event.getSource();
		if (event.getExpanded()) {
			status = icon0 + " " + icon1;
		}
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIcon0() {
		return icon0;
	}

	public void setIcon0(String icon0) {
		this.icon0 = icon0;
	}

	public String getIcon1() {
		return icon1;
	}

	public void setIcon1(String icon1) {
		this.icon1 = icon1;
	}

	public PanelIcons[] getIcons0() {
		return icons0;
	}

	public void setIcons0(PanelIcons[] icons0) {
		this.icons0 = icons0;
	}

	public PanelIcons[] getIcons1() {
		return icons1;
	}

	public void setIcons1(PanelIcons[] icons1) {
		this.icons1 = icons1;
	}
}

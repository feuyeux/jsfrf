/**
 * 
 */
package creative.fire.jsfrf.rf.output;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.richfaces.event.ItemChangeEvent;

/**
 * @author Administrator
 * 
 */
@ManagedBean
@ViewScoped
public class TabBean {
	private String status;

	public void doItemChanging(ItemChangeEvent event) {
		this.status = event.getNewItemName();
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

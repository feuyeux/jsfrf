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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void doItemChanging(ItemChangeEvent event) {
		status = event.getNewItemName();
	}
}

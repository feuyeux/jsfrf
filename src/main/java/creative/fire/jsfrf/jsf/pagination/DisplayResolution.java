package creative.fire.jsfrf.jsf.pagination;

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean(name = "displayResolution")
@SessionScoped
public class DisplayResolution implements Serializable {
	private static final long serialVersionUID = -4509764560269011152L;
	private int pageSize;
	private Logger logger;

	public DisplayResolution() {
		logger = Logger.getLogger(DisplayResolution.class);
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		logger.info("当前分页尺度：" + pageSize);
	}

	public static DisplayResolution getInstance() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		return (DisplayResolution) sessionMap.get("displayResolution");
	}
}

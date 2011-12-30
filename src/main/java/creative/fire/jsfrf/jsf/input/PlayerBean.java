package creative.fire.jsfrf.jsf.input;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean
@RequestScoped
public class PlayerBean {
	private ArrayList<Player> sList = new ArrayList<Player>();
	private ArrayList<Player> tList = new ArrayList<Player>();
	private int pageIndex;
	private int pageSize;

	@PostConstruct
	public void init() {
		pageIndex = 1;
		pageSize = 10;
		PlayerCache cache = PlayerCache.getInstance();
		if (cache != null) {
			ArrayList<Player> sList = cache.getsList();
			ArrayList<Player> tList = cache.gettList();
			setsList(sList);
			settList(tList);
		}
	}

	public ArrayList<Player> getsList() {
		return sList;
	}

	public void setsList(ArrayList<Player> sList) {
		this.sList = sList;
	}

	public ArrayList<Player> gettList() {
		return tList;
	}

	public void settList(ArrayList<Player> tList) {
		this.tList = tList;
	}

	public String store() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PlayerCache cache = (PlayerCache) sessionMap.get("playerCache");
		if (cache != null) {
			cache.setsList(getsList());
			cache.settList(gettList());
		}
		return "/welcome.jsf";
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}

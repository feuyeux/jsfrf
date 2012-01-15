package creative.fire.jsfrf.jsf.input;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
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

		if (cache == null) {
			FacesContext context = FacesContext.getCurrentInstance();
			ELContext elContext = context.getELContext();

			Application application = FacesContext.getCurrentInstance().getApplication();
			ExpressionFactory expressionFactory = application.getExpressionFactory();
			ValueExpression ve = expressionFactory.createValueExpression(elContext, "#{playerCache}", PlayerCache.class);
			cache = (PlayerCache) ve.getValue(elContext);
		}

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

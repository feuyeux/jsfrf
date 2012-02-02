package creative.fire.jsfrf.jsf.pagination;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import creative.fire.jsfrf.jsf.input.Yijing;
import creative.fire.jsfrf.jsf.input.YijingCollection;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean(name = "onePagination")
@ViewScoped
public class OnePagination extends BasePagination implements java.io.Serializable {
	private static final long serialVersionUID = -1494058711078739172L;
	static Logger log = Logger.getLogger(OnePagination.class);
	private ArrayList<Yijing> list;
	private ArrayList<Yijing> showList;

	public OnePagination() {
		log.debug("构造");
	}

	@Override
	@PostConstruct
	public void init() {
		super.init();
		initializeList();
	}

	private void initializeList() {
		list = YijingCollection.getYijings();
		showList = new ArrayList<Yijing>();

		totalSize = list.size();
		freshList();
	}

	public ArrayList<Yijing> getShowList() {
		return showList;
	}

	@Override
	protected void freshList() {
		try {
			int from = (getPageIndex() - 1) * getPageSize();
			int to = getPageIndex() * getPageSize();

			if (to > totalSize) {
				to = totalSize;
			}
			showList.clear();
			for (int i = from; i < to; i++) {
				showList.add(list.get(i));
			}
			fillItems();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
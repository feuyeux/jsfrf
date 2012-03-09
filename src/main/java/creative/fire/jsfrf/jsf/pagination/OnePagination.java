package creative.fire.jsfrf.jsf.pagination;

import java.util.ArrayList;
import java.util.Comparator;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.richfaces.component.SortOrder;

import creative.fire.jsfrf.global.JSFRFFaces;
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
	private SortOrder sequenceOrder = SortOrder.unsorted;

	public OnePagination() {
		OnePagination.log.debug("构造");
	}

	public ArrayList<Yijing> autocomplete(String prefix) {
		ArrayList<Yijing> result = new ArrayList<Yijing>();
		for (Yijing suggestYi : this.list) {
			if (suggestYi.getSequence().startsWith(prefix)) {
				result.add(suggestYi);
			}
		}
		return result;
	}
	public void flipover() {
		try {
			String requestIndex = JSFRFFaces.getRequestParameterMap().get("pageIndex");
			if (requestIndex != null)
				pageIndex = Integer.valueOf(requestIndex);
			
			int from = (getPageIndex() - 1) * getPageSize();
			int to = getPageIndex() * getPageSize();

			if (to > this.totalSize) {
				to = this.totalSize;
			}
			this.showList.clear();
			for (int i = from; i < to; i++) {
				this.showList.add(this.list.get(i));
			}
			filpBar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Yijing> getList() {
		return this.list;
	}

	public Comparator<Yijing> getSequenceComparator() {
		return new Comparator<Yijing>() {
			@Override
			public int compare(Yijing y1, Yijing y2) {
				int v1 = Integer.valueOf(y1.getSequence().trim());
				int v2 = Integer.valueOf(y2.getSequence().trim());
				if (v1 == v2) {
					return 0;
				}
				if (v1 > v2) {
					return -1;
				} else {
					return 1;
				}
			}
		};
	}

	public SortOrder getSequenceOrder() {
		return this.sequenceOrder;
	}

	public ArrayList<Yijing> getShowList() {
		return this.showList;
	}

	@Override
	@PostConstruct
	public void init() {
		OnePagination.log.debug("init");
		super.init();
		initializeList();
	}

	private void initializeList() {
		this.list = YijingCollection.getYijings();
		this.showList = new ArrayList<Yijing>();
		this.totalSize = this.list.size();
		flipover();
	}

	public void setSequenceOrder(SortOrder sequenceOrder) {
		this.sequenceOrder = sequenceOrder;
	}

	public void sortBySequence() {
		if (this.sequenceOrder.equals(SortOrder.ascending)) {
			setSequenceOrder(SortOrder.descending);
		} else {
			setSequenceOrder(SortOrder.ascending);
		}
	}
}
package creative.fire.jsfrf.jsf.pagination;

import java.util.ArrayList;
import java.util.Comparator;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.richfaces.component.SortOrder;

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
		log.debug("构造");
	}

	@Override
	@PostConstruct
	public void init() {
		log.debug("init");
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

	public ArrayList<Yijing> getList() {
		return list;
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

	public ArrayList<Yijing> autocomplete(String prefix) {
		ArrayList<Yijing> result = new ArrayList<Yijing>();
		for (Yijing suggestYi : list) {
			if (suggestYi.getSequence().startsWith(prefix)) {
				result.add(suggestYi);
			}
		}
		return result;
	}

	public SortOrder getSequenceOrder() {
		return sequenceOrder;
	}

	public void setSequenceOrder(SortOrder sequenceOrder) {
		this.sequenceOrder = sequenceOrder;
	}

	public void sortBySequence() {
		if (sequenceOrder.equals(SortOrder.ascending)) {
			setSequenceOrder(SortOrder.descending);
		} else {
			setSequenceOrder(SortOrder.ascending);
		}
	}

	public Comparator<Yijing> getSequenceComparator() {
		return new Comparator<Yijing>() {
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
}
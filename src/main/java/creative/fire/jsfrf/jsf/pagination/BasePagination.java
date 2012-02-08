package creative.fire.jsfrf.jsf.pagination;

import java.util.ArrayList;

import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
public abstract class BasePagination implements IPagination {
	static Logger log = Logger.getLogger(BasePagination.class);
	protected int pageIndex = 1;// 当前页号
	protected int pageSize;// 每页显示多少项
	protected int pageCount;// 共有多少页
	protected int totalSize;// 共有多少项

	protected boolean disabledFirst;
	protected boolean disabledLast;

	protected ArrayList<SelectItem> pageNumbers;

	@ManagedProperty(value = "#{displayResolution}")
	protected DisplayResolution displayResolution;

	public BasePagination() {
		log.debug("构造");
	}

	public void init() {
		if (displayResolution == null) {
			pageSize = 20;
		} else {
			pageSize = displayResolution.getPageSize();
			if (pageSize == 0) {
				pageSize = 20;
			}
		}
	}

	protected abstract void freshList();

	protected void fillItems() {
		if (pageNumbers == null) {
			pageNumbers = new ArrayList<SelectItem>();
		} else {
			pageNumbers.clear();
		}

		if (getTotalSize() == 0) {
			pageNumbers.add(new SelectItem(1 + "", 1 + ""));
		} else {
			for (int i = 1; i <= getPageCount(); i++) {
				String pageNumber = "" + i;
				pageNumbers.add(new SelectItem(pageNumber, pageNumber));
			}
		}
	}

	public DisplayResolution getDisplayResolution() {
		return displayResolution;
	}

	public void setDisplayResolution(DisplayResolution displayResolution) {
		this.displayResolution = displayResolution;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public int getPageCount() {
		int mod = getTotalSize() % pageSize;
		pageCount = getTotalSize() / pageSize;
		if (mod > 0) {
			pageCount++;
		}

		if (pageCount == 0) {
			pageCount = 1;
		}
		return pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public ArrayList<SelectItem> getPageNumbers() {
		fillItems();
		return pageNumbers;
	}

	public void setPageNumbers(ArrayList<SelectItem> pageNumbers) {
		this.pageNumbers = pageNumbers;
	}

	public boolean isDisabledFirst() {
		disabledFirst = getPageIndex() == 1;
		return disabledFirst;
	}

	public boolean isDisabledLast() {
		disabledLast = getPageIndex() == getPageCount();
		return disabledLast;
	}

	public void swichPage() {
		freshList();
	}

	public void swichFirstPage() {
		setPageIndex(1);
		freshList();
	}

	public void swichPreviousPage() {
		int index = getPageIndex();
		setPageIndex(--index);
		freshList();
	}

	public void swichNextPage() {
		int index = getPageIndex();
		setPageIndex(++index);
		freshList();
	}

	public void swichLastPage() {
		setPageIndex(getPageCount());
		freshList();
	}
}

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
	transient static Logger log = Logger.getLogger(BasePagination.class);
	protected int pageIndex = 1;// 当前页号
	protected int pageSize;// 每页显示多少项
	protected int pageCount;// 共有多少页
	protected int totalSize;// 共有多少项

	private final int left = 4;
	private final int right = 5;
	private final int pagePageSize = 10;

	protected boolean disabledFirst;
	protected boolean disabledLast;

	protected ArrayList<Integer> pageNumbers = new ArrayList<Integer>();
	protected ArrayList<SelectItem> pageNumberItems;

	@ManagedProperty(value = "#{displayResolution}")
	protected DisplayResolution displayResolution;

	public BasePagination() {
		BasePagination.log.debug("构造");
	}

	protected void filpBar() {
		flipBar1();
		flipBar2();
	}

	protected void flipBar1() {
		if (this.pageNumberItems == null) {
			this.pageNumberItems = new ArrayList<SelectItem>();
		} else {
			this.pageNumberItems.clear();
		}

		if (getTotalSize() == 0) {
			this.pageNumberItems.add(new SelectItem(1 + "", 1 + ""));
		} else {
			for (int i = 1; i <= getPageCount(); i++) {
				String pageNumber = "" + i;
				this.pageNumberItems.add(new SelectItem(pageNumber, pageNumber));
			}
		}
	}

	protected void flipBar2() {
		if (totalSize == 0) {
			this.pageIndex = 1;
			this.totalSize = 1;
			this.pageNumbers.clear();
			return;
		}

		int mod = this.pageIndex % pagePageSize;
		int pagePageIndex;
		if (mod > 0)
			pagePageIndex = this.pageIndex / pagePageSize + 1;
		else
			pagePageIndex = this.pageIndex / pagePageSize;

		int pageStart = this.pageIndex - left;
		int pageEnd = this.pageIndex + right;

		if (pageStart < 1) {
			pageStart = 1;
		}

		if (pageEnd > getPageCount()) {
			pageEnd = getPageCount();
		} else if (pageEnd < pagePageSize && getPageCount() >= pagePageSize) {
			pageEnd = pagePageSize;
		}

		if (pageEnd > totalSize) {
			int revisedPageIndex = (pagePageIndex - 1) * pagePageSize + 1;
			pageStart = revisedPageIndex;
			pageEnd = totalSize;
		}

		this.pageNumbers.clear();
		if (pageEnd > 1)
			for (int i = pageStart; i <= pageEnd; i++) {
				this.pageNumbers.add(i);
			}
	}

	public DisplayResolution getDisplayResolution() {
		return this.displayResolution;
	}

	@Override
	public int getPageCount() {
		int mod = getTotalSize() % this.pageSize;
		this.pageCount = getTotalSize() / this.pageSize;
		if (mod > 0) {
			this.pageCount++;
		}

		if (this.pageCount < 1) {
			this.pageCount = 1;
		}
		return this.pageCount;
	}

	@Override
	public int getPageIndex() {
		return this.pageIndex;
	}

	@Override
	public int getPageSize() {
		return this.pageSize;
	}

	@Override
	public int getTotalSize() {
		return this.totalSize;
	}

	public void init() {
		if (this.displayResolution == null) {
			this.pageSize = 20;
		} else {
			this.pageSize = this.displayResolution.getPageSize();
			if (this.pageSize == 0) {
				this.pageSize = 20;
			}
		}
	}

	@Override
	public boolean isDisabledFirst() {
		this.disabledFirst = getPageIndex() == 1;
		return this.disabledFirst;
	}

	@Override
	public boolean isDisabledLast() {
		this.disabledLast = getPageIndex() == getPageCount();
		return this.disabledLast;
	}

	public ArrayList<Integer> getPageNumbers() {
		return pageNumbers;
	}

	public void setPageNumbers(ArrayList<Integer> pageNumbers) {
		this.pageNumbers = pageNumbers;
	}

	public ArrayList<SelectItem> getPageNumberItems() {
		return pageNumberItems;
	}

	public void setPageNumberItems(ArrayList<SelectItem> pageNumberItems) {
		this.pageNumberItems = pageNumberItems;
	}

	public void setDisplayResolution(DisplayResolution displayResolution) {
		this.displayResolution = displayResolution;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	@Override
	public void first() {
		setPageIndex(1);
		flipover();
	}

	@Override
	public void last() {
		setPageIndex(getPageCount());
		flipover();
	}

	@Override
	public void next() {
		pageIndex++;
		if (pageIndex > totalSize) {
			pageIndex = totalSize;
			return;
		}
		flipover();
	}

	@Override
	public void previous() {
		pageIndex--;
		if (pageIndex < 1) {
			pageIndex = 1;
			return;
		}
		flipover();
	}
}

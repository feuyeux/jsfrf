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
		BasePagination.log.debug("构造");
	}

	protected void fillItems() {
		if (this.pageNumbers == null) {
			this.pageNumbers = new ArrayList<SelectItem>();
		} else {
			this.pageNumbers.clear();
		}

		if (getTotalSize() == 0) {
			this.pageNumbers.add(new SelectItem(1 + "", 1 + ""));
		} else {
			for (int i = 1; i <= getPageCount(); i++) {
				String pageNumber = "" + i;
				this.pageNumbers.add(new SelectItem(pageNumber, pageNumber));
			}
		}
	}

	protected abstract void freshList();

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

		if (this.pageCount == 0) {
			this.pageCount = 1;
		}
		return this.pageCount;
	}

	@Override
	public int getPageIndex() {
		return this.pageIndex;
	}

	public ArrayList<SelectItem> getPageNumbers() {
		fillItems();
		return this.pageNumbers;
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

	public void setDisplayResolution(DisplayResolution displayResolution) {
		this.displayResolution = displayResolution;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public void setPageNumbers(ArrayList<SelectItem> pageNumbers) {
		this.pageNumbers = pageNumbers;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	@Override
	public void swichFirstPage() {
		setPageIndex(1);
		freshList();
	}

	@Override
	public void swichLastPage() {
		setPageIndex(getPageCount());
		freshList();
	}

	@Override
	public void swichNextPage() {
		int index = getPageIndex();
		setPageIndex(++index);
		freshList();
	}

	@Override
	public void swichPage() {
		freshList();
	}

	@Override
	public void swichPreviousPage() {
		int index = getPageIndex();
		setPageIndex(--index);
		freshList();
	}
}

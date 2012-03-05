package creative.fire.jsfrf.jsf.pagination;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
public interface IPagination {
	int getPageCount();

	int getPageIndex();

	int getPageSize();

	int getTotalSize();

	boolean isDisabledFirst();

	boolean isDisabledLast();

	void swichFirstPage();

	void swichLastPage();

	void swichNextPage();

	void swichPage();

	void swichPreviousPage();
}
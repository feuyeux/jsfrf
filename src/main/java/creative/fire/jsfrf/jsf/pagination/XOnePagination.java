package creative.fire.jsfrf.jsf.pagination;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.apache.log4j.Logger;
import org.richfaces.component.UIExtendedDataTable;

import creative.fire.jsfrf.jsf.input.Yijing;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean(name = "xonePagination")
@ViewScoped
public class XOnePagination extends OnePagination {
	private static final long serialVersionUID = 7267082702736662317L;
	static Logger log = Logger.getLogger(XOnePagination.class);
	private Collection<Object> selection;
	private ArrayList<Yijing> selectedList;

	public XOnePagination() {
		selectedList = new ArrayList<Yijing>();
	}

	@Override
	@PostConstruct
	public void init() {
		super.init();
	}

	public ArrayList<Yijing> getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(ArrayList<Yijing> selectedList) {
		this.selectedList = selectedList;
	}

	public void setSelection(Collection<Object> selection) {
		this.selection = selection;
	}

	public Collection<Object> getSelection() {
		return selection;
	}
	
	public void showSelections(AjaxBehaviorEvent event) {
		UIExtendedDataTable table = (UIExtendedDataTable) event.getComponent();
		Object storedRowKey = table.getRowKey();
		selectedList.clear();
		for (Object rowKey : selection) {
			table.setRowKey(rowKey);
			selectedList.add((Yijing) table.getRowData());
		}
		table.setRowKey(storedRowKey);
	}
}
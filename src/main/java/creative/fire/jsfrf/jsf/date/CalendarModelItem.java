package creative.fire.jsfrf.jsf.date;

import org.richfaces.model.CalendarDataModelItem;

public class CalendarModelItem implements CalendarDataModelItem {
	private boolean enabled;
	private String styleClass;

	@Override
	public Object getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDay() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getStyleClass() {
		return styleClass;
	}

	@Override
	public Object getToolTip() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasToolTip() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

}

package creative.fire.jsfrf.jsf.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.richfaces.model.CalendarDataModel;
import org.richfaces.model.CalendarDataModelItem;

@ManagedBean(name = "cModel")
@ApplicationScoped
public class CalendarModel implements CalendarDataModel {
	private static final String SPECIAL = "special";
	Calendar today = GregorianCalendar.getInstance();

	public CalendarModel() {
		this.today.setTime(new Date());
	}

	@Override
	public CalendarDataModelItem[] getData(Date[] dateArray) {
		CalendarDataModelItem[] modelItems = new CalendarModelItem[dateArray.length];
		Calendar current = Calendar.getInstance();

		for (int i = 0; i < dateArray.length; i++) {
			current.setTime(dateArray[i]);
			CalendarModelItem modelItem = new CalendarModelItem();
			if (isSpecialDay(current)) {
				modelItem.setEnabled(false);
				modelItem.setStyleClass(CalendarModel.SPECIAL);
			} else {
				modelItem.setEnabled(true);
			}
			modelItems[i] = modelItem;
		}

		return modelItems;
	}

	@Override
	public Object getToolTip(Date date) {
		return date.before(this.today.getTime());
	}

	private boolean isSpecialDay(Calendar calendar) {
		return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
				|| calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
	}
}
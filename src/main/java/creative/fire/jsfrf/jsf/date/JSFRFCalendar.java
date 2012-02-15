package creative.fire.jsfrf.jsf.date;

import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean(name = "calendarBean")
@RequestScoped
public class JSFRFCalendar {
	private Date datetime;
	private String pattern = "dd/M/yy HH:mm:ss";
	private String locale = "zh";
	private boolean disabled;
	private Date start;
	private Date end;

	public JSFRFCalendar() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		end = cal.getTime();
		cal.set(Calendar.YEAR, 2011);
		start = cal.getTime();
	}

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

}

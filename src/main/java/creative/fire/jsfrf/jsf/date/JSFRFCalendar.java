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
	private String pattern = "yyyy-MM-dd HH:mm:ss";
	private String locale = "zh";
	private boolean disabled;
	private Date start;
	private Date end;

	public JSFRFCalendar() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		this.end = cal.getTime();
		cal.set(Calendar.YEAR, 2011);
		this.start = cal.getTime();
	}

	public Date getDatetime() {
		return this.datetime;
	}

	public Date getEnd() {
		return this.end;
	}

	public String getLocale() {
		return this.locale;
	}

	public String getPattern() {
		return this.pattern;
	}

	public Date getStart() {
		return this.start;
	}

	public boolean isDisabled() {
		return this.disabled;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}

package creative.fire.jsfrf.jsf.date;

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

	
	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

}

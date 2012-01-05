package creative.fire.jsfrf.jsf.jsr303;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Past;

public class SubTextBean {

	@Past
	private Date birthDate;
	@Future
	private Date nextRainy;

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getNextRainy() {
		return nextRainy;
	}

	public void setNextRainy(Date nextRainy) {
		this.nextRainy = nextRainy;
	}

}

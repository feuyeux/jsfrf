package creative.fire.jsfrf.jsf.jsr303;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
public class TextBean {
	@NotNull
	@Size(min = 10, max = 10, message = "请输入10位有效字符")
	private String identification;

	@Max(11)
	@Min(11)
	private String mobilePhone;

	@NotEmpty
	private String country;

	@Email
	private String email;

	@NotNull
	@Season
	private String season;

	@Valid
	private SubTextBean subTextBean;

	public String getCountry() {
		return this.country;
	}

	public String getEmail() {
		return this.email;
	}

	public String getIdentification() {
		return this.identification;
	}

	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public String getSeason() {
		return this.season;
	}

	public SubTextBean getSubTextBean() {
		return this.subTextBean;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public void setSubTextBean(SubTextBean subTextBean) {
		this.subTextBean = subTextBean;
	}

}

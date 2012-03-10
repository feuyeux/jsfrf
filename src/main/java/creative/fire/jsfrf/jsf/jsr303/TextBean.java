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
	@Size(min = 11, max = 11, message = "请输入11位有效字符")
	private String mobilePhone;

	@Max(150)
	@Min(0)
	private int age;

	@NotEmpty
	private String country;

	@Email
	private String email;

	@NotNull
	@Season
	private String season;

	@Valid
	private SubTextBean subTextBean;

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public SubTextBean getSubTextBean() {
		return subTextBean;
	}

	public void setSubTextBean(SubTextBean subTextBean) {
		this.subTextBean = subTextBean;
	}
}

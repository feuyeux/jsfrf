package creative.fire.jsfrf.jsf.jsr303;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
public class TextGroupBean {
	@NotNull
	@Size(min = 11, max = 11, message = "请输入11位有效字符", groups = JSR303Group1.class)
	private String mobilePhone;
	@Range(min = 1, max = 150, groups = JSR303Group2.class)
	private int age;

	@NotEmpty(groups = JSR303Group1.class)
	private String country;

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
}

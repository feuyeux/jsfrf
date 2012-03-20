package creative.fire.jsfrf.jsf.jsr303;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.AssertTrue;
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
@ManagedBean(name = "gvBean")
@ViewScoped
public class GraphValidateBean implements java.lang.Cloneable {
	@NotNull
	@Size(min = 2, max = 2, message = "请输入2位有效字符")
	private String identification;

	@Size(min = 6, max = 10)
	private String password;

	@Size(min = 6, max = 10)
	private String repassword;

	@Max(11)
	@Min(11)
	private String mobilePhone;

	@NotEmpty
	private String country;

	@Email
	private String email;

	public GraphValidateBean() {

	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public String getCountry() {
		return country;
	}

	public String getEmail() {
		return email;
	}

	public String getIdentification() {
		return identification;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getPassword() {
		return password;
	}

	public String getRepassword() {
		return repassword;
	}

	@AssertTrue(message = "两次输入不同 请重新输入")
	public boolean isTextEqual() {
		return password.equals(repassword);
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

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
}

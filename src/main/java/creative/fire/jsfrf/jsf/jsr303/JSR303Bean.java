package creative.fire.jsfrf.jsf.jsr303;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean(name = "jsr303")
@ViewScoped
public class JSR303Bean {
	private TextBean input;

	public TextBean getInput() {
		return this.input;
	}

	@PostConstruct
	public void init() {
		Date date = new Date();
		SubTextBean sub = new SubTextBean();
		sub.setBirthDate(date);
		sub.setNextRainy(date);

		this.input = new TextBean();
		this.input.setSubTextBean(sub);
	}

	public void setInput(TextBean input) {
		this.input = input;
	}
}

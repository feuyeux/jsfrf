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
	private TextGroupBean input2;

	@PostConstruct
	public void init() {
		Date date = new Date();
		SubTextBean sub = new SubTextBean();
		sub.setBirthDate(date);
		sub.setNextRainy(date);

		this.input = new TextBean();
		this.input.setSubTextBean(sub);

		input2 = new TextGroupBean();
	}

	public TextBean getInput() {
		return this.input;
	}

	public void setInput(TextBean input) {
		this.input = input;
	}

	public TextGroupBean getInput2() {
		return input2;
	}

	public void setInput2(TextGroupBean input2) {
		this.input2 = input2;
	}
}

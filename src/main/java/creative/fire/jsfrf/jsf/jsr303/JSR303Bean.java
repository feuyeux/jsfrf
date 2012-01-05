package creative.fire.jsfrf.jsf.jsr303;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "jsr303")
@ViewScoped
public class JSR303Bean {
	private TextBean input;

	@PostConstruct
	public void init() {
		Date date = new Date();
		SubTextBean sub = new SubTextBean();
		sub.setBirthDate(date);
		sub.setNextRainy(date);

		input = new TextBean();
		input.setSubTextBean(sub);
	}

	public TextBean getInput() {
		return input;
	}

	public void setInput(TextBean input) {
		this.input = input;
	}
}

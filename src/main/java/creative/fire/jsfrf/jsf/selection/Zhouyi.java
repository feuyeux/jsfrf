package creative.fire.jsfrf.jsf.selection;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import creative.fire.jsfrf.jsf.input.Yijing;
import creative.fire.jsfrf.jsf.input.YijingCollection;

@ManagedBean
@RequestScoped
public class Zhouyi {
	private ArrayList<Yijing> sourcelist;
	private ArrayList<Yijing> targetlist;

	public ArrayList<Yijing> getSourcelist() {
		return this.sourcelist;
	}

	public ArrayList<Yijing> getTargetlist() {
		return this.targetlist;
	}

	@PostConstruct
	public void postConstruct() {
		this.sourcelist = YijingCollection.getYijings();

		this.targetlist = new ArrayList<Yijing>();
		this.targetlist.add(this.sourcelist.get(0));
		this.targetlist.add(this.sourcelist.get(1));
	}

	public void setSourcelist(ArrayList<Yijing> sourcelist) {
		this.sourcelist = sourcelist;
	}

	public void setTargetlist(ArrayList<Yijing> targetlist) {
		this.targetlist = targetlist;
	}
}

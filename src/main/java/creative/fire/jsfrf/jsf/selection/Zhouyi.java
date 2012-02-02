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

	@PostConstruct
	public void postConstruct(){
		sourcelist=YijingCollection.getYijings();

		targetlist=new ArrayList<Yijing>();
		targetlist.add(sourcelist.get(0));
		targetlist.add(sourcelist.get(1));
	}

	public ArrayList<Yijing> getSourcelist() {
		return sourcelist;
	}
	public void setSourcelist(ArrayList<Yijing> sourcelist) {
		this.sourcelist = sourcelist;
	}
	public ArrayList<Yijing> getTargetlist() {
		return targetlist;
	}
	public void setTargetlist(ArrayList<Yijing> targetlist) {
		this.targetlist = targetlist;
	}


}

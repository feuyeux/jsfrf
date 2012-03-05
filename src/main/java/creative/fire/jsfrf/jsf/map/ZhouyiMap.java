package creative.fire.jsfrf.jsf.map;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import creative.fire.jsfrf.jsf.input.Yijing;
import creative.fire.jsfrf.jsf.input.YijingMap;

@ManagedBean
@RequestScoped
public class ZhouyiMap {

	private HashMap<String, Yijing> map;

	public HashMap<String, Yijing> getMap() {
		return this.map;
	}

	@PostConstruct
	public void postConstruct() {
		this.map = YijingMap.getYijings();
	}

	public void setMap(HashMap<String, Yijing> map) {
		this.map = map;
	}

}

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

	@PostConstruct
	public void postConstruct() {
		map = YijingMap.getYijings();
	}

	public HashMap<String, Yijing> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Yijing> map) {
		this.map = map;
	}

}

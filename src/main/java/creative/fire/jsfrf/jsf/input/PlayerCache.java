package creative.fire.jsfrf.jsf.input;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean
@ViewScoped
public class PlayerCache {
	public static PlayerCache getInstance() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PlayerCache instance = (PlayerCache) sessionMap.get("playerCache");
		if (instance == null) {
			instance = new PlayerCache();
			sessionMap.put("playerCache", instance);
		}
		return instance;
	}

	private ArrayList<Player> sList = new ArrayList<Player>();

	private ArrayList<Player> tList = new ArrayList<Player>();

	public PlayerCache() {
		sList = new ArrayList<Player>();
		// http://www.acmilan.com/en/teams/roster 2011.12.17
		sList.add(new Player("32", "ABBIATI", "GOALKEEPERS"));
		sList.add(new Player("1", "AMELIA", "GOALKEEPERS"));
		sList.add(new Player("30", "ROMA", "GOALKEEPERS"));

		sList.add(new Player("2", "TAIWO", "DEFENDERS"));
		sList.add(new Player("5", "MEXES", "DEFENDERS"));
		sList.add(new Player("13", "NESTA", "DEFENDERS"));
		sList.add(new Player("19", "ZAMBROTTA", "DEFENDERS"));
		sList.add(new Player("20", "ABATE", "DEFENDERS"));
		sList.add(new Player("25", "BONERA", "DEFENDERS"));
		sList.add(new Player("52", "DE SCIGLIO", "DEFENDERS"));
		sList.add(new Player("76", "YEPES", "DEFENDERS"));
		sList.add(new Player("77", "ANTONINI", "DEFENDERS"));
		sList.add(new Player("33", "THIAGO SILVA", "DEFENDERS"));

		sList.add(new Player("4", "VAN BOMMEL", "MIDFIELDERS"));
		sList.add(new Player("8", "GATTUSO", "MIDFIELDERS"));
		sList.add(new Player("10", "SEEDORF", "MIDFIELDERS"));
		sList.add(new Player("16", "FLAMINI", "MIDFIELDERS"));
		sList.add(new Player("18", "AQUILANI", "MIDFIELDERS"));
		sList.add(new Player("22", "NOCERINO", "MIDFIELDERS"));
		sList.add(new Player("23", "AMBROSINI", "MIDFIELDERS"));
		sList.add(new Player("27", "BOATENG", "MIDFIELDERS"));
		sList.add(new Player("28", "EMANUELSON", "MIDFIELDERS"));
		sList.add(new Player("57", "VALOTI", "MIDFIELDERS"));

		sList.add(new Player("7", "PATO", "FORWARDS"));
		sList.add(new Player("9", "INZAGHI", "FORWARDS"));
		sList.add(new Player("11", "IBRAHIMOVIC", "FORWARDS"));
		sList.add(new Player("70", "ROBINHO", "FORWARDS"));
		sList.add(new Player("92", "EL SHAARAWY", "FORWARDS"));
		sList.add(new Player("99", "CASSANO", "FORWARDS"));
	}

	public ArrayList<Player> getsList() {
		return sList;
	}

	public ArrayList<Player> gettList() {
		return tList;
	}

	public void setsList(ArrayList<Player> sList) {
		this.sList = sList;
	}

	public void settList(ArrayList<Player> tList) {
		this.tList = tList;
	}

}

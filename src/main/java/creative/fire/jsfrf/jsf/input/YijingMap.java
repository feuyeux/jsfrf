package creative.fire.jsfrf.jsf.input;

import java.util.HashMap;

public class YijingMap {
	private static HashMap<String, Yijing> map;

	public static synchronized HashMap<String, Yijing> getYijings() {
		if (YijingMap.map != null) {
			return YijingMap.map;
		}
		YijingMap.map = new HashMap<String, Yijing>();
		YijingMap.map.put("乾", new Yijing("1", "乾", "qián"));
		YijingMap.map.put("坤", new Yijing("2", "坤", "kūn"));
		YijingMap.map.put("坎", new Yijing("29", "坎", "kǎn"));
		YijingMap.map.put("离", new Yijing("30", "离", "lí"));

		YijingMap.map.put("震", new Yijing("51", "震", "zhèn"));
		YijingMap.map.put("艮", new Yijing("52", "艮", "gèn"));

		YijingMap.map.put("巽", new Yijing("57", "巽", "xùn"));
		YijingMap.map.put("兑", new Yijing("58", "兑", "duì"));
		return YijingMap.map;
	}
}

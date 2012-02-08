package creative.fire.jsfrf.jsf.input;

import java.util.HashMap;

public class YijingMap {
	private static HashMap<String, Yijing> map;

	public static synchronized HashMap<String, Yijing> getYijings() {
		if (map != null) {
			return map;
		}
		map = new HashMap<String, Yijing>();
		map.put("乾", new Yijing("1", "乾", "qián"));
		map.put("坤", new Yijing("2", "坤", "kūn"));
		map.put("坎", new Yijing("29", "坎", "kǎn"));
		map.put("离", new Yijing("30", "离", "lí"));

		map.put("震", new Yijing("51", "震", "zhèn"));
		map.put("艮", new Yijing("52", "艮", "gèn"));

		map.put("巽", new Yijing("57", "巽", "xùn"));
		map.put("兑", new Yijing("58", "兑", "duì"));
		return map;
	}
}

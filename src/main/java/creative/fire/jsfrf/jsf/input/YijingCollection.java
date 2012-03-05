package creative.fire.jsfrf.jsf.input;

import java.util.ArrayList;

public class YijingCollection {
	private static ArrayList<Yijing> list;

	public static synchronized ArrayList<Yijing> getYijings() {
		if (YijingCollection.list != null) {
			return YijingCollection.list;
		}
		YijingCollection.list = new ArrayList<Yijing>();
		YijingCollection.list.add(new Yijing("1", "乾", "qián"));
		YijingCollection.list.add(new Yijing("2", "坤", "kūn"));
		YijingCollection.list.add(new Yijing("3", "屯", "zhūn"));
		YijingCollection.list.add(new Yijing("4", "蒙", "méng"));
		YijingCollection.list.add(new Yijing("5", "需", "xū"));

		YijingCollection.list.add(new Yijing("6", "讼", "sòng"));
		YijingCollection.list.add(new Yijing("7", "师", "shī"));
		YijingCollection.list.add(new Yijing("8", "比", "bì"));
		YijingCollection.list.add(new Yijing("9", "小畜", "xiao xù"));
		YijingCollection.list.add(new Yijing("10", "履", "lǚ"));

		YijingCollection.list.add(new Yijing("11", "泰", "tài"));
		YijingCollection.list.add(new Yijing("12", "否", "pǐ"));
		YijingCollection.list.add(new Yijing("13", "同人", "tóng rén"));
		YijingCollection.list.add(new Yijing("14", "大有", "dà yōu"));

		YijingCollection.list.add(new Yijing("15", "谦", "qiān"));
		YijingCollection.list.add(new Yijing("16", "豫", "yǜ"));
		YijingCollection.list.add(new Yijing("17", "随", "suí"));
		YijingCollection.list.add(new Yijing("18", "蛊", "gǔ"));
		YijingCollection.list.add(new Yijing("19", "临", "lín"));

		YijingCollection.list.add(new Yijing("20", "观", "guān"));
		YijingCollection.list.add(new Yijing("21", "噬嗑", "shì hé"));
		YijingCollection.list.add(new Yijing("22", "贲", "bì"));
		YijingCollection.list.add(new Yijing("23", "剥", "bō"));
		YijingCollection.list.add(new Yijing("24", "复", "fù"));

		YijingCollection.list.add(new Yijing("25", "无妄", "wú wàng"));
		YijingCollection.list.add(new Yijing("26", "大畜", "dà xù"));
		YijingCollection.list.add(new Yijing("27", "颐", "yí"));
		YijingCollection.list.add(new Yijing("28", "大过", "dà guò"));

		YijingCollection.list.add(new Yijing("29", "坎", "kǎn"));
		YijingCollection.list.add(new Yijing("30", "离", "lí"));
		YijingCollection.list.add(new Yijing("31", "咸", "xián"));
		YijingCollection.list.add(new Yijing("32", "恒", "héng"));
		YijingCollection.list.add(new Yijing("33", "遁", "dùn"));

		YijingCollection.list.add(new Yijing("34", "大壮", "dà zhuàng"));
		YijingCollection.list.add(new Yijing("35", "晋", "jìn"));
		YijingCollection.list.add(new Yijing("36", "明夷", "míng yí"));
		YijingCollection.list.add(new Yijing("37", "家人", "jiā ren"));

		YijingCollection.list.add(new Yijing("38", "睽", "kuí"));
		YijingCollection.list.add(new Yijing("39", "蹇", "jiǎn"));
		YijingCollection.list.add(new Yijing("40", "解", "xiè"));
		YijingCollection.list.add(new Yijing("41", "损", "sǔn"));
		YijingCollection.list.add(new Yijing("42", "益", "yì"));

		YijingCollection.list.add(new Yijing("43", "夬", "guài"));
		YijingCollection.list.add(new Yijing("44", "姤", "gòu"));
		YijingCollection.list.add(new Yijing("45", "萃", "cuì"));
		YijingCollection.list.add(new Yijing("46", "升", "shēng"));
		YijingCollection.list.add(new Yijing("47", "困", "kùn"));

		YijingCollection.list.add(new Yijing("48", "井", "jǐng"));
		YijingCollection.list.add(new Yijing("49", "革", "gé"));
		YijingCollection.list.add(new Yijing("50", "鼎", "dǐng"));
		YijingCollection.list.add(new Yijing("51", "震", "zhèn"));
		YijingCollection.list.add(new Yijing("52", "艮", "gèn"));

		YijingCollection.list.add(new Yijing("53", "渐", "jiàn"));
		YijingCollection.list.add(new Yijing("54", "归妹", "guī mèi"));
		YijingCollection.list.add(new Yijing("55", "丰", "fēng"));
		YijingCollection.list.add(new Yijing("56", "旅", "lǚ"));

		YijingCollection.list.add(new Yijing("57", "巽", "xùn"));
		YijingCollection.list.add(new Yijing("58", "兑", "duì"));
		YijingCollection.list.add(new Yijing("59", "涣", "huàn"));
		YijingCollection.list.add(new Yijing("60", "节", "jié"));
		YijingCollection.list.add(new Yijing("61", "中孚", "zhōng fú"));

		YijingCollection.list.add(new Yijing("62", "小过", "xiǎo guò"));
		YijingCollection.list.add(new Yijing("63", "既济", "jì jì"));
		YijingCollection.list.add(new Yijing("64", "未济", "wèi jì"));

		return YijingCollection.list;
	}
}

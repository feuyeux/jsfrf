package creative.fire.jsfrf.jsf.pagination;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import creative.fire.jsfrf.jsf.input.Yijing;

@ManagedBean
@ViewScoped
public class OnePagination extends BasePagination implements java.io.Serializable {
	private static final long serialVersionUID = -1494058711078739172L;
	private ArrayList<Yijing> list;
	private ArrayList<Yijing> showList;

	public OnePagination() {
		super();
		initializeList();
	}

	private void initializeList() {
		list = new ArrayList<Yijing>();
		showList = new ArrayList<Yijing>();
		list.add(new Yijing("1", "乾", "qián"));
		list.add(new Yijing("2", "坤", "kūn"));
		list.add(new Yijing("3", "屯", "zhūn"));
		list.add(new Yijing("4", "蒙", "méng"));
		list.add(new Yijing("5", "需", "xū"));

		list.add(new Yijing("6", "讼", "sòng"));
		list.add(new Yijing("7", "师", "shī"));
		list.add(new Yijing("8", "比", "bì"));
		list.add(new Yijing("9", "小畜", "xiao xù"));
		list.add(new Yijing("10", "履", "lǚ"));

		list.add(new Yijing("11", "泰", "tài"));
		list.add(new Yijing("12", "否", "pǐ"));
		list.add(new Yijing("13", "同人", "tóng rén"));
		list.add(new Yijing("14", "大有", "dà yōu"));

		list.add(new Yijing("15", "谦", "qiān"));
		list.add(new Yijing("16", "豫", "yǜ"));
		list.add(new Yijing("17", "随", "suí"));
		list.add(new Yijing(" 18", "蛊", "gǔ"));
		list.add(new Yijing("19", "临", "lín"));

		list.add(new Yijing("20", "观", "guān"));
		list.add(new Yijing("21", "噬嗑", "shì hé"));
		list.add(new Yijing("22", "贲", "bì"));
		list.add(new Yijing("23", "剥", "bō"));
		list.add(new Yijing("24", "复", "fù"));

		list.add(new Yijing("25", "无妄", "wú wàng"));
		list.add(new Yijing("26", "大畜", "dà xù"));
		list.add(new Yijing("27", "颐", "yí"));
		list.add(new Yijing("28", "大过", "dà guò"));

		list.add(new Yijing("29", "坎", "kǎn"));
		list.add(new Yijing("30", "离", "lí"));
		list.add(new Yijing("31", "咸", "xián"));
		list.add(new Yijing("32", "恒", "héng"));
		list.add(new Yijing("33", "遁", "dùn"));

		list.add(new Yijing("34", "大壮", "dà zhuàng"));
		list.add(new Yijing("35", "晋", "jìn"));
		list.add(new Yijing("36", "明夷", "míng yí"));
		list.add(new Yijing("37", "家人", "jiā ren"));

		list.add(new Yijing("38", "睽", "kuí"));
		list.add(new Yijing("39", "蹇", "jiǎn"));
		list.add(new Yijing("40", "解", "xiè"));
		list.add(new Yijing("41", "损", "sǔn"));
		list.add(new Yijing("42", "益", "yì"));

		list.add(new Yijing("43", "夬", "guài"));
		list.add(new Yijing("44", "姤", "gòu"));
		list.add(new Yijing("45", "萃", "cuì"));
		list.add(new Yijing("46", "升", "shēng"));
		list.add(new Yijing("47", "困", "kùn"));

		list.add(new Yijing("48", "井", "jǐng"));
		list.add(new Yijing("49", "革", "gé"));
		list.add(new Yijing("50", "鼎", "dǐng"));
		list.add(new Yijing("51", "震", "zhèn"));
		list.add(new Yijing("52", "艮", "gèn"));

		list.add(new Yijing("53", "渐", "jiàn"));
		list.add(new Yijing("54", "归妹", "guī mèi"));
		list.add(new Yijing("55", "丰", "fēng"));
		list.add(new Yijing("56", "旅", "lǚ"));

		list.add(new Yijing("57", "巽", "xùn"));
		list.add(new Yijing("58", "兑", "duì"));
		list.add(new Yijing("59", "涣", "huàn"));
		list.add(new Yijing("60", "节", "jié"));
		list.add(new Yijing("61", "中孚", "zhōng fú"));

		list.add(new Yijing("62", "小过", "xiǎo guò"));
		list.add(new Yijing("63", "既济", "jì jì"));
		list.add(new Yijing("64", "未济", "wèi jì"));
		totalSize = list.size();
		freshList();
	}

	@Override
	protected void freshList() {
		try {
			int from = (getPageIndex() - 1) * getPageSize();
			int to = getPageIndex() * getPageSize();

			if (to > totalSize)
				to = totalSize;
			showList.clear();
			for (int i = from; i < to; i++) {
				showList.add(list.get(i));
			}
			fillItems();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Yijing> getShowList() {
		return showList;
	}
}
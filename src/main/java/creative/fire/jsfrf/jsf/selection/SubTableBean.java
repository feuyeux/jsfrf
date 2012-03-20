package creative.fire.jsfrf.jsf.selection;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class SubTableBean {
	private ArrayList<Region> regions;

	public SubTableBean() {
		regions = new ArrayList<Region>();
		ArrayList<Province> ps = new ArrayList<Province>();

		ps.add(new Province("北京市", "京", "北京市"));
		ps.add(new Province("天津市", "津", "天津市"));
		ps.add(new Province("河北省", "冀", "石家庄"));
		ps.add(new Province("山西省", "晋", "太原"));
		ps.add(new Province("内蒙古自治区", "内蒙古", "呼和浩特"));
		regions.add(new Region("华北地区", ps));

		ps = new ArrayList<Province>();
		ps.add(new Province("辽宁省", "辽", "沈阳"));
		ps.add(new Province("吉林省", "吉", "长春"));
		ps.add(new Province("黑龙江省", "黑", "哈尔滨"));
		regions.add(new Region("东北地区", ps));

		ps = new ArrayList<Province>();
		ps.add(new Province("上海市", "沪", "上海市"));
		ps.add(new Province("江苏省", "苏", "南京"));
		ps.add(new Province("浙江省", "浙", "杭州"));
		ps.add(new Province("安徽省", "皖", "合肥"));
		ps.add(new Province("福建省", "闽", "福州"));
		ps.add(new Province("江西省", "赣", "南昌"));
		ps.add(new Province("山东省", "鲁", "济南"));
		regions.add(new Region("华东地区", ps));

		ps = new ArrayList<Province>();
		ps.add(new Province("河南省", "豫", "郑州"));
		ps.add(new Province("湖北省", "鄂", "武汉"));
		ps.add(new Province("湖南省", "湘", "长沙"));
		ps.add(new Province("广东省", "粤", "广州"));
		ps.add(new Province("广西壮族自治区", "桂", "南宁"));
		ps.add(new Province("海南省", "琼", "海口"));
		regions.add(new Region("中南地区", ps));

		ps = new ArrayList<Province>();
		ps.add(new Province("重庆市", "渝", "重庆市"));
		ps.add(new Province("四川省", "蜀", "成都"));
		ps.add(new Province("贵州省", "黔", "贵阳"));
		ps.add(new Province("云南省", "滇", "昆明"));
		ps.add(new Province("西藏自治区", "藏", "拉萨"));
		regions.add(new Region("西南地区", ps));

		ps = new ArrayList<Province>();
		ps.add(new Province("陕西省", "秦", "西安"));
		ps.add(new Province("甘肃省", "陇", "兰州"));
		ps.add(new Province("青海省", "青", "西宁"));
		ps.add(new Province("宁夏回族自治区", "宁", "银川"));
		ps.add(new Province("新疆维吾尔自治区", "新", "乌鲁木齐"));
		regions.add(new Region("西北地区", ps));

		ps = new ArrayList<Province>();
		ps.add(new Province("香港特别行政区", "港", "香港"));
		ps.add(new Province("澳门特别行政区", "澳", "澳门"));
		ps.add(new Province("台湾省", "台", "台北"));
		regions.add(new Region("港澳台地区", ps));
	}

	public ArrayList<Region> getRegions() {
		return regions;
	}

	public void setRegions(ArrayList<Region> regions) {
		this.regions = regions;
	}

}

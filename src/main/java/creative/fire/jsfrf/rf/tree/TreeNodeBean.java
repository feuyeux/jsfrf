package creative.fire.jsfrf.rf.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.richfaces.component.UITree;
import org.richfaces.event.TreeSelectionChangeEvent;
import org.richfaces.event.TreeToggleEvent;
import org.richfaces.model.TreeNode;

@ManagedBean
@ViewScoped
public class TreeNodeBean {
	static Logger logger = Logger.getLogger(TreeNodeBean.class);
	private JSFRFTreeNode rootNode = null;
	private List<String> selecting = new ArrayList<String>();
	private List<String> selection = new ArrayList<String>();
	private String toggledNodeData = null;

	public TreeNode getRootNode() {
		if (this.rootNode == null) {
			initNodes();
		}
		return this.rootNode;
	}

	public List<String> getSelecting() {
		return this.selecting;
	}

	public List<String> getSelection() {
		return this.selection;
	}

	public String getToggledNodeData() {
		return this.toggledNodeData;
	}

	@PostConstruct
	public void init() {
		TreeNodeBean.logger.info("1234567890-");
	}

	private void initNodes() {
		this.rootNode = new JSFRFTreeNode("中国");

		JSFRFTreeNode node = new JSFRFTreeNode("华北地区");
		node.addChild("京", new JSFRFTreeNode("北京市"));
		node.addChild("津", new JSFRFTreeNode("天津市"));
		node.addChild("冀", new JSFRFTreeNode("河北省"));
		node.addChild("晋", new JSFRFTreeNode("山西省"));
		node.addChild("内蒙古", new JSFRFTreeNode("内蒙古自治区"));
		this.rootNode.addChild("华北", node);

		node = new JSFRFTreeNode("东北地区");
		node.addChild("辽", new JSFRFTreeNode("辽宁省"));
		node.addChild("吉", new JSFRFTreeNode("吉林省"));
		node.addChild("黑", new JSFRFTreeNode("黑龙江省"));
		this.rootNode.addChild("东北", node);

		node = new JSFRFTreeNode("华东地区");
		node.addChild("沪", new JSFRFTreeNode("上海市"));
		node.addChild("苏", new JSFRFTreeNode("江苏省"));
		node.addChild("浙", new JSFRFTreeNode("浙江省"));
		node.addChild("皖", new JSFRFTreeNode("安徽省"));
		node.addChild("闽", new JSFRFTreeNode("福建省"));
		node.addChild("赣", new JSFRFTreeNode("江西省"));
		node.addChild("鲁", new JSFRFTreeNode("山东省"));
		this.rootNode.addChild("华东", node);

		node = new JSFRFTreeNode("中南地区");
		node.addChild("豫", new JSFRFTreeNode("河南省"));
		node.addChild("鄂", new JSFRFTreeNode("湖北省"));
		node.addChild("湘", new JSFRFTreeNode("湖南省"));
		node.addChild("粤", new JSFRFTreeNode("广东省"));
		node.addChild("桂", new JSFRFTreeNode("广西壮族自治区"));
		node.addChild("琼", new JSFRFTreeNode("海南省"));
		this.rootNode.addChild("中南", node);

		node = new JSFRFTreeNode("西南地区");
		node.addChild("渝", new JSFRFTreeNode("重庆市"));
		node.addChild("蜀", new JSFRFTreeNode("四川省"));
		node.addChild("黔", new JSFRFTreeNode("贵州省"));
		node.addChild("滇", new JSFRFTreeNode("云南省"));
		node.addChild("藏", new JSFRFTreeNode("西藏自治区"));
		this.rootNode.addChild("西南", node);

		node = new JSFRFTreeNode("西北地区");
		node.addChild("秦", new JSFRFTreeNode("陕西省"));
		node.addChild("陇", new JSFRFTreeNode("甘肃省"));
		node.addChild("青", new JSFRFTreeNode("青海省"));
		node.addChild("宁", new JSFRFTreeNode("宁夏回族自治区"));
		node.addChild("新", new JSFRFTreeNode("新疆维吾尔自治区"));
		this.rootNode.addChild("西北", node);

		node = new JSFRFTreeNode("港澳台地区");
		node.addChild("港", new JSFRFTreeNode("香港特别行政区"));
		node.addChild("澳", new JSFRFTreeNode("澳门特别行政区"));
		node.addChild("台", new JSFRFTreeNode("台湾省"));
		this.rootNode.addChild("港澳台", node);
	}

	public void nodeToggled(TreeToggleEvent event) {
		UITree uiTree = (UITree) event.getComponent();
		JSFRFTreeNode richfacesTreeNode = (JSFRFTreeNode) uiTree.getRowData();
		this.toggledNodeData = richfacesTreeNode.getData();

		if (event.isCollapsed()) {
			TreeNodeBean.logger.info("The tree:" + uiTree.getClientId() + " is collapsed.");
		} else if (event.isExpanded()) {
			TreeNodeBean.logger.info("The tree:" + uiTree.getClientId() + " is expanded.");
		}
	}

	public void selectionChanged(TreeSelectionChangeEvent event) {
		UITree uiTree = (UITree) event.getComponent();
		this.selecting.clear();
		Collection<?> nc = event.getNewSelection();
		for (Object rowKey : nc) {
			uiTree.setRowKey(rowKey);
			JSFRFTreeNode richfacesTreeNode = (JSFRFTreeNode) uiTree.getRowData();
			this.selecting.add(richfacesTreeNode.getData());
		}
	}

	public void selectionChanged0(TreeSelectionChangeEvent event) {
		selectionChanged(event);
	}

	public void setRootNode(JSFRFTreeNode rootNode) {
		this.rootNode = rootNode;
	}

	public void setSelecting(List<String> selecting) {
		this.selecting = selecting;
	}

	public void setSelection(List<String> selection) {
		this.selection = selection;
	}

	public void setToggledNodeData(String toggledNodeData) {
		this.toggledNodeData = toggledNodeData;
	}

}

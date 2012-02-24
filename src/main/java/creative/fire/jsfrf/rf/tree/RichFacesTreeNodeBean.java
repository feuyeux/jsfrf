package creative.fire.jsfrf.rf.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.richfaces.component.UITree;
import org.richfaces.event.TreeSelectionChangeEvent;
import org.richfaces.event.TreeToggleEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

@ManagedBean
@ViewScoped
public class RichFacesTreeNodeBean {
	static Logger logger = Logger.getLogger(RichFacesTreeNodeBean.class);
	private TreeNode rootNode = null;
	private List<String> selection = new ArrayList<String>();
	private String toggledNodeData = null;

	@PostConstruct
	public void init() {
		logger.info("1234567890-");
	}

	public void nodeToggled(TreeToggleEvent event) {
		UITree uiTree = (UITree) event.getComponent();
		RichFacesTreeNode richfacesTreeNode = (RichFacesTreeNode) uiTree.getRowData();
		toggledNodeData = richfacesTreeNode.getData();

		if (event.isCollapsed()) {
			logger.info("The tree:" + uiTree.getClientId() + " is collapsed.");
		}
		if (event.isExpanded()) {
			logger.info("The tree:" + uiTree.getClientId() + " is expanded.");
		}
	}

	public void selectionChanged(TreeSelectionChangeEvent event) {
		selection.clear();
		UITree uiTree = (UITree) event.getComponent();
		Object storedRowKey = uiTree.getRowKey();
		for (Object rowKey : event.getNewSelection()) {
			uiTree.setRowKey(rowKey);
			RichFacesTreeNode richfacesTreeNode = (RichFacesTreeNode) uiTree.getRowData();
			selection.add(richfacesTreeNode.getData());
		}
		uiTree.setRowKey(storedRowKey);
	}

	public void selecting() {
		final ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, String> params = externalContext.getRequestParameterMap();
		String chooseData = params.get("chooseData");
		logger.info("The chooseData is: " + chooseData);
	}

	public void initNodes() {
		// fake node. all the direct children nodes will be root nodes.
		rootNode = new TreeNodeImpl();

		RichFacesTreeNode node = new RichFacesTreeNode("Desktop Type");
		node.addChild("1_1", new RichFacesTreeNode("Compact"));
		node.addChild("1_2", new RichFacesTreeNode("Everyday"));
		node.addChild("1_3", new RichFacesTreeNode("Gaming"));
		node.addChild("1_4", new RichFacesTreeNode("Premium"));
		rootNode.addChild("1", node);

		node = new RichFacesTreeNode("Customer Reviews");
		node.addChild("2_1", new RichFacesTreeNode("Top Rated"));
		rootNode.addChild("2", node);

		node = new RichFacesTreeNode("Current Offers");
		node.addChild("3_1", new RichFacesTreeNode("On Sale"));
		node.addChild("3_2", new RichFacesTreeNode("Special Offers"));
		node.addChild("3_3", new RichFacesTreeNode("Package Deals"));
		node.addChild("3_4", new RichFacesTreeNode("Financing offers"));
		node.addChild("3_5", new RichFacesTreeNode("Outlet Center"));
		rootNode.addChild("3", node);

		node = new RichFacesTreeNode("Availability");
		node.addChild("4_1", new RichFacesTreeNode("In store & Online"));
		node.addChild("4_2", new RichFacesTreeNode("Online only"));
		rootNode.addChild("4", node);

	}

	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}

	public TreeNode getRootNode() {
		if (rootNode == null) {
			initNodes();
		}
		return rootNode;
	}

	public List<String> getSelection() {
		return selection;
	}

	public void setSelection(List<String> selection) {
		this.selection = selection;
	}

	public void setToggledNodeData(String toggledNodeData) {
		this.toggledNodeData = toggledNodeData;
	}

	public String getToggledNodeData() {
		return toggledNodeData;
	}
}

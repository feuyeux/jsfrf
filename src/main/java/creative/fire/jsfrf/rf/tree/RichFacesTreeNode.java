package creative.fire.jsfrf.rf.tree;

import org.richfaces.model.TreeNodeImpl;

public class RichFacesTreeNode extends TreeNodeImpl {
	private String data;
	private boolean selected;

	public RichFacesTreeNode(String data) {
		super();
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}

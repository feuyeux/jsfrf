package creative.fire.jsfrf.rf.tree;

import org.richfaces.model.TreeNodeImpl;

public class JSFRFTreeNode extends TreeNodeImpl {
	private String data;
	private boolean selected;

	public JSFRFTreeNode(String data) {
		super();
		this.data = data;
	}

	public String getData() {
		return this.data;
	}

	public boolean isSelected() {
		return this.selected;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return this.data + " selected?" + this.selected;
	}
}

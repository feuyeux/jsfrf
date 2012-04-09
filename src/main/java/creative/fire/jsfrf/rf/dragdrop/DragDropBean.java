package creative.fire.jsfrf.rf.dragdrop;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.richfaces.event.DropEvent;

import creative.fire.jsfrf.jsf.input.Yijing;
import creative.fire.jsfrf.jsf.input.YijingCollection;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean
@ViewScoped
public class DragDropBean {
	private ArrayList<Yijing> list;

	public DragDropBean() {
		list = YijingCollection.getYijings();
	}

	public void acceptDrop(DropEvent event) {
		Yijing dragged = (Yijing) event.getDragValue();
		list.remove(dragged);
	}
}

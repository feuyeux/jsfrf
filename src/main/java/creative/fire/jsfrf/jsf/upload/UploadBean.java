package creative.fire.jsfrf.jsf.upload;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

@ManagedBean
@SessionScoped
public class UploadBean {
	private ArrayList<UploadedFile> files = new ArrayList<UploadedFile>();
	
	public void listener(FileUploadEvent event) throws Exception {
		UploadedFile item = event.getUploadedFile();
		files.add(item);
	}
}

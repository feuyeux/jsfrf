package creative.fire.jsfrf.jsf.upload;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

import creative.fire.jsfrf.jsf.event.JSFRFActionListener;

@ManagedBean
@ViewScoped
public class UploadBean {
	static Logger logger = Logger.getLogger(UploadBean.class);
	private ArrayList<UploadedFile> files = new ArrayList<UploadedFile>();
	private int maxNum;

	public ArrayList<UploadedFile> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<UploadedFile> files) {
		this.files = files;
	}

	public int getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}

	public void uploading(FileUploadEvent event) throws Exception {
		UploadedFile item = event.getUploadedFile();
		files.add(item);
		logger.debug("[" + item.getParameterName() + "] file=" + item.getName() + " size=" + item.getSize());
	}
}

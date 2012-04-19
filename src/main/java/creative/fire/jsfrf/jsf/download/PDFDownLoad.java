package creative.fire.jsfrf.jsf.download;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import creative.fire.jsfrf.global.JSFRFFaces;

@ManagedBean(name = "pdfDownLoad")
@RequestScoped
public class PDFDownLoad {
	private final String SYS_SEPEARTOR = System.getProperty("file.separator");
	private final String prefixDir = JSFRFFaces.getRealPath("") + "file" + SYS_SEPEARTOR;
	private String pdfFileName;

	public void generatePDF(String head, String body) throws Exception {
		pdfFileName = "jsfrf_" + System.currentTimeMillis() + ".pdf";
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(prefixDir + pdfFileName));
		generatePDFReport(head, body, output);
		output.close();
		pushDownload(pdfFileName);
	}

	private void generatePDFReport(String head, String body, BufferedOutputStream output) throws DocumentException {
		Document document = new Document();
		//PdfWriter writer = PdfWriter.getInstance(document, output);
		document.open();
		document.newPage();
		Font headerFont = new Font();
		Paragraph text = new Paragraph(head, headerFont);
		document.add(text);
		Paragraph titleText = new Paragraph(body);
		titleText.setAlignment(Element.ALIGN_CENTER);
		titleText.setSpacingAfter(5);
		document.add(titleText);
		document.close();
	}

	private HttpServletResponse obtainResponse(String fileName) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		String contentType = "application/pdf";
		response.setContentType(contentType);

		StringBuilder contentDisposition = new StringBuilder();
		contentDisposition.append("attachment;");
		contentDisposition.append("filename=\"");
		contentDisposition.append(fileName);
		contentDisposition.append("\"");
		response.setHeader("Content-Disposition", contentDisposition.toString());
		return response;
	}

	private void pushDownload(String pdfFileName) {
		try {
			HttpServletResponse response = obtainResponse(pdfFileName);
			ServletOutputStream os = response.getOutputStream();
			byte[] bytes = new byte[0xffff];
			InputStream is = new FileInputStream(prefixDir + pdfFileName);
			int b = 0;
			while ((b = is.read(bytes, 0, 0xffff)) > 0) {
				os.write(bytes, 0, b);
			}
			is.close();
			os.flush();
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

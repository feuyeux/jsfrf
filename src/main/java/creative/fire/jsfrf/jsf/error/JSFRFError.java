package creative.fire.jsfrf.jsf.error;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.RequestDispatcher;

import creative.fire.jsfrf.global.JSFRFFaces;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean(name = "jrerror")
@RequestScoped
public class JSFRFError {
	private Map<String, Object> requestMap = JSFRFFaces.getRequestMap();

	public String getStackTrace() {
		Throwable errorObject = (Throwable) requestMap.get(RequestDispatcher.ERROR_EXCEPTION);
		if (errorObject != null) {
			StringWriter stringWriter = new StringWriter();
			PrintWriter writer = new PrintWriter(stringWriter);
			errorObject.printStackTrace(writer);
			return stringWriter.toString();
		} else {
			return "";
		}
	}

	public String getErrorType() {
		Class<?> errorClass = (Class<?>) requestMap.get(RequestDispatcher.ERROR_EXCEPTION_TYPE);
		if (errorClass != null)
			return "错误类型：" + errorClass.getName();
		return "";
	}

	public String getErrorMessage() {
		String errorMessage = (String) requestMap.get(RequestDispatcher.ERROR_MESSAGE);
		return "错误信息：" + errorMessage;
	}

	public String getErrorUri() {
		String errorUri = (String) requestMap.get(RequestDispatcher.ERROR_REQUEST_URI);
		return "错误页面地址：" + errorUri;
	}

	public String getServletName() {
		return (String) requestMap.get(RequestDispatcher.ERROR_SERVLET_NAME);
	}

	public String getErrorCode() {
		Integer errorCode = (Integer) requestMap.get(RequestDispatcher.ERROR_STATUS_CODE);
		return "错误代码：" + errorCode;
	}
}

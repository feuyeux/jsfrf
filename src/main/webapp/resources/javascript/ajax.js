var console = "";
var error = "";

function requestMonitor(data) {
	var componentId = data.source.id;
	var xml = data.responseXML;
	var text = data.responseText;
	var code = data.responseCode;
	var type = data.type;
	var status = data.status;

	if (status == "begin") {
		console = " type=" + type + " status=" + status;
	} else if (status == "complete") {
		var lm = xml.lastModified;
		console = console + " <br/> " + lm + " <br/> " + "code=" + code
				+ " type=" + type + " status=" + status;
	} else if (status == "success") {
		console = console + " <br/> " + "code=" + code + " type=" + type
				+ " status=" + status;
	} else {
		console = status;
	}

	jQuery('#ajaxForm\\:ajaxConsole').html(console);
}

function errorHandler(data) {
	var componentId = data.source.id;
	var xml = data.responseXML;
	var text = data.responseText;
	var code = data.responseCode;
	var type = data.type;
	var status = data.status;

	var description = data.description;
	var errorName = data.errorName;
	var errorMessage = data.errorMessage;

	error = "errorName=" + errorName + " errorMessage=" + errorMessage
			+ " description=" + description + " status=" + status;
	if (status == "httpError") {
	} else if (status == "emptyResponse") {
	} else if (status == "malformedXML") {
	} else if (status == "serverError") {
	} else {
		error = status;
	}

	jQuery('#ajaxForm\\:ajaxErrorMessage').html(error);
}
jsfrfEventCallback = function(data) {
	var status = data.status;
	if (status === 'success') {
		var source = data.source;
		var xml = data.responseXML;
		var text = data.responseText;
		message = "OnEvent:\nsource=" + source.id + "\nstatus=" + status
				+ "\ntext=" + text + "\nxml.URL=" + xml.URL;
		alert(message);
	}
}

jsf.ajax.addOnEvent(jsfrfEventCallback);

jsfrfErrorCallback = function(data) {
	var componentId = data.source.id;
	var xml = data.responseXML;
	var text = data.responseText;
	var code = data.responseCode;
	var type = data.type;
	var status = data.status;

	var description = data.description;
	var errorName = data.errorName;
	var errorMessage = data.errorMessage;

	error = "OnError:\n" + "Ajax Error:\nstatus=" + status + "\nerrorName="
			+ errorName + "\nerrorMessage=" + errorMessage + "\ndescription="
			+ description;
	if (status == "httpError") {

	} else if (status == "emptyResponse") {

	} else if (status == "malformedXML") {

	} else if (status == "serverError") {

	} else {
		error = status;
	}

	alert(error);
	var path = getRoot() + "/welcome.jsf";
	alert(path);
	location.href = path;
}

jsf.ajax.addOnError(jsfrfErrorCallback);

function getRoot() {
	var all = window.document.location.href;
	var self = window.document.location.pathname;
	var pos = all.indexOf(self);
	var prePath = all.substring(0, pos);
	var postPath = self.substring(0, self.substr(1).indexOf('/') + 1);
	return prePath + postPath;
}

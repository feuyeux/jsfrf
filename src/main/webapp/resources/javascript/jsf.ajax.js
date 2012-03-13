jsfrfEventCallback = function(data) {
	var status = data.status;
	if (status === 'success') {
		var source = data.source;
		var xml = data.responseXML;
		var text = data.responseText;
		alert(source.id + "\n" + status + "\n" + text + "\n" + xml.URL);
	}
}

//jsf.ajax.addOnEvent(jsfrfEventCallback);

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

	error = "Ajax Error:\nstatus=" + status + "\nerrorName=" + errorName
			+ "\nerrorMessage=" + errorMessage + "\ndescription=" + description;
	if (status == "httpError") {
		
	} else if (status == "emptyResponse") {
		
	} else if (status == "malformedXML") {
		
	} else if (status == "serverError") {
		
	} else {
		error = status;
	}

	alert(error);
	top.location.href="faces/error/error0.jsf"; 
}

jsf.ajax.addOnError(jsfrfErrorCallback);
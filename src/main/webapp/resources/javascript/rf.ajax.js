var rfconsole = "";

function doBeforeSubmit() {
	rfconsole = rfconsole + "onBeforeSubmit"+"<br/>";
	jQuery('#ajaxForm\\:rfAjaxConsole').html(rfconsole);
}

function doBegin() {
	rfconsole = rfconsole + "onBegin"+"<br/>";
	jQuery('#ajaxForm\\:rfAjaxConsole').html(rfconsole);
}

function doBeforeDomUpdate() {
	rfconsole = rfconsole + "onBeforeDomUpdate"+"<br/>";
	jQuery('#ajaxForm\\:rfAjaxConsole').html(rfconsole);
}

function doComplete(data) {
	rfconsole = rfconsole + "onComplete:" + data + "<br/>";
	jQuery('#ajaxForm\\:rfAjaxConsole').html(rfconsole);
}
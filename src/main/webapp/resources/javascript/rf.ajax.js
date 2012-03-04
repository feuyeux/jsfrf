var rfconsole = "";

function doBeforeSubmit() {
	rfconsole = rfconsole + "onBeforeSubmit" + "<br/>";
	jQuery('#ajaxForm\\:rfAjaxConsole').html(rfconsole);
}

function doBegin() {
	rfconsole = rfconsole + "onBegin" + "<br/>";
	jQuery('#ajaxForm\\:rfAjaxConsole').html(rfconsole);
}

function doBeforeDomUpdate(data) {
	rfconsole = rfconsole + "onBeforeDomUpdate" + data + "<br/>";
	jQuery('#ajaxForm\\:rfAjaxConsole').html(rfconsole);
}

function doComplete(data) {
	rfconsole = rfconsole + "onComplete:" + data + "<br/>";
	jQuery('#ajaxForm\\:rfAjaxConsole').html(rfconsole);
}

function doOnKeyup() {
	rfconsole = rfconsole + "onkeyup" + "<br/>";
	jQuery('#ajaxForm\\:rfAjaxConsole').html(rfconsole);
}

function doOnKeydown() {
	rfconsole = rfconsole + "onkeydown" + "<br/>";
	jQuery('#ajaxForm\\:rfAjaxConsole').html(rfconsole);
}
var rfconsole = "";
var start;

function doBeforeSubmit() {
	rfconsole = rfconsole + "onBeforeSubmit" + "<br/>";
	jQuery('#ajaxForm\\:rfAjaxConsole').html(rfconsole);
}

function doBegin() {
	start = new Date().getTime();
	rfconsole = rfconsole + "onBegin" + "<br/>";
	jQuery('#ajaxForm\\:rfAjaxConsole').html(rfconsole);
}

function doBeforeDomUpdate(data) {
	var end = new Date().getTime();
	var elapse = end - start;
	rfconsole = rfconsole + "onBeforeDomUpdate" + data + "  耗时：" + elapse
			+ "毫秒 <br/>";
	jQuery('#ajaxForm\\:rfAjaxConsole').html(rfconsole);
}

function doComplete(data) {
	var end = new Date().getTime();
	var elapse = end - start;
	rfconsole = rfconsole + "onComplete:" + data + "  耗时：" + elapse
			+ "毫秒 <br/>";
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
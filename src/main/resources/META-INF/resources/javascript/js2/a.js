function callA() {
	alert('2');
}

rf4js.js2 = function() {
};
rf4js.js2.path = 'javascript.js2.a.js';
rf4js.js2.callA = function() {
	with (rf4js.js2) {
		alert('22');
	}
};
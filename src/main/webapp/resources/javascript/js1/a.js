function callA() {
	alert('1');
}
var rf4js = rf4js ? rf4js : {};
rf4js.js1 = rf4js.js1 ? rf4js.js1 : {
	path : 'javascript.js1.a.js',
	callA : function() {
		alert('11');
	}
};
function loadJs(jsName, file) {
	var scriptTag = document.getElementById(jsName);
	var head = document.getElementsByTagName('head').item(0);
	if (scriptTag)
		head.removeChild(scriptTag);
	script = document.createElement('script');
	script.src = file;
	script.type = 'text/javascript';
	script.id = jsName;
	head.appendChild(script);
}

function loadCss(styleName, file) {
	alert(styleName + ', ' + file);
}
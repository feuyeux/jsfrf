function loadJs(file) {
	var scriptTag = document.getElementById('loadScript');
	var head = document.getElementsByTagName('head').item(0);
	if (scriptTag)
		head.removeChild(scriptTag);
	script = document.createElement('script');
	script.src = file;
	script.type = 'text/javascript';
	script.id = 'loadScript';
	head.appendChild(script);
}

function loadCss(styleName, file) {
	var cssTag = document.getElementById(styleName);
	//var head = document.getElementsByTagName('head').item(0);
	var head = document.getElementsByTagName("head")[0];
	if (cssTag)
		head.removeChild(cssTag);
	css = document.createElement('link');
	css.href = file;
	css.rel = 'stylesheet';
	css.type = 'text/css';
	css.id = styleName;
	head.appendChild(css);
}
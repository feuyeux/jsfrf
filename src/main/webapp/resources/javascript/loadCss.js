function loadCss(styleName, file) {
	var cssTag = document.getElementById(styleName);
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
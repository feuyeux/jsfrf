/*
 * @param f - 目标form
 * @param pvp - 传递参数的键值对数组，将被添加到form的隐藏域中
 * @param t - 被提交的目标form
 */
mojarra.jsfcljs = function jsfcljs(f, pvp, t) {
	mojarra.apf(f, pvp);
	var ft = f.target;
	if (t) {
		f.target = t;
	}
	f.submit();
	f.target = ft;
	mojarra.dpf(f);
};

mojarra.apf = function apf(f, pvp) {
	var adp = new Array();
	f.adp = adp;
	var i = 0;
	for ( var k in pvp) {
		if (pvp.hasOwnProperty(k)) {
			var p = document.createElement("input");
			p.type = "hidden";
			p.name = k;
			p.value = pvp[k];
			f.appendChild(p);
			adp[i++] = p;
		}
	}
};

mojarra.dpf = function dpf(f) {
	var adp = f.adp;
	if (adp !== null) {
		for ( var i = 0; i < adp.length; i++) {
			f.removeChild(adp[i]);
		}
	}
};
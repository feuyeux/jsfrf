function selectAll(prefix, page, size) {
	var checkAll = document.getElementById(prefix + 'all').checked;
	for ( var i = 0; i < size; i++) {
		var seq = i;
		var cbName = prefix + seq + ':cbox';
		var checkBox = document.getElementById(cbName);
		if (checkBox != null) {
			if (checkAll)
				checkBox.checked = true;
			else
				checkBox.checked = false;
		}
	}
}

function antiSelect(prefix) {
	document.getElementById(prefix + 'all').checked = false;
}

function findFirstSelected(prefix, checkedHidden, page, size) {
	document.getElementById(checkedHidden).value = -1;
	for ( var i = 0; i < size; i++) {
		var seq = (page - 1) * size + i;
		var cbName = prefix + seq + ':cbox';
		var checkBox = document.getElementById(cbName);
		if (checkBox != null) {
			if (checkBox.checked) {
				document.getElementById(checkedHidden).value = seq;
				break;
			}
		}
	}
}
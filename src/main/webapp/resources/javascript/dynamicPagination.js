/*
 * author: feuyeux@gmail.com
 * create time: 12th Dec 2011
 * reference: http://en.wikipedia.org/wiki/Display_resolution
 */
var SCREENWIDTH = screen.width;
var SCREENHEIGHT = screen.height;
var SIZE1 = '1';
var SIZE2 = '2';
var SIZE3 = '3';
var SIZE4 = '4';
var SIZE5 = '5';

function isXGA() {
	return (SCREENWIDTH == 1024 && SCREENHEIGHT == 768);
}
function isXGAPlus() {
	return (SCREENWIDTH == 1152 && SCREENHEIGHT == 864);
}
function isWXGA() {
	return (SCREENWIDTH == 1280 && SCREENHEIGHT == 720);
}
function isWXGA2() {
	return (SCREENWIDTH == 1280 && SCREENHEIGHT == 800);
}
function isSXGA() {
	return (SCREENWIDTH == 1280 && SCREENHEIGHT == 960);
}
function isSXGAPlus() {
	return (SCREENWIDTH == 1280 && SCREENHEIGHT == 1024);
}
function isHD1() {
	return (SCREENWIDTH == 1360 && SCREENHEIGHT == 768);
}
function isHD2() {
	return (SCREENWIDTH == 1366 && SCREENHEIGHT == 768);
}
function isWXGAPlus() {
	return (SCREENWIDTH == 1440 && SCREENHEIGHT == 900);
}
function isHDPlus() {
	return (SCREENWIDTH == 1600 && SCREENHEIGHT == 900);
}
function isUXGA() {
	return (SCREENWIDTH == 1600 && SCREENHEIGHT == 1200);
}
function isWSXGAPlus() {
	return (SCREENWIDTH == 1680 && SCREENHEIGHT == 1050);
}
function isFHD() {
	return (SCREENWIDTH == 1920 && SCREENHEIGHT == 1080);
}
function isWUXGAPlus() {
	return (SCREENWIDTH == 1920 && SCREENHEIGHT == 1200);
}
function isWQHD() {
	return (SCREENWIDTH == 2560 && SCREENHEIGHT == 1440);
}

function getAlternativeType(){
	if(SCREENHEIGHT>=1200)
		return SIZE5;
	if(SCREENHEIGHT>=900)
		return SIZE4;
	if(SCREENHEIGHT>=850)
		return SIZE3;
	if(SCREENHEIGHT>=800)
		return SIZE2;
	return SIZE1;
}

function getPageSize() {
	// TODO
	// var width = $(document.body).width();
	// var height = $(document.body).height();
	var type = getDisplayResolutionType();
	if (SIZE1 == type)
		return 20;
	if (SIZE2 == type)
		return 25;
	if (SIZE3 == type)
		return 30;
	if (SIZE4 == type)
		return 35;
	if (SIZE5 == type)
		return 40;
}

function getDisplayResolutionType() {
	if (isFHD()) {
		return SIZE4;
	}
	if (isWSXGAPlus()) {
		return SIZE4;
	}
	if (isSXGAPlus()) {
		return SIZE4;
	}
	if (isWXGAPlus()) {
		return SIZE3;
	}
	if (isWUXGAPlus()) {
		return SIZE5;
	}
	if (isHD2()) {
		return SIZE1;
	}
	if (isWXGA2()) {
		return SIZE2;
	}
	if (isXGA()) {
		return SIZE1;
	}
	if (isHDPlus()) {
		return SIZE3;
	}
	if (isHD1()) {
		return SIZE1;
	}
	if (isUXGA()) {
		return SIZE4;
	}
	if (isSXGA()) {
		return SIZE3;
	}
	if (isXGAPlus()) {
		return SIZE2;
	}
	if (isWQHD()) {
		return SIZE5;
	}
	if (isWXGA()) {
		return SIZE1;
	}
	return getAlternativeType();
}
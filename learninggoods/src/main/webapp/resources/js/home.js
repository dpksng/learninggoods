function loginToggle(){
	document.getElementById("accordion2").style.display="none";
	document.getElementById("accordion1").style.display="block";
	document.getElementById("btn-l").className="btn-b";
	document.getElementById("btn-r").className="btn-e";
}
		
function registerToggle(){
	document.getElementById("accordion1").style.display="none";
	document.getElementById("accordion2").style.display="block";
	document.getElementById("btn-r").className="btn-b";
	document.getElementById("btn-l").className="btn-e";
}
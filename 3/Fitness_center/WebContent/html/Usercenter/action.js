window.onload=function(){
	document.getElementById("menue").onclick=function(e){
		var lis=this.getElementsByTagName("a");
        for(var i=0;i<lis.length;i++){
			lis[i].style.backgroundColor="#3B3B3B";
        }
		e.target.style.backgroundColor="#00FF00";
	}
};
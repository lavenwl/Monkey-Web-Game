	function GetParam(){
		var url=document.location.href;
		var name="";
		if(url.indexOf("x=")>0){
			name=url.substring(url.indexOf("x=")+2,url.length);
		}
		return name;
	}
	
	function menuSearch(){
	//alert(GetParam());
		if(GetParam().length==0) return;
		if(GetParam()=='1')
		show_menu('gmtool');
		else if(GetParam()=='2')
		show_menu('img');
		else if(GetParam()=='3')
		show_menu('class_info');
	}
	
	function testfunction(){
		alert("123123");
	}
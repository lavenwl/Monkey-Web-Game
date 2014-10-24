// JavaScript Document
function fixPng() { 
  var arVersion = navigator.appVersion.split("MSIE") 
  var version = parseFloat(arVersion[1]) 
 
  if ((version >= 5.5 && version < 7.0) && (document.body.filters)) { 
      for(var j=0; j<document.images.length; j++)
       {
          var img = document.images[j]
          var imgName = img.src.toUpperCase()
          if (imgName.substring(imgName.length-3, imgName.length) == "PNG")
          {
             var imgID = (img.id) ? "id='" + img.id + "' " : ""
             var imgClass = (img.className) ? "class='" + img.className + "' " : ""
             var imgTitle = (img.title) ? "title='" + img.title + "' " : "title='" + img.alt + "' "
             var imgStyle = "display:inline-block;" + img.style.cssText
             if (img.align == "left") imgStyle = "float:left;" + imgStyle
             if (img.align == "right") imgStyle = "float:right;" + imgStyle
             if (img.parentElement.href) imgStyle = "cursor:hand;" + imgStyle
             var strNewHTML = "<span " + imgID + imgClass + imgTitle
             + " style=\"" + "width:" + img.width + "px; height:" + img.height + "px;" + imgStyle + ";"
             + "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader"
             + "(src=\'" + img.src + "\', sizingMethod='scale');\"></span>"
             img.outerHTML = strNewHTML
             j = j-1
			}
		} 
	}
}


function BOX_show(e,value)
{
    if(document.getElementById(e)==null)
    {
        return ;
    }
    
    var selects = document.getElementsByTagName('select');
    for(i = 0; i < selects.length; i++)
    {
        selects[i].style.visibility = "hidden";
    } 

    BOX_layout(e);
    window.onresize = function(){BOX_layout(e);} 
    window.onscroll = function(){BOX_layout(e);} 
    document.onkeyup = function(event)
    {
        var evt = window.event || event;
        var code = evt.keyCode?evt.keyCode : evt.which;
        //alert(code);

        if(code == 27)
        {
            BOX_remove(e);
        }
    }
	document.getElementById('ms').innerHTML=value;
}

function BOX_remove(e)
{
    window.onscroll = null;
    window.onresize = null;
    document.getElementById('BOX_overlay').style.display="none";
    document.getElementById(e).style.display="none";

    var selects = document.getElementsByTagName('select');
    for(i = 0; i < selects.length; i++)
    {
        selects[i].style.visibility = "visible";
    }
}

function BOX_layout(e)
{
    var a = document.getElementById(e);

    if (document.getElementById('BOX_overlay')==null)
    {

        var overlay = document.createElement("div");
        overlay.setAttribute('id','BOX_overlay');

        //overlay.onclick=function(){BOX_remove(e);};
        //a.parentNode.appendChild(overlay);
        document.body.appendChild(overlay);
    }

    document.getElementById('BOX_overlay').ondblclick=function(){BOX_remove(e);};
   
    var scrollLeft = (document.documentElement.scrollLeft ? document.documentElement.scrollLeft : document.body.scrollLeft);
    var scrollTop = (document.documentElement.scrollTop ? document.documentElement.scrollTop : document.body.scrollTop);

    var clientWidth;
    if (window.innerWidth)
    {
        clientWidth = window.innerWidth;
       // clientWidth = ((Sys.Browser.agent === Sys.Browser.Safari) ? window.innerWidth : Math.min(window.innerWidth, document.documentElement.clientWidth));
    }
    else
    {
        clientWidth = document.documentElement.clientWidth;
    }

    var clientHeight;
    if (window.innerHeight)
    {
        clientHeight = window.innerHeight;
        //clientHeight = ((Sys.Browser.agent === Sys.Browser.Safari) ? window.innerHeight : Math.min(window.innerHeight, document.documentElement.clientHeight));
    }
    else
    {
        clientHeight = document.documentElement.clientHeight;
    }

    var bo = document.getElementById('BOX_overlay');
    bo.style.left = scrollLeft+'px';
    bo.style.top = scrollTop+'px';
    bo.style.width = clientWidth+'px';
    bo.style.height = clientHeight+'px';
    bo.style.display="";
  
    a.style.position = 'absolute';
    a.style.zIndex=999;
    a.style.display="";
    //a.style.left = scrollLeft+((clientWidth-a.offsetWidth)/2)+'px';
    //a.style.top = scrollTop+((clientHeight-a.offsetHeight)/2)+'px';
}

function HiddenButton(e)
{
    e.style.visibility='hidden';
    e.coolcodeviousSibling.style.visibility='visible'
}

function showDiv(){

	var sdiv=document.getElementById("messdiv");
	if(sdiv.style.display=='none'){
		sdiv.style.display='block';
	}else{
		sdiv.stlye.display='none';
	}
}

	
 



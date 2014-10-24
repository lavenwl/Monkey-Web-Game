// JavaScript Document// JavaScript Document
function check_index_login(){
	var user_name ;
}

function check_comments(){
	var comm = document.getElementById('comments').value;
	if(comm == ''){
		alert('评论不能为空');
		return false;
	}
	return true;
}

/**
 * @method changeTabs
 * @param _arrTab tab数组
 * @param _currTabId 当前Tab的ID值
 * @description 根据Tab数组和当前Tab的ID值更改tab显示
 */
function changeTabs(_arrTab,_currTabId) {
	var _len = _arrTab.length;
	for(var i=0;i<_le;i++) {
		var _e = document.getElementById(_arrTab[i]);
		if(_e) {
			//_e.style.display = "none";
			_e.style.visibility = "hidden";
		}
		
	}
	
	var _e = document.getElementById(_currTabId);		
	if(_e) {
		//_e.style.display = "block";
		_e.style.visibility = "visible";
	}
}
function uploadSuccess(){
	layer.msg('上传成功', {
			time: 1000,
			icon: 1
		}
	);
}
function uploadFaild(){
	layer.msg('上传失败', {
		time: 2000,
		icon: 2
	});
}
function saveSuccess(flag){
	layer.msg('保存成功', {
		time: 1000,
		icon: 1,
		end: function(){
			if(flag) parent.location.reload();
		}
	});
}
function saveFaild(){
	layer.msg("保存失败", {
		time: 2000,
		icon: 1
	});
}
function ajaxFaild(errMsg){
	layer.msg(errMsg, {
		time: 2000,
		icon: 1
	});
}
function ajaxComplete(data){
	if(data.success){
		return true;
	}
    ajaxFaild(data.errMsg);
	return false;
}

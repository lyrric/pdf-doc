
	
	$('.job-div').mouseover(function(){
		let id = $(this).data('div-id');
		$($('.job-button')[id]).show();
		$($('.job-content')[id]).hide();
	});
	$('.job-div').mouseout(function(){
		let id = $(this).data('div-id');
		$($('.job-button')[id]).hide();
		$($('.job-content')[id]).show();
	});
	$('.edu-div').mouseover(function(){
		let id = $(this).data('div-id');
		$($('.edu-button')[id]).show();
		$($('.edu-content')[id]).hide();
	});
	$('.edu-div').mouseout(function(){
		let id = $(this).data('div-id');
		$($('.edu-button')[id]).hide();
		$($('.edu-content')[id]).show();
	});
	
	$('.project-div').mouseover(function(){
		let id = $(this).data('div-id');
		$($('.project-button')[id]).show();
		$($('.project-content')[id]).hide();
	});
	$('.project-div').mouseout(function(){
		let id = $(this).data('div-id');
		$($('.project-button')[id]).hide();
		$($('.project-content')[id]).show();
	});
	$('.credential-div').mouseover(function(){
		let id = $(this).data('div-id');
		$($('.credential-button')[id]).show();
		//$($('.credential-content')[id]).hide();
	});
	$('.credential-div').mouseout(function(){
		let id = $(this).data('div-id');
		$($('.credential-button')[id]).hide();
		//$($('.credential-content')[id]).show();
	});
	$('.skill-div').mouseover(function(){
		let id = $(this).data('div-id');
		$($('.skill-del-btn')[id]).show();
		//$($('.skill-title')[id]).hide();
	});
	$('.skill-div').mouseout(function(){
		let id = $(this).data('div-id');
		$($('.skill-del-btn')[id]).hide();
		//$($('.skill-title')[id]).show();
	});

var iframeIndex=0;
function showPage(obj){
	let url = $(obj).data('url');
	let title = $(obj).data('title');
	let id = $(obj).data('id');
	let width = $(obj).data('width');
	let height = $(obj).data('height');
	iframeIndex = layer.open({
		type: 2,
		shadeClose: true,
		shade: 0.5,
		title: title,
		maxmin: false,
		area: [width, height],
		content: url 
	});
}
function closeIframe(){
	layer.close(iframeIndex);
}
function del(obj){
	let id = $(obj).data('id');
	let url = $(obj).data('url');
	layer.confirm('确定删除吗？', {
	  btn: ['确定','取消'] //按钮
	}, function(){
		$.ajax({
			url:url+'/'+id,
			dataType:'json',
			type:'delete',
			success:function(data){
				if(ajaxComplete(data)){
					layer.msg('删除成功', {
						time: 1000,
						icon: 1,
						end: function(){
							window.location.reload();
						}
					});
				}
			},
			error:function(){
				ajaxFaild('删除失败');
			}
		});
	}, function(){
	  
	});
}
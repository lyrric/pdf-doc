// 上传图片
 function upImage(url, success, error, progress) {
    var fileInput = document.createElement('input');
    Object.assign(fileInput, {
        type: 'file',
        accept: '.png,.jpg,.jpeg,.gif',
        name: 'upfile',
        // multiple: 'multiple',
        style: 'display:none;'
    });

    // 选中图片后
    fileInput.onchange = function() {
        fileInput.onchange = null;
        if (fileInput.files[0].size / 1024 / 1024 < 10) {
            // message.error('不能上传大于10MB的图片');
            var formData = new FormData();
            formData.append('file', fileInput.files[0]);
            var xmlHttp = (function() {
                if (window.ActiveXObject) return new ActiveXObject('Microsoft.XMLHTTP');
                if (window.XMLHttpRequest) return new XMLHttpRequest();
            })();
            xmlHttp.open('POST', url, true);
            xmlHttp.send(formData);
            xmlHttp.addEventListener(
                'progress',
                function(xhr) {
                    isFunction(progress) && progress(Math.round((xmlHttp.loaded / xmlHttp.total) * 100, 2));
                },
                false
            );
            xmlHttp.onreadystatechange = function() {
                //请求的状态有5个值：0=未初始化；1=正在加载；2=已经加载；3=交互中；4=完成；
                if (xmlHttp.readyState !== 4) return;
                if (xmlHttp.status === 200) {
                    //200对应OK，如404=未找到网页
                    isFunction(success) && success(JSON.parse(xmlHttp.responseText));
                } else {
                    isFunction(error) && error();
                }
            }; //onreadystatechange
        } else {
            message.error('不能上传大于5MB的图片');
        }
    };
    if (document.body) {
        document.body.appendChild(fileInput);
    } else {
        document.appendChild(fileInput);
    }
    fileInput.click();
}
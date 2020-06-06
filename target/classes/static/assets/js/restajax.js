(function () {
    var methods = {
        POST_METHOD: 'POST',
        DELETE_METHOD: 'DELETE',
        PUT_METHOD: 'PUT',
        GET_METHOD: 'GET'
    };

    /**
     * 对象转form表单
     * @param obj
     * @returns {*}
     */
    function objToForm(obj) {
        var formStr = '';
        for (var name in obj) {
            if (formStr == undefined || formStr == null || formStr == '') {
                formStr += name + '=' + obj[name];
            } else {
                formStr += '&' + name + '=' + obj[name];
            }
        }
        return formStr;
    }

    /**
     * 新增
     * @param url
     * @param dataObj
     * @param args
     * @param successCallback
     * @param errorCallback
     * @param beforeCallback
     * @param completeCallback
     */
    function postJson(url, dataObj, args, successCallback, errorCallback, beforeCallback, completeCallback) {
        doAjax(url, methods.POST_METHOD, dataObj, args, successCallback, errorCallback, beforeCallback, completeCallback);
    }

    /**
     * 删除
     * @param url
     * @param dataObj
     * @param args
     * @param successCallback
     * @param errorCallback
     * @param beforeCallback
     * @param completeCallback
     */
    function deleteForm(url, dataObj, args, successCallback, errorCallback, beforeCallback, completeCallback) {
        doAjax(url, methods.DELETE_METHOD, dataObj, args, successCallback, errorCallback, beforeCallback, completeCallback);
    }

    /**
     * 修改
     * @param url
     * @param dataObj
     * @param args
     * @param successCallback
     * @param errorCallback
     * @param beforeCallback
     * @param completeCallback
     */
    function putJson(url, dataObj, args, successCallback, errorCallback, beforeCallback, completeCallback) {
        doAjax(url, methods.PUT_METHOD, dataObj, args, successCallback, errorCallback, beforeCallback, completeCallback);
    }

    /**
     * 查询
     * @param url
     * @param dataObj
     * @param args
     * @param successCallback
     * @param errorCallback
     * @param beforeCallback
     * @param completeCallback
     */
    function getForm(url, dataObj, args, successCallback, errorCallback, beforeCallback, completeCallback) {
        doAjax(url, methods.GET_METHOD, dataObj, args, successCallback, errorCallback, beforeCallback, completeCallback);
    }

    /**
     * 执行上传
     * @param url
     * @param method
     * @param dataObj
     * @param args
     * @param successCallback
     * @param errorCallback
     * @param beforeCallback
     * @param completeCallback
     */
    function doAjax(url, method, dataObj, args, successCallback, errorCallback, beforeCallback, completeCallback) {
        var ajaxData = (dataObj == undefined || dataObj == null) ? {} : dataObj;
        if (methods.POST_METHOD == method || methods.PUT_METHOD == method) {
            ajaxData = JSON.stringify(ajaxData);
        } else {
            ajaxData = objToForm(ajaxData);
            dataObj.tm = new Date().getTime();
        }
        var headers = {};
        if(args != null && typeof(args.headers) != 'undefined' && args.headers != null) {
            headers = args.headers;
        }
        $.ajax({
            url: url,
            type: method,
            contentType: "application/json;charset=utf-8",
            headers: headers,
            data: ajaxData,
            success: function (data, status, XMLHttpRequest) {
                var responseCode = XMLHttpRequest.status;
                successCallback(responseCode, data, args);
            },
            error: function (XMLHttpRequest) {
                var responseCode = XMLHttpRequest.status;
                var responseData = JSON.parse(XMLHttpRequest.responseText);
                if (errorCallback != undefined && errorCallback != null && typeof(errorCallback) == 'function') {
                    errorCallback(responseCode, responseData);
                }
            },
            beforeSend: function (XMLHttpRequest) {
                if (beforeCallback != undefined && beforeCallback != null && typeof(beforeCallback) == 'function') {
                    beforeCallback(XMLHttpRequest);
                }
            },
            complete: function (XMLHttpRequest, status) {
                if (completeCallback != undefined && completeCallback != null && typeof(completeCallback) == 'function') {
                    completeCallback(XMLHttpRequest, status);
                }
            }
        });
    }

    /**
     * 检测是路径参数有重复值
     * @param pathArgArray
     * @returns {boolean}
     */
    function pathArgsHasSameValue(pathArgArray) {
        var tempArgIndex = 0;
        var tempArgs = pathArgArray[tempArgIndex];
        for (var i = (tempArgIndex + 1), item; item = pathArgArray[i]; i++) {
            if (tempArgs == item) {
                throw new Error('参数' + item + '有重复值!!!');
            }
            if (i == pathArgArray.length - 1) {
                tempArgs = pathArgArray[++tempArgIndex];
                i = tempArgIndex;
                continue;
            }
        }
    }

    /**
     * 获取页面间传递的参数
     * @param url
     */
    function getParamsArg(url) {
        var params = url.split('?')[1];
        var paramsObj = {};
        if (typeof(params) == 'undefined' || params == null) {
            return paramsObj;
        }
        var paramsKVs = params.split('&');
        for (var i = 0, item = null; item = paramsKVs[i++];) {
            var kvs = item.split('=');
            if (kvs.length == 1) {
                paramsObj[kvs[0]] = null;
            }
            if (kvs.length == 2) {
                paramsObj[kvs[0]] = decodeURI(kvs[1]);
            }
        }
        return paramsObj;
    }

    /**
     * 构建路径
     * @param basePath 请求路径，{参数},
     * @param pathArgs 替换的路径参数，不能重复
     * @returns {*}
     */
    function buildPath(basePath, pathArgs) {
        var path = basePath;
        if (!basePath || !(typeof(basePath) == 'string')) {
            throw new Error('basePath必须为字符串!!!');
        }
        if (!pathArgs || !Array.isArray(pathArgs)) {
            throw new Error('pathArgs必须为数组!!!');
        }
        var pathArgArray = basePath.match(/\{\w+\}/g);
        if (!pathArgArray) {
            return path;
        }
        pathArgsHasSameValue(pathArgArray);
        for (var i = 0, item; item = pathArgArray[i]; i++) {
            path = path.replace(item, pathArgs[i]);
        }
        return path;
    }

    /**
     * 通过form对象上传文件
     * @param url
     * @param formData
     * @param args
     * @param successCallback
     * @param errorCallback
     * @param beforeCallback
     * @param completeCallback
     */
    function postFile(url, formData, args, successCallback, errorCallback, beforeCallback, completeCallback) {
        var headers = {};
        if(args != null && typeof(args.headers) != 'undefined' && args.headers != null) {
            headers = args.headers;
        }
        $.ajax({
            url: url,
            type: 'POST',
            data: formData,
            processData: false,
            contentType: false,
            headers: headers,
            cache: false,
            success: function (data, status, XMLHttpRequest) {
                var responseCode = XMLHttpRequest.status;
                successCallback(responseCode, data, args);
            },
            error: function (XMLHttpRequest) {
                var responseCode = XMLHttpRequest.status;
                var responseData = JSON.parse(XMLHttpRequest.responseText);
                if (errorCallback != undefined && errorCallback != null && typeof(errorCallback) == 'function') {
                    errorCallback(responseCode, responseData);
                }
            },
            beforeSend: function (XMLHttpRequest) {
                if (beforeCallback != undefined && beforeCallback != null && typeof(beforeCallback) == 'function') {
                    beforeCallback(XMLHttpRequest);
                }
            },
            complete: function (XMLHttpRequest, status) {
                if (completeCallback != undefined && completeCallback != null && typeof(completeCallback) == 'function') {
                    completeCallback(XMLHttpRequest, status);
                }
            }
        });
    };

    /**
     * xss 转义
     * @param html
     * @returns {string}
     */
    function escape(html) {
        return String(html || '').replace(/&(?!#?[a-zA-Z0-9]+;)/g, '&amp;')
            .replace(/</g, '&lt;').replace(/>/g, '&gt;')
            .replace(/'/g, '&#39;').replace(/"/g, '&quot;');
    }

    function checkBoxToString(formObj, checkBoxKey) {
        var value = '';
        for(var key in formObj) {
            if(key.indexOf(checkBoxKey) != 0) {
                continue;
            }
            if(value !== '') {
                value += ',';
            }
            value += key.substring(checkBoxKey.length + 1, key.length - 1);
            delete formObj[key];
        }
        return value;
    }

    window.restAjax = {
        post: postJson,
        postFile: postFile,
        delete: deleteForm,
        put: putJson,
        get: getForm,
        params: getParamsArg,
        path: buildPath,
        escape: escape,
        checkBoxToString: checkBoxToString
    }

})();

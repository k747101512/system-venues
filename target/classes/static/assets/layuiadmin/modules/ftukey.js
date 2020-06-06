layui.define('common', function (exports) {
    var common = layui.common;

    var Ry;
    var handle;
    var UKeyLib = {};
    var CurrentLib = UKeyLib;
    var UkeyPid = '411C20E1';
    //获取guid
    CurrentLib.getJSGuid = function () {
        function S4() {
            return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
        }

        return (S4() + S4() + "-" + S4() + "-" + S4() + "-" + S4() + "-" + S4() + S4() + S4());
    }

    CurrentLib.initUkey = function () {
        if (common.getBrowserType() != 'IE') {
            top.dialog.msg('该功能仅支持IE11浏览器');
            return;
        }
        if (common.getIEBrowserVersion() != '11') {
            top.dialog.msg('该功能仅支持IE11浏览器');
            return;
        }
        var ret;
        Ry = document.getElementById("uKey");
        Ry.pid = UkeyPid;
        ret = Ry.Don_FindToken();
        if (ret == 0) {
            if (Ry.index != -1) {
                return true;
            }
        }
        return false;
    }

    CurrentLib.Open = function () {
        if (CurrentLib.initUkey()) {
            ret = Ry.Don_OpenToken();
            if (ret == 0) {
                handle = Ry.hHandle;
                return true;
            }
        }
        return false;
    }

    CurrentLib.WriteUKeyData = function (data) {
        if (CurrentLib.Open()) {
            var ret;
            Ry.DataLen = 120;
            Ry.Offset = 0;
            Ry.InData = CurrentLib.GetString(data);
            ret = Ry.Don_WriteData();
            if (ret == 0) {
                Ry.Don_CloseToken();
                return true;
            }
        }
        Ry.Don_CloseToken();
        return false;
    }

    CurrentLib.ReadUKeyData = function () {
        var reValue = new Object();
        if (CurrentLib.Open()) {
            var ret;
            Ry.DataLen = 120;
            Ry.Offset = 0;
            Ry.InData = 0;//清空Data
            ret = Ry.Don_ReadData();
            reValue.data = Ry.OutData;
            //获取真实数据
            var tag = "0000";
            reValue.data = reValue.data.substring(0, reValue.data.indexOf(tag));
            reValue.success = true;
            reValue.hid = Ry.hid;
        } else {
            reValue.success = false;
        }
        Ry.Don_CloseToken();
        return reValue;
    }

    CurrentLib.GetString = function (str) {
        var l = str.length;
        var blen = 0;
        for (i = 0; i < l; i++) {
            if ((str.charCodeAt(i) & 0xff00) != 0) {
                blen++;
            }
            blen++;
        }
        var len = 120;
        if (blen < len) {
            for (j = 0; j < len - blen; j++) {
                str += "0";
            }
        }
        return str;
    }

    CurrentLib.ParseJson = function (jsonString) {
        /// <summary>
        /// 将Json字符串转为对象
        /// </summary>
        /// <param name="value">待转化的字符串</param>
        jsonString = jsonString.replace(/\n/ig, "");
        jsonString = jsonString.replace(/\r/ig, "");
        try {
            var c = eval("(" + jsonString + ")");
        } catch (e) {
            alert("非严格的json字符串：" + jsonString);
        }
        return eval("(" + jsonString + ")");
    }

    //将JSON对象转化为字符串类型
    CurrentLib.JsonToString = function (o) {
        var arr = [];
        var fmt = function (s) {
            if (typeof s == 'object' && s != null) return json2str(s);
            return /^(string|number)$/.test(typeof s) ? "'" + s + "'" : s;
        }
        for (var i in o) arr.push("'" + i + "':" + fmt(o[i]));
        return '{' + arr.join(',') + '}';
    }

    //获取Hid
    CurrentLib.GetHid = function () {
        if (common.getBrowserType() != 'IE') {
            top.dialog.msg('该功能仅支持IE11浏览器');
            return null;
        }
        if (common.getIEBrowserVersion() != '11') {
            top.dialog.msg('该功能仅支持IE11浏览器');
            return null;
        }
        var Ry;
        var handle;
        var ret;
        Ry = document.getElementById("uKey");
        Ry.pid = UkeyPid;
        //寻找key
        ret = Ry.Don_FindToken();
        if (ret == 0) {
            //打开key
            var opentoken = Ry.Don_OpenToken();
            if (opentoken == 0) {
                Ry.DataLen = 120;
                Ry.Offset = 0;
                Ry.InData = 0;
                //读取key
                var readtoken = Ry.Don_ReadData();
                if (readtoken == 0) {
                    var hid = Ry.hid;
                    return hid;
                }
            }
            var closeResult = Ry.Don_CloseToken();
        }
        return '';
    }

    exports('ftukey', CurrentLib)
});
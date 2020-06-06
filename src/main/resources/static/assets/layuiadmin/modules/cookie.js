layui.define(function (exports) {

    function getCookie(key) {
        if (document.cookie.length > 0) {
            var cookieStart = document.cookie.indexOf(key + "=")
            if (cookieStart != -1) {
                cookieStart = cookieStart + key.length + 1
                var cookieEnd = document.cookie.indexOf(";", cookieStart)
                if (cookieEnd == -1) cookieEnd = document.cookie.length
                return unescape(document.cookie.substring(cookieStart, cookieEnd))
            }
        }
        return null;
    }

    function setCookie(key, value, expiredays) {
        var exdate = new Date()
        exdate.setDate(exdate.getDate() + expiredays)
        document.cookie = (key + "=" + escape(value) + ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString()));
    }

    exports('cookie', {
        getCookie: getCookie,
        setCookie: setCookie
    })
});
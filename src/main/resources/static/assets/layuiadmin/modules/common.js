/**

 @Name：layuiAdmin 公共业务
 @Author：贤心
 @Site：http://www.layui.com/admin/
 @License：LPPL

 */

layui.define(function (exports) {
    var $ = layui.$
        , layer = layui.layer
        , laytpl = layui.laytpl
        , setter = layui.setter
        , view = layui.view
        , admin = layui.admin

    //公共业务的逻辑处理可以写在此处，切换任何页面都会执行
    function refreshTree(treeId) {
        if (typeof (treeId) == 'undefined' || null == treeId || '' == treeId) {
            return;
        }
        var treeObj = $.fn.zTree.getZTreeObj(treeId);
        var nodes = treeObj.getSelectedNodes();
        var node;
        if (nodes && nodes.length > 0) {
            node = nodes[0];
        } else {
            node = treeObj.getNodeByParam("pId", -1, null);
        }
        if (node) {
            node.isParent = true;
            treeObj.reAsyncChildNodes(node, "refresh");
        }
    }

    /**
     * 计算剩余的ID列表
     * @param deleteIds
     * @param currentIds
     * @returns {string}
     */
    function resultIdsOfDeleteIds(deleteIds, currentIds) {
        var tempSelectGroupIds = [];
        for (var i = 0, currentId; currentId = currentIds[i++];) {
            var isDelete = false;
            for (var j = 0, deleteId; deleteId = deleteIds[j++];) {
                if (currentId == deleteId) {
                    isDelete = true;
                    break;
                }
            }
            if (!isDelete) {
                tempSelectGroupIds.push(currentId);
            }
        }
        var tempIds = '';
        for (var i = 0, currentId; currentId = tempSelectGroupIds[i++];) {
            if (tempIds.length > 0) {
                tempIds += '_';
            }
            tempIds += currentId;
        }
        return tempIds;
    }

    /**
     * 驼峰命名转小写
     * @param humpName
     * @param split 分隔符
     * @returns {string|string|*}
     */
    function humpNameToLower(humpName, split) {
        if (typeof (humpName) != 'string') {
            return humpName;
        }
        var splitStr = '';
        if (typeof (split) != 'undefined') {
            splitStr = split;
        }
        var tableFieldName = '';
        for (var i = 0, letter = humpName[i]; letter = humpName[i++];) {
            if (/[A-Z]/.test(letter)) {
                tableFieldName += splitStr;
                letter = letter.toLowerCase();
            }
            tableFieldName += letter;
        }
        return tableFieldName;
    }

    /**
     * 格式化时间
     * @param fmt
     * @param date
     * @returns {Cropper|void|string|*}
     */
    function formatDate(fmt, date) {
        var o = {
            "M+": date.getMonth() + 1,                 //月份
            "d+": date.getDate(),                    //日
            "h+": date.getHours(),                   //小时
            "m+": date.getMinutes(),                 //分
            "s+": date.getSeconds(),                 //秒
            "q+": Math.floor((date.getMonth() + 3) / 3), //季度
            "S": date.getMilliseconds()             //毫秒
        };
        if (/(y+)/.test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
        }
        for (var k in o) {
            if (new RegExp("(" + k + ")").test(fmt)) {
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
            }
        }
        return fmt;
    }

    /**
     * 浏览器类型
     * @returns {string}
     */
    function getBrowserType() {
        var userAgent = navigator.userAgent;
        var isOpera = userAgent.indexOf('Opera') > -1;
        // 欧朋
        if (isOpera) {
            return 'Opera';
        }
        // 火狐
        if (userAgent.indexOf('Firefox') > -1) {
            return 'FF';
        }
        // 谷歌
        if (userAgent.indexOf('Chrome') > -1) {
            return 'Chrome';
        }
        // Safari
        if (userAgent.indexOf('Safari') > -1) {
            return 'Safari';
        }
        // IE
        if (userAgent.indexOf('compatible') > -1 && userAgent.indexOf('MSIE') > -1 && !isOpera) {
            return 'IE';
        }
        if (userAgent.indexOf('Trident') > -1 && userAgent.indexOf("rv:11.0") > -1 && !isOpera) {
            return 'IE';
        }
        return 'none';
    }

    /**
     * 获取ID浏览器版本
     * @returns {string}
     */
    function getIEBrowserVersion() {
        var userAgent = navigator.userAgent;
        //判断是否IE<11浏览器
        var isIE = userAgent.indexOf('compatible') > -1 && userAgent.indexOf('MSIE') > -1;
        //判断是否IE的Edge浏览器
        var isEdge = userAgent.indexOf('Edge') > -1 && !isIE;
        var isIE11 = userAgent.indexOf('Trident') > -1 && userAgent.indexOf('rv:11.0') > -1;
        if (isIE) {
            var reIE = new RegExp('MSIE (\\d+\\.\\d+);');
            reIE.test(userAgent);
            var fIEVersion = parseFloat(RegExp['$1']);
            if (fIEVersion == 7) {
                return '7';
            } else if (fIEVersion == 8) {
                return '8';
            } else if (fIEVersion == 9) {
                return '9';
            } else if (fIEVersion == 10) {
                return '10';
            } else {
                //IE版本<=7
                return '6';
            }
        } else if (isEdge) {
            //edge
            return 'edge';
        } else if (isIE11) {
            //IE11
            return '11';
        }
        //不是ie浏览器
        return '-1';
    }

    /**
     * 获取导出数据的列
     * @param tableId
     * @returns {[]}
     */
    function listTableExportColumns(tableId) {
        var dataTableColumn = $('div[lay-id="' + tableId + '"] table thead tr th');
        var tableColumns = [];
        for (var i = 0, item; item = dataTableColumn[i++];) {
            var field = item.dataset.field;
            if (field == 0 || field === 'rowNum') {
                continue;
            }
            tableColumns.push(field);
        }
        var hideDataTableColumn = $('div[lay-id="' + tableId + '"] table thead tr th.layui-hide');
        var hideColumns = [];
        for (var i = 0, item; item = hideDataTableColumn[i++];) {
            var field = item.dataset.field;
            if (field == 0 || field === 'rowNum') {
                continue;
            }
            hideColumns.push(field);
        }
        // 导出的列
        var exportColumns = [];
        for (var i = 0, item; item = tableColumns[i++];) {
            var unExport = false;
            for (var j = 0, hideItem; hideItem = hideColumns[j++];) {
                if (item == hideItem) {
                    unExport = true;
                    break;
                }
            }
            if (!unExport) {
                exportColumns.push(item);
            }
        }
        // 去重
        for (var i = 0; i < exportColumns.length; i++) {
            var exportColumn = exportColumns[i];
            for (var j = i + 1; j < exportColumns.length; j++) {
                var item = exportColumns[j];
                if (exportColumn === item) {
                    exportColumns.splice(i, 1);
                    i--;
                    break;
                }
            }
        }
        return exportColumns;
    }

    //对外暴露的接口
    exports('common', {
        refreshTree: refreshTree,
        resultIdsOfDeleteIds: resultIdsOfDeleteIds,
        humpNameToLower: humpNameToLower,
        formatDate: formatDate,
        getBrowserType: getBrowserType,
        getIEBrowserVersion: getIEBrowserVersion,
        listTableExportColumns: listTableExportColumns
    });
});
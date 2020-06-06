var TextMessage = {
    loading: '加载中...',
    commit: '确定提交？',
    committing: '正在提交，请稍后...',
    commitSuccess: '提交成功，继续操作？',
    update: '确定更新？',
    updating: '正在更新，请稍后...',
    updated: '更新成功',
    updateSuccess: '更新成功，继续操作？',
    delete: '确定删除？',
    deleting: '删除中...',
    deleted: '删除成功',
    deleteSuccess: '删除成功',
    deleteUserConfirm: '请选择要删除的用户',
    deleteGroupConfirm: '请选择要删除的组',
    uploading: '正在上传...',
    bind: '确认绑定？',
    binding: '正在绑定...',
    bindSuccess: '绑定成功',
    button: {
        yes: '确定',
        no: '取消',
    },
    dialog: {
        save: '新增',
        update: '修改'
    },
    tree: {
        rootName: '基础节点'
    },
    table: {
        loading: '拼命加载中...',
        selectDelete: '请选择要删除的数据',
    }
}

function getBaseUrl() {
    return document.getElementsByTagName('base')[0].href;
}

function goPage(url) {
    window.location.href = getBaseUrl() + url;
}

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

function getContentHeight() {
    var windowHeight = $(window).height();
    var contentFrameHeight = windowHeight - 50;
    return contentFrameHeight;
}

function stopPaoPao() {
    window.event ? window.event.cancelBubble = true : e.stopPropagation();
}

/**
 * 更新树节点
 * @param treeId
 */
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
 * 更新table
 * @param tableId
 */
function refreshTable(tableId) {
    if (typeof (tableId) == 'undefined' || null == tableId || '' == tableId) {
        return;
    }
    $('#' + tableId).datagrid('reload');
}

/**
 * 更新树和表格
 * @param treeId
 * @param tableId
 */
function refreshTreeTable(treeId, tableId) {
    refreshTree(treeId);
    refreshTable(tableId);
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
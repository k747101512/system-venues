layui.define(function(exports) {

    var message = {
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
        unBindSuccess: '解绑成功',
        button: {
            yes: '确定',
            no: '取消',
        },
        dialog: {
            save: '新增',
            update: '修改'
        },
        tree: {
            rootName: '根节点'
        },
        table: {
            loading: '拼命加载中...',
            selectDelete: '请选择要删除的数据',
            selectEdit: '请选择要编辑的数据',
            selectOneEdit: '只能同时编辑一条数据',
            selectUnbind: '请选择要解除绑定的数据',
            selectBind: '请选择要执行绑定的数据',
            selectOn: '请选择要启用数据',
            selectOff: '请选择要停用数据',
            selectConfig: '请选择要配置数据',
            selectOneConfig: '请选择要配置一条数据',
            selectExamine: '请选择要审核数据',
        }
    }

    exports('datamessage', message);
});
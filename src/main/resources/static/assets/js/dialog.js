(function () {
    top.layer.config({
        skin: 'dialog-box'
    });
    var DialogBox = {
        dialogArray: [],
        dialogData: {},
        dialogTreeData: {
            apiUri: null,
            method: null,
            primaryKey: null,
            autoParams: null,
            otherParams: null,
            defaultParams: null,
            resultType: null,
            dataFilter: null,
            rootNode: null,
            data: null,
            check: null,
            selectedNodes: []
        },
        maxFileCount: null,
        close: function (index) {
            layer.close(index);
        },
        msg: function (msg, args, callback) {
            return layer.msg(msg, args, callback);
        },
        confirm: function (msg, callback) {
            var self = this;
            return top.layer.msg(msg, {
                time: 0,
                btn: ['确定', '取消'],
                shade: 0.3,
                yes: function (index) {
                    callback(index);
                },
                btn1: function () {
                    self.closeBox();
                }
            });
        },
        choiceConfirm: function (msg, yesCallback, noCallback) {
            var self = this;
            return top.layer.msg(msg, {
                time: 0,
                btn: ['是', '否', '取消'],
                shade: 0.3,
                btn1: function (index) {
                    yesCallback(index);
                },
                btn2: function (index) {
                    noCallback(index);
                },
                btn3: function () {
                    self.closeBox();
                }
            });
        },
        open: function (opt) {
            var self = this;
            var index = top.layer.open({
                type: 2,
                icon: 1,
                title: opt.title,
                shadeClose: false,
                maxmin: false,
                resize: false,
                shade: 0.3,
                area: [opt.width, opt.height],
                content: opt.url,
                cancel: function (index) {
                    self.closeBox();
                },
                end: opt.onClose
            });
            this.dialogArray.push(index);
            return index;
        },
        user: function (opt) {
            var self = this;
            var single = true;
            if (typeof (opt.single) == 'undefined' || opt.single == null || (opt.single != true && opt.single != false)) {
                single = false;
            } else {
                single = opt.single;
            }
            var selectedUserIds = '';
            if (typeof (opt.selectedUserIds) != 'undefined' && opt.selectedUserIds != null) {
                selectedUserIds = opt.selectedUserIds;
            }
            var index = top.layer.open({
                type: 2,
                icon: 1,
                title: opt.title,
                shadeClose: false,
                maxmin: false,
                closeBtn: 0,
                shade: 0.3,
                area: [opt.width, opt.height],
                content: 'route/user/departmentuser?single=' + single + '&selectedUserIds=' + selectedUserIds,
                cancel: function (index) {
                    self.closeBox();
                },
                end: opt.onClose
            });
            this.dialogArray.push(index);
            return index;
        },
        tree: function (opt) {
            var self = this;
            self.dialogTreeData.apiUri = opt.apiUri;
            if (typeof (opt.method) != 'undefined' && opt.method != null) {
                self.dialogTreeData.method = opt.method;
            } else {
                self.dialogTreeData.method = 'get';
            }
            if (typeof (opt.primaryKey) != 'undefined' && opt.primaryKey != null) {
                self.dialogTreeData.primaryKey = opt.primaryKey;
            } else {
                self.dialogTreeData.primaryKey = 'id';
            }
            if (typeof (opt.autoParams) != 'undefined' && opt.autoParams != null) {
                self.dialogTreeData.autoParams = opt.autoParams;
            } else {
                self.dialogTreeData.autoParams = ['id'];
            }
            if (typeof (opt.otherParams) != 'undefined' && opt.otherParams != null) {
                self.dialogTreeData.otherParams = opt.otherParams;
            } else {
                self.dialogTreeData.otherParams = {};
            }
            if (typeof (opt.resultType) != 'undefined' && opt.resultType != null) {
                self.dialogTreeData.resultType = opt.resultType;
            } else {
                self.dialogTreeData.resultType = 'justList';
            }
            if (typeof (opt.dataFilter) != 'undefined' && opt.dataFilter != null) {
                self.dialogTreeData.dataFilter = opt.dataFilter;
            } else {
                self.dialogTreeData.dataFilter = function (treeId, parentNode, childNodes) {
                    return childNodes;
                };
            }
            if (typeof (opt.rootNode) != 'undefined' && opt.rootNode != null) {
                self.dialogTreeData.rootNode = opt.rootNode;
            } else {
                self.dialogTreeData.rootNode = null;
            }
            if (typeof (opt.data) != 'undefined' && opt.data != null) {
                self.dialogTreeData.data = {};
                if (typeof (opt.data.checked) != 'undefined' && opt.data.checked != null) {
                    self.dialogTreeData.data.checked = opt.data.checked;
                } else {
                    self.dialogTreeData.data.checked = 'checked';
                }
                if (typeof (opt.data.children) != 'undefined' && opt.data.children != null) {
                    self.dialogTreeData.data.children = opt.data.children;
                } else {
                    self.dialogTreeData.data.children = 'children'
                }
                if (typeof (opt.data.isParent) != 'undefined' && opt.data.isParent != null) {
                    self.dialogTreeData.data.isParent = opt.data.isParent;
                } else {
                    self.dialogTreeData.data.isParent = 'isParent';
                }
                if (typeof (opt.data.name) != 'undefined' && opt.data.name != null) {
                    self.dialogTreeData.data.name = opt.data.name;
                } else {
                    self.dialogTreeData.data.name = 'name';
                }
                if (typeof (opt.data.title) != 'undefined' && opt.data.title != null) {
                    self.dialogTreeData.data.title = opt.data.title;
                } else {
                    self.dialogTreeData.data.title = 'title';
                }
            } else {
                self.dialogTreeData.data = {
                    checked: 'checked',
                    children: 'children',
                    isParent: 'isParent',
                    name: 'name',
                    title: 'title'
                }
            }
            if (typeof (opt.defaultParams) != 'undefined' && opt.defaultParams != null) {
                self.dialogTreeData.defaultParams = opt.defaultParams;
            } else {
                self.dialogTreeData.defaultParams = null;
            }
            if (typeof (opt.check) != 'undefined' && opt.check != null) {
                self.dialogTreeData.check = {};
                if (typeof (opt.check.enable) != 'undefined' && opt.check.enable != null) {
                    self.dialogTreeData.check.enable = opt.check.enable;
                } else {
                    self.dialogTreeData.check.enable = false;
                }
                if (typeof (opt.check.selectType) != 'undefined' && opt.check.selectType != null) {
                    self.dialogTreeData.check.chkStyle = opt.check.selectType;
                } else {
                    self.dialogTreeData.check.chkStyle = 'checkbox';
                }
                if (typeof (opt.check.checkboxType) != 'undefined' && opt.check.checkboxType != null) {
                    self.dialogTreeData.check.chkboxType = opt.check.checkboxType;
                } else {
                    self.dialogTreeData.check.chkboxType = {Y: 'ps', N: 'ps'};
                }
                if (typeof (opt.check.radioType) != 'undefined' && opt.check.radioType != null) {
                    self.dialogTreeData.check.radioType = opt.check.radioType;
                } else {
                    self.dialogTreeData.check.radioType = 'level';
                }
            } else {
                self.dialogTreeData.check = {
                    enable: false,
                    chkStyle: 'checkbox',
                    chkboxType: {Y: 'ps', N: 'ps'},
                    radioType: 'level',
                }
            }
            if (typeof (opt.selectedNodes) != 'undefined' && opt.selectedNodes != null) {
                self.dialogTreeData.selectedNodes = opt.selectedNodes;
            } else {
                self.dialogTreeData.selectedNodes = [];
            }
            var index = top.layer.open({
                type: 2,
                icon: 1,
                title: opt.title,
                shadeClose: false,
                maxmin: false,
                shade: 0.3,
                area: [opt.width, opt.height],
                content: top.restAjax.path('route/tree/tree', []),
                cancel: function (index) {
                    self.closeBox();
                },
                end: opt.onClose
            });
            this.dialogArray.push(index);
            return index;
        },
        // 文件上传
        file: function (opt) {
            var self = this;
            var fileType = opt.type;
            var url = 'route/file/uploadfile/';
            if (fileType == 'image') {
                url += '2';
            } else if (fileType == 'video') {
                url += '3';
            } else if (fileType == 'audio') {
                url += '4';
            } else {
                url += '1';
            }
            if (typeof (opt.maxFileCount) != 'undefined' && opt.maxFileCount != '') {
                self.maxFileCount = opt.maxFileCount;
            } else {
                self.maxFileCount = null;
            }
            self.dialogData.uploadFileArray = [];
            var index = top.layer.open({
                type: 2,
                icon: 1,
                title: opt.title,
                shadeClose: false,
                maxmin: false,
                shade: 0.3,
                area: [opt.width, opt.height],
                content: top.restAjax.path(url, []),
                cancel: function (index) {
                    self.closeBox();
                },
                end: opt.onClose
            });
            this.dialogArray.push(index);
            return index;
        },
        // 显示文件，图片和视频(MP4)
        showFile: function (opt) {
            var self = this;
            var showType = opt.type;
            var url = 'route/file/showfile/';
            if (showType == 'image') {
                url += 'image';
            } else if (showType == 'video') {
                url += 'video';
            }
            url += '/' + opt.fileId;
            var index = top.layer.open({
                type: 2,
                icon: 1,
                title: opt.title,
                shadeClose: false,
                maxmin: true,
                shade: 0.3,
                area: [opt.width, opt.height],
                content: top.restAjax.path(url, []),
                cancel: function (index) {
                    self.closeBox();
                },
            });
            this.dialogArray.push(index);
            return index;
        },
        closeBox: function () {
            top.layer.close(this.dialogArray[this.dialogArray.length - 1]);
            this.dialogArray.pop();
        }
    };
    var Mask = {
        showMask: function () {
            $(".mask").fadeIn(300);
            $("#loader").fadeIn(500);
        },
        hideMask: function () {
            $("#loader").fadeOut(300);
            $(".mask").fadeOut(500);
        }
    }

    window.DialogBox = DialogBox;
    window.Mask = Mask;
})();

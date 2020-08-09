// **********************************************//
// index 客户端脚本
// 
//
// @author Thunisoft
// @date 2020-07-24
// **********************************************//
var vm = new Vue({
    el: '#app',
    mixins: [atyTplMixin],
    data: function () {
        return {
            rs1: []
        }
    },
    methods: {
        /**
         *
         * @param queryInfo 查询信息
         */
        loadData: function (queryInfo) {
            var _this = this;
            Artery.loadPageData('/api/v1/ljxx/page', queryInfo).then(function (result) {
                _this.rs1 = result;
            }).catch(function (error) {
                console.error(error);
            });
        },
        /**
         *
         * @param event click事件
         */
        addSystem: function (event) {
            Artery.open({
                targetType: '_window',
                url: '/api/v1/ljxxForm',
                height: 280,
                width: 300,
                title: "添加系统",
                footerHide: false,
                onCancel: function (iframeId) {
                    modal.close();
                },
                onOk: function (iframeId) {
                    //可通过以下方式获取iframe的contentWindow来调用iframe内页面变量或方法
                    var iframeDom = document.getElementById(iframeId);
                    iframeDom.contentWindow.vm.submit();
                }
            });
        },
        viewPage:function (data) {
            Artery.open({
                targetType: '_window',
                url: '/api/v1/ljxxForm',
                params: data,
                height: 280,
                width: 300,
                title: "查看系统",
                footerHide: true
            });

        },
        editPage:function (data) {
            Artery.open({
                targetType: '_window',
                url: '/api/v1/ljxxForm',
                params: data,
                height: 280,
                width: 300,
                title: "添加系统",
                footerHide: false,
                onCancel: function (iframeId) {
                    modal.close();
                },
                onOk: function (iframeId) {
                    //可通过以下方式获取iframe的contentWindow来调用iframe内页面变量或方法
                    var iframeDom = document.getElementById(iframeId);
                    iframeDom.contentWindow.vm.submit();
                }
            });
            
        },
        del:function (bh) {
            var _this = this;
            $http.delete('api/v1/ljxx/' + bh)
                .then(function (result) {
                    if (result == 1) {
                        Artery.message.info("删除成功");
                        _this.$refs.ljxxForm.reloadData({offset: 0});
                    } else {
                        Artery.message.error(result);
                    }
                }).catch(function (error) {
                Artery.message.error(error.message);
            });
            
        }

    }
});
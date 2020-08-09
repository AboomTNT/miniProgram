// **********************************************//
// ljxxForm 客户端脚本
// 
//
// @author Thunisoft
// @date 2020-07-28
// **********************************************//
var vm = new Vue({
    el: '#app',
    mixins: [atyTplMixin],
    data: function () {
        return {
			formData: formData,
            rules: {
                name: [{
                    required: true,
                    message: '系统名称不能为空',
                    trigger: 'blur'
                }],
                address: [{
                    required: true,
                    message: '系统地址不能为空',
                    trigger: 'blur'
                }],
                describe: [{
                    required: true,
                    message: '系统说明不能为空',
                    trigger: 'blur'
                }],
                place: [{
                    required: true,
                    message: '所属地区不能为空',
                    trigger: 'blur'
                }],
                state: [{
                    required: true,
                    message: '环境标识不能为空',
                    trigger: 'blur'
                }],
            }

        }
    },
    methods: {
		
		submit: function () {

			this.$refs.addForm.submit('/api/v1/ljxx')
				.then(function (result) {
                    if (result == 1) {
                        parent.Artery.close();
                        parent.Artery.message.info("添加成功");
                        parent.vm.$refs.ljxxForm.reloadData({offset: 0});
                    } else if(result == 3){
                        parent.Artery.close();
                        parent.Artery.message.info("修改成功");
                        parent.vm.$refs.ljxxForm.reloadData({offset: 0});
                    } else {
                        Artery.message.error(result);
                    }
				}).catch(function (error) {
						Artery.message.error(error.message);

			})

		}
	}
});
// pages/edit_information/edit_information.js
import WeCropper from '../we-cropper/we-cropper.js'
var formdata;
Page({

    /**
     * 页面的初始数据
     */
    data: {
      initialAvater:'',
      user:{},
      avater: '',
      address:'',
        name: '',
        gender: '',
        birthday:'',
        identity: '',
        phone: '',
        wx: '',
        describe: '',
      identityList: ['摄影师', '模特'],
      identityIndex: 0,
        genderList: ['男', '女'],
        genderIndex: 0,
        region: ["贵州省", "贵阳市", "观山湖区"],
       
    },
  onLoad(options) {
    this.setData({
      user: JSON.parse(options.user)
    })
    this.setData({
      address: this.data.user.userAddress,
      birthday: this.data.user.userBirthday,
      avater:'http://localhost:8080/miniprogram/images/'+this.data.user.userAvater,
      gender: this.data.user.userGender,
      identity: this.data.user.userIdentity,
      wx: this.data.user.userWx,
      phone:this.data.user.userPhone,
      name:this.data.user.userName,
      describe:this.data.user.userDescribe ,
      initialAvater:this.data.user.userAvater
    });
  },
    changeGender(e) {
        this.setData({ genderIndex: e.detail.value });
        this.setData({ gender: this.data.genderList[this.data.genderIndex] });
        console.log(this.data.gender)
    },
    changeRegin(e) {
        this.setData({ region: e.detail.value });
        this.setData({address:this.data.region[1]})
    },
    changeIdentity(e) {
        this.setData({ identityIndex: e.detail.value });
        this.setData({ identity: this.data.identityList[this.data.identityIndex] })
        console.log(this.data.identity)
    },
    changeDate(e) {
        this.setData({ birthday: e.detail.value });
    },
    inputName: function(e) {
        this.setData({ name: e.detail.value });
    },
    chooseImage: function() {
        wx.chooseImage({
            count: 1, //选择数量
            sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: function(res) {
                // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
                const src = res.tempFilePaths[0]
                wx.navigateTo({
                    url: '../cropper/cropper?src='+src,
                })
            },
        })  
    },
  formSubmit:function(e){
    console.log(e);
    formdata=e.detail.value;
    var that=this;
    var temp = "http://localhost:8080/miniprogram/images/"+this.data.initialAvater
    if(this.data.avater!=temp){
      wx.uploadFile({
        url: 'http://localhost:8080/miniprogram/dynamic/uploadFiles',
        filePath: that.data.avater,
        name: 'img',
        success(res) {
          var img = res.data;
          var data = formdata;
          data["img"] = img;
          wx.getStorage({
            key: 'cookie',
            success: function (cookie) {
              wx.request({
                url: 'http://localhost:8080/miniprogram/user/updateUser',
                method: 'POST',
                data: {
                  user: JSON.stringify(data)
                },
                header: {
                  "Content-Type": "application/x-www-form-urlencoded",
                  'cookie': 'JSESSIONID=' + cookie.data.data // 设置cookie
                },
                success: function (res1) {
                  wx.showToast({
                    title: '保存成功！',
                  })
                }
              })
            },
          })


        }
      })
    }
    else{
      var img = this.data.initialAvater;
      var data = formdata;
      data["img"] = img;
      wx.getStorage({
        key: 'cookie',
        success: function (cookie) {
          wx.request({
            url: 'http://localhost:8080/miniprogram/user/updateUser',
            method: 'POST',
            data: {
              user: JSON.stringify(data),
              
            },
            header: {
              "Content-Type": "application/x-www-form-urlencoded",
              'cookie': 'JSESSIONID=' + cookie.data.data // 设置cookie
            },
            success: function (res1) {
              wx.showToast({
                title: '保存成功！',
              })
            }
          })
        },
      })
    }
    
  }

})
//index.js
//获取应用实例

const app = getApp()

Page({
  query:{

  },
  data: {
    motto: 'Hello World',
    userInfo: {
      nickName:'',
      avaterUrl:''
    },
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  toIndex:function(){
    app.toIndex();
  },
  
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse){
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
  agree:function(){
    // wx.login({
    //   //获取code
    //   success: function (res) {
    //     var code = res.code; //返回code
    //     console.log(code);
    //     var appId = 'wx047e074b0a7b081d';
    //     var secret = 'c97d3c57eb149cbe31887b9a62b0f271';
    //     wx.request({
    //       url: 'https://api.weixin.qq.com/sns/jscode2session?appid=' + appId + '&secret=' + secret + '&js_code=' + code + '&grant_type=authorization_code',
    //       data: {},
    //       header: {
    //         'content-type': 'json'
    //       },
    //       success: function (res) {
    //         var openid = res.data.openid //返回openid
    //         console.log('openid为' + openid);
    //         wx.request({
    //           url: 'http://localhost:8080/miniprogram/user/userById',
    //           data:{
    //             openid
    //           },
    //           success:function(res){
    //             if(res==1)
    //             app.toIndex();
    //             else{
    //             app.toIndex();
    //             }
    //           }
    //         })
    //       }
    //     })
    //   }
    // })
    wx.request({
      url: 'http://localhost:8080/miniprogram/user/login',
      data:{
        id:'1001'
      },
      success:function(result){
        wx.setStorage({
          key: 'cookie',
          data: result, // 从返回数据的响应头中取cookie
          success: (result) => {
            console.log(result);
            app.toIndex();
          }
        })
      }
    })
  }
})

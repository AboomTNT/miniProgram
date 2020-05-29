// pages/user_index/user_index.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
      attention:'',
      loginUserId:'',
      follow:0,
      followed:0,
      user:{},
      dynamics:[],
      works:[],
      tabs: [{
                id: 0,
                name: "约拍动态",
                isActive: true
            },
            {
                id: 1,
                name: "作品相册",
                isActive: false
            }
        ]
    },
    changeAttention:function(){
      var that=this;
      if(this.data.user.userId==this.data.loginUserId){
        wx.showToast({
          title: '不能关注自己哦~',
          icon:'none'
        })
      }
      else if(this.data.attention=='已关注'){
        this.setData({attention:'关注'})
        wx.request({
          url: 'http://localhost:8080/miniprogram/follow/deleteFollow',
          data:{
            loginId: that.data.loginUserId,
            id:that.data.user.userId
          },
          success:function(res){
            if(res){
              wx.showToast({
                title: '取消关注成功',
              })
            }
          }
        })
      }
      else{
        this.setData({attention:'已关注'});
        wx.request({
          url: 'http://localhost:8080/miniprogram/follow/insertFollow',
          data: {
            loginId: that.data.loginUserId,
            id: that.data.user.userId
          },
          success: function (res) {
            if (res) {
              wx.showToast({
                title: '关注成功',
              })
            }
          }
        })
      }
    },
    toSpecificContent:function(e){
      var avater = this.data.user.userAvater;
      var dynamic = e.currentTarget.dataset.dynamic;
      dynamic['userAvater'] = avater;
      dynamic['userName']=this.data.user.userName;
      dynamic['userAddress']=this.data.user.userAddress;
      dynamic['userIdentity']=this.data.user.userIdentity
      var finalDynamic = JSON.stringify(dynamic);
      wx.navigateTo({
        url: '../specific_content/specific_content?dynamic=' + finalDynamic,
      })
    },
    toSpecificGallery: function (e) {
      var data=this.data.user;
      data["work"] = e.currentTarget.dataset.work;
      data= JSON.stringify(data)
    wx.navigateTo({
      url: '../specific_gallery/specific_gallery?data=' + data,
    })
  },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function(options) {
      var userId=options.userId
      var that=this;
      wx.getStorage({
        key: 'cookie',
        success: function(cookie) {
          wx.request({
            url: 'http://localhost:8080/miniprogram/user/userInfoById',
            header: ({
              'Content-Type': 'application/json',
              'cookie': 'JSESSIONID=' + cookie.data.data 
            }),
            data: {
              userId: userId
            },
            success: function (res) {
              console.log(res);

              if (res) {
                that.setData({
                  user: res.data.user,
                  works: res.data.works,
                  dynamics: res.data.dynamics,
                  follow: res.data.follow,
                  followed: res.data.followed,
                  loginUserId: res.data.loginUserId,
                })
                if (res.data.isFollow == 0) {
                  that.setData({ attention: "关注" })
                }
                else{that.setData({attention:"已关注"})}
                var imgs; var imgs1; var style; var style1; var area; var area1;
                for (var i = 0; i < that.data.dynamics.length; i++) {
                  imgs = "dynamics[" + i + "].dynamicImg";
                  imgs1 = JSON.parse(that.data.dynamics[i].dynamicImg);
                  style = "dynamics[" + i + "].dynamicStyle";
                  style1 = JSON.parse(that.data.dynamics[i].dynamicStyle);
                  area = "dynamics[" + i + "].dynamicArea";
                  area1 = JSON.parse(that.data.dynamics[i].dynamicArea);
                  that.setData({
                    [imgs]: imgs1,
                    [style]: style1,
                    [area]: area1
                  })
                }
                var imgs2; var imgs3;
                for (var i = 0; i < that.data.works.length; i++) {
                  imgs2 = "works[" + i + "].worksImg";
                  imgs3 = JSON.parse(that.data.works[i].worksImg);
                  that.setData({
                    [imgs2]: imgs3
                  })
                }
              }
            }
          })
        },
      })
     
    },
    deleteDynamic:function(e){
      var that=this;
      console.log(e);
      wx.showModal({
        title: '是否确认删除',
        success: function (res) {
          if (res.confirm) {
            wx.request({
              url: 'http://localhost:8080/miniprogram/dynamic/deleteDynamic',
              data: {
                dynamicId: e.currentTarget.dataset.dynamic.dynamicId
              },
              success: function (res) {
                if (res) {
                  wx.showToast({
                    title: '删除成功',
                  })
                  wx.navigateTo({
                    url: '../user_index/user_index?userId=' + that.data.user.userId,
                  })
                }
                else {
                  wx.showToast({
                    title: '删除失败',
                    icon: 'none'
                  })
                }
              }
            })
          } 

        }
      })
      
    },
  deleteWork: function (e) {
    console.log(e.currentTarget.dataset);
    var that = this;
    wx.showModal({
      title: '是否确认删除',
      success: function (res) {
        if (res.confirm) {
          
          wx.request({
            url: 'http://localhost:8080/miniprogram/work/deleteWork',
            data: {
              workId: e.currentTarget.dataset.work.worksId
            },
            success: function (res) {
              if (res) {
                wx.showToast({
                  title: '删除成功',
                })
                wx.navigateTo({
                  url: '../user_index/user_index?userId='+that.data.user.userId,
                })
              }
              else {
                wx.showToast({
                  title: '删除失败',
                  icon: 'none'
                })
              }
            }
          })
        } 

      }
    })
   
    
  },
    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function() {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function() {

    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function() {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function() {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function() {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function() {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function() {

    },
    handleItemChange(e) {
        const { index } = e.detail;
        let { tabs } = this.data;
        tabs.forEach((v, i) => i === index ? v.isActive = true : v.isActive = false);
        this.setData({ tabs });
    }
})
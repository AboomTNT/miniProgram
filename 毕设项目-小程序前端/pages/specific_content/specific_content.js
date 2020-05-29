// pages/specific_content/specific_content.js
Page({
  data:{
    dynamic:{},
    url:'http://localhost:8080/miniprogram'
  },
  toAppointment:function(){
    var dynamic = JSON.stringify(this.data.dynamic)
    wx.navigateTo({
      url: '../appointment/appointment?dynamic='+dynamic,
    })
  },
    toIndex: function(e) {
        wx.switchTab({ url: "/pages/index01/index01" });
    },
    /**
     * 页面的初始数据
     */
    data: {
    },
    toUserIndex: function() {
      var that=this;
      wx.navigateTo({
        url: '../../pages/user_index/user_index?userId=' + that.data.dynamic.dynamicUserid
      })
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function(options) {
      var dynamic = JSON.parse(options.dynamic);
      this.setData({
        dynamic: dynamic
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

    }
})
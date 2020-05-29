// pages/specific_appointment/specific_appointment.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
      url: 'http://localhost:8080/miniprogram',
      appointment:{},
      phone:'',
      wx:''
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function(options) {
      var that=this;
      var appointment = JSON.parse(options.appointment);
      wx.request({
        url: 'http://localhost:8080/miniprogram/user/selectContact',
        data:{
          id: appointment.appointmentUserid1
        },
        success:function(res){
          console.log(res);
          that.setData({
            phone:res.data.userPhone,
            wx:res.data.userWx
          })
        }
      })
      that.setData({
        appointment: appointment
      })
    },
  toSpecificContent:function(){
    var that=this;
    wx.request({
      url: 'http://localhost:8080/miniprogram/dynamic/selectDynamicById',
      data:{
        dynamicId: that.data.appointment.appointmentFromid
      },
      success:function(res){
        console.log(res);
        var dynamic=JSON.stringify(res.data);
        wx.navigateTo({
          url: '../specific_content/specific_content?dynamic='+dynamic,
        })
      }
    })
  },
  agree:function(){
    var that=this;
    wx.request({
      url: 'http://localhost:8080/miniprogram/appointment/appointmentReply',
      data:{
        appointmentId: that.data.appointment.appointmentId,
        status:1
      },
      success:function(res){
        if(res){
          wx.showToast({
            title: '已同意',
          })
        }
      }
    })
  },
  refuse: function () {
    wx.request({
      url: 'http://localhost:8080/miniprogram/appointment/appointmentReply',
      data: {
        appointmentId: that.data.appointment.appointmentId,
        status: 2
      },
      success: function (res) {
        if (res) {
          wx.showToast({
            title: '已拒绝',
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

    }
})
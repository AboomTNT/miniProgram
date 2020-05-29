// pages/send_appointment/send_appointment.js
import { request } from "../../utils/util.js"
import regeneratorRuntime from '../../lib/regenerator-runtime/runtime'
Page({

    /**
     * 页面的初始数据
     */
    data: {
      appointmentsList: []
    },
    
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function(options) {
    var that = this;
    this.getReceivedList();
  },
  async getReceivedList() {
    var that = this;
    wx.getStorage({
      key: 'cookie',
      success: function (cookie) {
        console.log(cookie);
        wx.request({
          url: 'http://localhost:8080/miniprogram/appointment/selectSendApt',
          method: 'GET',
          header: {
            'Content-Type': 'application/json',
            'cookie': 'JSESSIONID=' + cookie.data.data // 设置cookie
          },
          success: function (res) {
            console.log(res);
            that.setData({
              appointmentsList: res.data
            })
          }
        })

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
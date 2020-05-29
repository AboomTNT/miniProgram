// pages/appointment/appointment.js
import { request } from "../../utils/util.js"
import regeneratorRuntime from '../../lib/regenerator-runtime/runtime'
var formData;
Page({

  /**
   * 页面的初始数据
   */
  data: {
    wx:'',
    phone:'',
    dynamic:{}
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var dynamic=JSON.parse(options.dynamic)
    this.setData({
      dynamic:dynamic
    })
    this.getPhoneWx();
  },
  getPhoneWx:function() {
    var that=this;
    wx.getStorage({
      key: 'cookie',
      success: function (cookie) {
        console.log(cookie);
        wx.request({
          url: 'http://localhost:8080/miniprogram/user/selectContact',//实际接口    
          method: 'GET',
          header: {
            'Content-Type': 'application/json',
            'cookie': 'JSESSIONID=' + cookie.data.data // 设置cookie
          },
          success: function (res) {
            console.log(res);
            that.setData({
              wx:res.data.userPhone,
              phone:res.data.userPhone
            })
          }
        })
      },
    })
  },
  formSubmit:function(e){
    var that=this;
    formData=e.detail.value;
   console.log(formData);
    if(e.detail.value.reason==''){
      wx.showToast({
        title: '请输入约拍理由',
        icon:'none'
      })
    }
    else{
      wx.getStorage({
        key: 'cookie',
        success: function (cookie) {
          console.log(cookie);
           wx.request({
              url: 'http://localhost:8080/miniprogram/appointment/insertAppointment',
              method: 'GET',
              data:{
                id:that.data.dynamic.dynamicUserid,
                appointment:formData,
                dynamicId:that.data.dynamic.dynamicId
              },
              header:{
                 'Content-Type': 'application/json',
                 'cookie': 'JSESSIONID=' + cookie.data.data // 设置cookie
              },
              success: function (res) {
                console.log(res);
                if(res.data==1){
                  wx.showToast({
                    title: '发布成功',
                    success:function(res){
                      wx.switchTab({
                        url: '../index01/index01',
                      })
                    }
                  })
                  
                }
                else if(res.data==0){
                  wx.showToast({
                    title: '不能约拍自己哦~',
                    icon:'none'
                  })
                }
                else{
                  wx.showToast({
                    title: '你已经对这条动态约拍过了哦~',
                    icon:'none'
                  })
                }
              }
           })
        }
      })
    }
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})
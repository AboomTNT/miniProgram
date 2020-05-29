// pages/specific_gallery/specific_gallery.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    style:[],
    work:{},
    avater:'',
    name: '',
    gender: '',
    identity: '',
  },
  /**
   * 生命周期函数--监听页面加载
   */
  
 
  
  onLoad: function (options) {
    var that=this;
    console.log(options.data);
    var data=JSON.parse(options.data);
    console.log(data)
    this.setData({
      work:data.work,
      avater:data.userAvater,
      name:data.userName,
      gender:data.userGender,
      identity:data.userIdentity,
    })
    this.setData({
      style:JSON.parse(that.data.work.worksStyle)
    })
  },
  toUserIndex: function () {
    app.toUserIndex();
  },
  toIndex:function(){
    app.toIndex();
  },
  toAppointment:function(){
    app.toAppointment();
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
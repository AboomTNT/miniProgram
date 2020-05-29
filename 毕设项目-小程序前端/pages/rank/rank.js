// pages/rank/rank.js
import { request } from "../../utils/util.js"
import regeneratorRuntime from '../../lib/regenerator-runtime/runtime'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    url: 'http://localhost:8080/miniprogram/images',
    dynamicsList: [],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onPullDownRefresh: function () {
    var that = this;
    // that.setData({
    //   currentTab: 0 //当前页的一些初始数据，视业务需求而定
    // })
    this.onLoad(); //重新加载onLoad()
  },
  onLoad: function (options) {
    var that = this;
    this.getDynamicsList();
  },
  async getDynamicsList() {
    var that = this;
    const res = await request({ url: "http://localhost:8080/miniprogram/dynamic/selectDynamicByNum" });
    console.log(res);
    // console.log(JSON.parse(res.data.dynamicList));
    this.setData({
      dynamicsList: res.data
    })

    var area1; var area; var style; var style1; var img; var img1;
    for (var i = 0; i < that.data.dynamicsList.length; i++) {
      area = "dynamicsList[" + i + "].dynamicArea";
      area1 = JSON.parse(that.data.dynamicsList[i].dynamicArea);
      style = "dynamicsList[" + i + "].dynamicStyle";
      style1 = JSON.parse(that.data.dynamicsList[i].dynamicStyle);
      img = "dynamicsList[" + i + "].dynamicImg";
      img1 = JSON.parse(that.data.dynamicsList[i].dynamicImg);
      that.setData({
        [area]: area1,
        [style]: style1,
        [img]: img1
      })
    }
    console.log(that.data.dynamicsList);
  },
  toSpecificContent: function (e) {
    var dynamic = JSON.stringify(e.currentTarget.dataset.dynamic);
    wx.navigateTo({
      url: '../../pages/specific_content/specific_content?dynamic=' + dynamic,
    })

  },
})
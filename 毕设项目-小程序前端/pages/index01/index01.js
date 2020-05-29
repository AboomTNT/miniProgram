// pages/index01/index01.js
import { request } from "../../utils/util.js"
import regeneratorRuntime from '../../lib/regenerator-runtime/runtime'
var flag=0;
Page({
    data: {
      url:'http://localhost:8080/miniprogram/images',
      dynamicsList:[],
        // 筛选项初始化
        address:"全国",
        region:['','',''],
        gender: '性别',
        identity:'约拍对象',
        style:"风格",
        identityList: ['摄影师', '模特'],
        identityIndex: 0,
        genderList: ['男', '女'],
        genderIndex: 0,
        styleList: ['情侣', '商务', '古风', '婚礼', '儿童', '校园', '复古', '日系', '胶片', '二次元', '清新', '孕照', '暗黑', '闺蜜'],
        styleIndex: 0,
    },

    //用户主页
    toUserIndex: function(e) {
      var that=this;
        wx.navigateTo({
          url: '../../pages/user_index/user_index?userId=' + e.currentTarget.dataset.user.dynamicUserid
        })
    },

  //onload
  onLoad: function (options) {
    var that=this;
    if(flag==2){
      this.setData({
        address: "全国",
        gender: '性别',
        identity: '约拍对象',
        style: "风格",
      })
      that.getDynamicsList();
    }
    
    if (flag == 0) {
      this.getDynamicsList();
    }
  },

    //按tag筛选动态
  chooseDynamic:function(e){
    var that=this;
    console.log(that.data.address);
    wx.request({
      url: 'http://localhost:8080/miniprogram/dynamic/selectDynamicsByTags',
      data:{
        region:that.data.address,
        identity:that.data.identity,
        gender:that.data.gender,
        style:that.data.style
      },
      header: { "Content-Type": "application/x-www-form-urlencoded" },
      method:'POST',
      success:function(res){
        console.log(res);
       that.setData({
         dynamicsList: res.data
       })
       that.solveArray();
       flag=1;
       that.onLoad();
      }
    })
  },
  //下拉刷新
  onPullDownRefresh: function () {
    var that = this;
    flag=2;
    this.onLoad(); //重新加载onLoad()
  },

//全部动态
  async getDynamicsList(){
    var that=this;
    const res = await request({ url: "http://localhost:8080/miniprogram/dynamic/selectAllDynamics" });
    console.log(res);
    this.setData({
      dynamicsList: res.data.dynamicList
    })
    that.solveArray();
    console.log(that.data.dynamicsList);
  },

  //处理dynamic中的json字符串
  solveArray:function(){
    var that=this;
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
  },

  //动态详情
  toSpecificContent:function(e){
    var dynamic = JSON.stringify(e.currentTarget.dataset.dynamic);
    wx.navigateTo({
      url: '../../pages/specific_content/specific_content?dynamic=' + dynamic,
    })

  },
    // 筛选函数
    changeRegin(e) {
        this.setData({ region: e.detail.value });
        this.setData({address:this.data.region[1]});
        this.chooseDynamic();
    },
    changeIdentity(e) {
        this.setData({ identityIndex: e.detail.value });
        this.setData({identity:this.data.identityList[this.data.identityIndex]});
      this.chooseDynamic();
    },
    changeGender(e) {
        this.setData({ genderIndex: e.detail.value });
        this.setData({gender:this.data.genderList[this.data.genderIndex]});
      this.chooseDynamic();

    },
    changeStyle(e) {
        this.setData({ styleIndex: e.detail.value });
        this.setData({style:this.data.styleList[this.data.styleIndex]});
      this.chooseDynamic();
    },
    
})
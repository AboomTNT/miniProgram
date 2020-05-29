// pages/publish_gallery/publish_gallery.js
var util = require("../../utils/util.js")
var formdata;
Page({

    /**
     * 页面的初始数据
     */
    data: {
      files: [],
      equipment:'',
      address:'',
        switchChecked: true,
        isChecked: true,
        banner: [],
        styleList: [
          { name: "情侣", value: '0', checked: false },
          { name: "商务", value: '1', checked: false },
          { name: "古风", value: '2', checked: false },
          { name: "婚礼", value: '3', checked: false },
          { name: "儿童", value: '4', checked: false },
          { name: "校园", value: '5', checked: false },
          { name: "复古", value: '6', checked: false },
          { name: "日系", value: '7', checked: false },
          { name: "胶片", value: '8', checked: false },
          { name: "二次元", value: '9', checked: false },
          { name: "清新", value: '10', checked: false },
          { name: "孕照", value: '11', checked: false },
          { name: "暗黑", value: '12', checked: false },
          { name: "闺蜜", value: '13', checked: false }
        ]
    },
    switchChange: function(e) {
        console.log(e.detail.value);
    },
    chooseImage: function() {
        var that = this;
        wx.chooseImage({
            count: 9,
            sizeType: ['original', 'compressed'],
            sourceType: ['album', 'camera'],
            success(res) {
                // // tempFilePath可以作为img标签的src属性显示图片
                // const tempFilePaths = res.tempFilePaths
                // success
                console.log(res.tempFilePaths);
                if (res.tempFilePaths.count == 0) {
                    return;
                }
                var imgArrNow = that.data.banner;
                imgArrNow = imgArrNow.concat(res.tempFilePaths);
                that.setData({
                    banner: imgArrNow
                })
              that.upload();
              that.chooseViewShowBanner();
            },
            fail: function() {
                // fail
            },
            complete: function() {
                // complete
            }
        })
    },
  upload: function () {
    var that = this;
    wx.uploadFile({
      url: 'http://localhost:8080/miniprogram/dynamic/uploadFiles',
      filePath: that.data.banner[that.data.banner.length - 1],
      name: 'img',
      success(res) {
        console.log(res.data);
        var res1 = res
        var imgArrNow = that.data.files;
        imgArrNow = imgArrNow.concat(res1.data);
        that.setData({
          files: imgArrNow
        })
        // that.setData({
        //   files:res1.data
        // })
      }
    })
  },
  formSubmit: function (e) {
    var that = this;
    //console.log(that.data.files);
    // this.upload(callback);
    // console.log(files);
    formdata = e.detail.value;
    console.log(formdata);

    if (e.detail.value.describe=='') {
      wx.showToast({
        title: '请填写完整',
        icon:'none'
      })
    }
    else if (this.data.banner.length == 0) {
      wx.showToast({
        title: '请选择图片',
      })
    }
    else {
      wx.getStorage({
        key: 'cookie',
        success: function (cookie) {
          console.log(cookie);
          wx.request({
            url: 'http://localhost:8080/miniprogram/work/insertwork',//实际接口    
            data: {
              gallery: formdata,
              img: that.data.files,

            },
            method: 'GET',
            header: {
              'Content-Type': 'application/json',
              'cookie': 'JSESSIONID=' + cookie.data.data // 设置cookie
            },
            success: function (res) {
              console.log(res.data);
              if (res==1) {
                wx.showToast({
                  title: '发布成功',
                })
                wx.switchTab({
                  url: '../index01/index01',
                })
              }
            }
          })
        },
      })

    }
  },
    previewImg: function(e) {
        var current = e.target.dataset.src;
        wx.previewImage({
            urls: this.data.imgs,
            current: current,
            fail: (res) => {},
            success: (res) => {},
        })
    },
    /** 删除图片Banner */
    deleteImvBanner: function(e) {
        var banner = this.data.banner;
        var itemIndex = e.currentTarget.dataset.id;
        banner.splice(itemIndex, 1);
        this.setData({
                banner: banner
            })
            //判断是否隐藏选择图片
        this.chooseViewShowBanner();
    },


    /** 是否隐藏图片选择Banner*/
    chooseViewShowBanner: function() {
        if (this.data.banner.length >= 2) {
            this.setData({
                chooseViewShowBanner: false
            })
        } else {
            this.setData({
                chooseViewShowBanner: true
            })
        }
    },

    /** 查看大图Banner */
    showImageBanner: function(e) {
        var banner = this.data.banner;
        var itemIndex = e.currentTarget.dataset.id;
        wx.previewImage({
            current: banner[itemIndex], // 当前显示图片的http链接
            urls: banner // 需要预览的图片http链接列表
        })
    },
  clicks: function (e) {
    let index = e.currentTarget.dataset.index;
    let arrs = this.data.styleList;
    if (arrs[index].checked == false) {
      arrs[index].checked = true;
    } else {
      arrs[index].checked = false;
    }
    this.setData({
      styleList: arrs
    })
  },
    changeClass: function(e) {
        const { index } = e.currentTarget.dataset;
        let { styleList } = this.data;
        styleList[index].isChecked = true;
        this.setData({
            styleList
        })
    }
})
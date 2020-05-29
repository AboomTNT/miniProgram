import WeCropper from '../we-cropper/we-cropper.js'

const device = wx.getSystemInfoSync() //获取设备信息
const width = device.windowWidth // 示例为一个与屏幕等宽的正方形裁剪框
const height = device.windowHeight - 50
Page({
    data: {
        imgSrc: '', //确定裁剪后的图片;
        cropperOpt: {
            id: 'cropper',
            width: width,
            height: height,
            scale: 2.5,
            zoom: 8,
            cut: { //裁剪框x,y轴起点，高，宽
                x: (width - 300) / 2,
                y: (height - 300) / 2,
                width: 300,
                height: 300
            }
        }
    },
    //裁剪的拖动
    touchStart(e) {
        this.wecropper.touchStart(e)
    },
    touchMove(e) {
        this.wecropper.touchMove(e)
    },
    touchEnd(e) {
        this.wecropper.touchEnd(e)
    },
   
  onLoad: function (options) {
    const {
      cropperOpt
    } = this.data;
    cropperOpt.src = options.src;
    if (cropperOpt.src) {
      this.cropper = new WeCropper(cropperOpt)
        .on('ready', (ctx) => {
          console.log(`wecropper is ready for work!`)
        })
        .on('beforeImageLoad', (ctx) => {
          wx.showToast({
            title: '上传中',
            icon: 'loading',
            duration: 3000
          })
        })
        .on('imageLoad', (ctx) => {
          wx.hideToast()
        })
    }
  },
  uploadTap() {
    const self = this
    wx.chooseImage({
      count: 1, // 默认9
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success(res) {
        const src = res.tempFilePaths[0]
        self.cropper.pushOrign(src)
      }
    })
  },

  // 生成图片
  getCropperImage(){
        this.cropper.getCropperImage(tempFilePath => {
    // tempFilePath 为裁剪后的图片临时路径
    if (tempFilePath) {
      // 拿到裁剪后的图片路径的操作
      console.log(tempFilePath);
      var flag=1;
      // wx.navigateBack({
      //   url: '../edit_information/edit_information?src=' + tempFilePath+"&flag="+flag,
      // })
      var pages=getCurrentPages();
      var pages = getCurrentPages();
      var currPage = pages[pages.length - 1];
      var prevPage = pages[pages.length - 2];     //获取上一个页面
      prevPage.setData({
        avater:tempFilePath
      })
      wx.navigateBack();
    } 
    else {
      console.log('获取图片地址失败，请稍后重试')
    }
  })
}
    // onLoad: function(options) {
    //     const { cropperOpt } = this.data
    //     this.cropper = new WeCropper(cropperOpt)
    //         .on('ready', (ctx) => {
    //             console.log(`wecropper is ready for work!`)
    //         })
    //         .on('beforeImageLoad', (ctx) => {
    //             console.log(`before picture loaded, i can do something`)
    //             console.log(`current canvas context:`, ctx)
    //             wx.showToast({
    //                 title: '上传中',
    //                 icon: 'loading',
    //                 duration: 20000
    //             })
    //         })
    //         .on('imageLoad', (ctx) => {
    //             console.log(`picture loaded`)
    //             console.log(`current canvas context:`, ctx)
    //             wx.hideToast()
    //         })
    //         .on('beforeDraw', (ctx, instance) => {
    //             console.log(`before canvas draw,i can do something`)
    //             console.log(`current canvas context:`, ctx)
    //         })
    //         .updateCanvas()
    // }

     // uploadTap() {
    //     const self = this;
    //     wx.chooseImage({
    //         count: 1, // 默认9
    //         sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
    //         sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
    //         success(res) {
    //             const src = res.tempFilePaths[0]
    //                 // 获取裁剪图片资源后，给data添加src属性及其值

    //             self.wecropper.pushOrign(src)
    //         }
    //     })
    // },

    // getCropperImage() {
    //     let that = this;
    //     wx.showToast({
    //             title: '上传中',
    //             icon: 'loading',
    //             duration: 20000
    //         })
    //         // 如果有需要两层画布处理模糊，实际画的是放大的那个画布
    //     this.wecropper.getCropperImage((src) => {
    //         if (src) {
    //             // 根据裁剪的类型  来设置上一个页面所需图片的地址
    //             let pages = getCurrentPages();
    //             let prevPage = pages[pages.length - 2]
    //             prevPage.setData({
    //                 imageSrc: src
    //             })
    //             that.setData({
    //                 imgSrc: src
    //             })
    //             wx.switchTab({ url: '../edit_information/edit_information?src=${src}' })
    //         } else {
    //             console.log('获取图片失败，请稍后重试')
    //         }
    //     })
    // },
})
function wxPromisify(fn) {
  return function (obj = {}) {
    return new Promise((resolve, reject) => {
      obj.success = function (res) {
        resolve(res)
      }

      obj.fail = function (res) {
        reject(res)
      }

      fn(obj)//执行函数，obj为传入函数的参数
    })
  }
}
const request=(params)=>{
  return new Promise((resolve,reject)=>{
    wx.request({
      ...params,
      success:(result)=>{
        resolve(result);
      },
      fail:(err)=>{
        reject(err);
      }
    })
  })
}
const formatTime = date => {
    const year = date.getFullYear()
    const month = date.getMonth() + 1
    const day = date.getDate()
    const hour = date.getHours()
    const minute = date.getMinutes()
    const second = date.getSeconds()

    return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

const formatNumber = n => {
    n = n.toString()
    return n[1] ? n : '0' + n
}


function chooseImage() {
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
            that.chooseViewShowBanner();
        },
        fail: function() {
            // fail
        },
        complete: function() {
            // complete
        }
    })
}

function previewImg(e) {
    var current = e.target.dataset.src;
    wx.previewImage({
        urls: this.data.imgs,
        current: current,
        fail: (res) => {},
        success: (res) => {},
    })
}
/** 删除图片Banner */
function deleteImvBanner(e) {
    var banner = this.data.banner;
    var itemIndex = e.currentTarget.dataset.id;
    banner.splice(itemIndex, 1);
    this.setData({
            banner: banner
        })
        //判断是否隐藏选择图片
    this.chooseViewShowBanner();
}


/** 是否隐藏图片选择Banner*/
function chooseViewShowBanner() {
    if (this.data.banner.length >= 2) {
        this.setData({
            chooseViewShowBanner: false
        })
    } else {
        this.setData({
            chooseViewShowBanner: true
        })
    }
}

/** 查看大图Banner */
function showImageBanner(e) {
    var banner = this.data.banner;
    var itemIndex = e.currentTarget.dataset.id;
    wx.previewImage({
        current: banner[itemIndex], // 当前显示图片的http链接
        urls: banner // 需要预览的图片http链接列表
    })
}

function changeClass(e) {
    const { index } = e.currentTarget.dataset;
    let { styleList } = this.data;
    styleList[index].isChecked = true;
    this.setData({
        styleList
    })
}
module.exports = {
    formatTime: formatTime,
    changeClass: changeClass,
    showImageBanner: showImageBanner,
    chooseViewShowBanner: chooseViewShowBanner,
    deleteImvBanner: deleteImvBanner,
    previewImg: previewImg,
    chooseImage: chooseImage,
    wxPromisify: wxPromisify,
    request:request
}
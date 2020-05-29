// pages/publish/publish.js
Page({

    /**
     * 页面的初始数据
     */
    data: {

    },
    toPubulishAppointment: function() {
        wx.navigateTo({
            url: '../../pages/publish_appointment/publish_appointment',
        })
    },
    toPublishGallery: function() {
        wx.navigateTo({
            url: '../../pages/publish_gallery/publish_gallery',
        })
    }
})
package com.zeezaglobal.mvvmrest.data.enitities

import android.provider.MediaStore.Images


data class MainContent(
    var id: Int,
    var title: String,
    var description: String,
    var source: String,
    var sourceId: String,
    var version: String,
    var publishedAt: Long,
    var readablePublishedAt: String,
    var updatedAt: Long,
    var readableUpdatedAt: String,
    var type: String,
    var active: Boolean,
    var draft: Boolean,
    var embedTypes: String,

    var images: Images,
    var language: String
)


package com.zeezaglobal.mvvmrest.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zeezaglobal.mvvmrest.data.enitities.Images
@Entity
data class MainContentDataObject (
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val source: String,
    val sourceId: String,
    val version: String,
    val publishedAt: Long,
    val readablePublishedAt: String,
    val updatedAt: Long,
    val readableUpdatedAt: String,
    val type: String,
    val active: Boolean,
    val draft: Boolean,
    val embedTypes: String,
    val images: String,
    val language: String
        )
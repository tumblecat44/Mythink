package com.dlrjsgml.mythink.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity("content")
data class ContentEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo val content: String,
    @ColumnInfo val createdAt: String
)

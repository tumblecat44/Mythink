package com.dlrjsgml.mythink.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContentDAO {
    @Query("SELECT * FROM content")
    fun getAllContent(): List<ContentEntity>?

    @Query("SELECT * FROM content WHERE createdAt LIKE :date ")
    fun getDateContent(date: String): List<ContentEntity>?

    @Insert
    fun insertContent(vararg content: ContentEntity)


}
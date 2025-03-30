package com.dlrjsgml.mythink.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ContentEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase(){
    abstract fun contentDao(): ContentDAO
}
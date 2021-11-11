package com.seventhson.rickandmorty.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.seventhson.rickandmorty.data.database.dao.ExampleDao
import com.seventhson.rickandmorty.data.database.entities.ExampleDB

@Database(
    entities = [ExampleDB::class], version = 1
)
abstract class AppDatabase: RoomDatabase() {

    abstract val exampleDao: ExampleDao
}

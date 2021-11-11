package com.seventhson.rickandmorty.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.seventhson.rickandmorty.data.database.entities.ExampleDB
import kotlinx.coroutines.flow.Flow

@Dao
interface ExampleDao : BaseDao<ExampleDB> {

    @Query("SELECT * FROM ExampleDB")
    fun getInOutList(): Flow<List<ExampleDB>>

}
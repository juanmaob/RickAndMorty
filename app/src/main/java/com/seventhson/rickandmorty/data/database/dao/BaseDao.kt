package com.seventhson.rickandmorty.data.database.dao

import androidx.room.*


interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(any: List<T>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(any: T)

    @Update
    fun update(any: T)

    @Delete
    fun delete(any: T)

    @Delete
    fun deleteAll(any: List<T>)


}
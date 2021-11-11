package com.seventhson.rickandmorty.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ExampleDB(
    @PrimaryKey
    val id: Int = 0,
    val nombre: String = ""
)
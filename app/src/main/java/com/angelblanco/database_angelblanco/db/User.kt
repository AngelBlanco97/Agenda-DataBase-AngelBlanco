package com.angelblanco.database_angelblanco.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "sub_name")
    val subname: String,
    @ColumnInfo(name = "numberPhone")
    val numberPhone: String,
    @ColumnInfo(name = "birthday")
    val birthday: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)

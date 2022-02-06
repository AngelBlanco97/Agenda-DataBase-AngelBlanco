package com.angelblanco.database_angelblanco.db

import androidx.room.*

@Dao
interface UserDao {
    //CRUD USUARIOS

    @Query("SELECT * FROM user ORDER BY user.name")
    fun findAllUser(): List<User>

    @Query("SELECT * FROM user WHERE user.id = :userId LIMIT 1")
    fun findUserById(userId: Int):User

    @Insert
    fun save(user:User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(users:List<User>)

    @Delete
    fun delete(user: User)
}


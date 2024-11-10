package com.mobileassignment3.exercise9

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun getAllUsers(): LiveData<List<User>>

    @Query("DELETE FROM user_table")
    suspend fun deleteAll()
}


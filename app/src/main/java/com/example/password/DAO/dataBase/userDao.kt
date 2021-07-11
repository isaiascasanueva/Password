package com.example.password.DAO.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.password.DAO.Usuario

@Dao
interface userDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserALL(user: Usuario  )
}
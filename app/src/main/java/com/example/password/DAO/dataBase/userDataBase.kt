package com.example.password.DAO.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.password.DAO.usuario

@Database(entities = [usuario::class],version = 1)
abstract class userDataBase: RoomDatabase() {
    abstract val user: userDao
}

private lateinit var INSTANCE:userDataBase

fun getDatabBase(context: Context):userDataBase{
    synchronized(userDataBase::class.java){//detiene que el metodo no se use en dos Hilos
        if(!::INSTANCE.isInitialized){
            INSTANCE= Room.databaseBuilder(context.applicationContext, userDataBase::class.java,//
                "userCreate"//NOMBRE DE TODA LA BASE DE DATOS.
            ).build()

        }

        return INSTANCE
    }
}
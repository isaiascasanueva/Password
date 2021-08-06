package com.example.password.DAO.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.password.DAO.Entitys.Credential
import com.example.password.DAO.Entitys.DetailCredential
import com.example.password.DAO.Entitys.Profile


@Database(entities = [Profile::class, Credential::class, DetailCredential::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract val dtbase: CredentialDao
}

//val room: AppDataBase = Room.databaseBuilder(this,AppDataBase::class.javaClass, "SavePassword").build()


private lateinit var INSTANCE: AppDataBase

fun getDatabBase(context: Context): AppDataBase {
    synchronized(AppDataBase::class.java) {//detiene que el metodo no se use en dos Hilos
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext, AppDataBase::class.java,//
                "SavePassword"//NOMBRE DE TODA LA BASE DE DATOS.
            ).build()

        }

        return INSTANCE
    }
}
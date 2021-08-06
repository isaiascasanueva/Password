package com.example.password.DAO

import com.example.basededatospruebas.DataBase.relations.CredentialWithDetailCredential
import com.example.basededatospruebas.DataBase.relations.ProfilewithCredentials
import com.example.password.DAO.Entitys.Profile
import com.example.password.DAO.dataBase.AppDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository(private val database: AppDataBase) {


     suspend fun insertProfile(profile:Profile){
        withContext(Dispatchers.IO) {

            database.dtbase.insertProfile(profile)
        }
    }


    suspend fun validateProfile(email:String,password:String ):Profile{
     return   withContext(Dispatchers.IO){

           database.dtbase.validateProfile(email,password)
        }

    }

    public suspend fun getprofile(n: Int): MutableList<Profile> {
        return withContext(Dispatchers.IO) {

          //  database.dtbase.insertProfile(Profile("dasdas", "dasdas"))
            database.dtbase.getProfile(n)

        }
    }

    public suspend fun chekProfile(n: Int): MutableList<Profile> {
        return withContext(Dispatchers.IO) {

            database.dtbase.getProfile(n)

        }
    }





}
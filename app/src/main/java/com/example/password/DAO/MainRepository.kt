package com.example.password.DAO

import com.example.basededatospruebas.DataBase.relations.CredentialWithDetailCredential
import com.example.password.DAO.Entitys.Credential
import com.example.password.DAO.Entitys.DetailCredential
import com.example.password.DAO.Entitys.Profile
import com.example.password.DAO.dataBase.AppDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository(private val database: AppDataBase) {


    suspend fun insertProfile(profile: Profile) {
        withContext(Dispatchers.IO) {

            database.dtbase.insertProfile(profile)
        }
    }


    suspend fun validateProfile(email: String, password: String): Profile {
        return withContext(Dispatchers.IO) {

            database.dtbase.validateProfile(email, password)
        }

    }


    suspend fun insertCredential(credential: Credential) {
        withContext(Dispatchers.IO) {
            database.dtbase.insertCredential(credential)
        }
    }

    suspend fun insertDetailCredential(detailCredential: DetailCredential) {
        withContext(Dispatchers.IO) {
            database.dtbase.insertDetailCredential(detailCredential)

        }
    }

    suspend fun getDetailCredentia(): MutableList<DetailCredential> {
        return withContext(Dispatchers.IO) {
            database.dtbase.getLastByIdDetailCredential()
        }
    }

    suspend fun GetOneCredentialWithDetailCredentia(): MutableList<CredentialWithDetailCredential> {
        return withContext(Dispatchers.IO) {
            database.dtbase.getCredentialWithDetailCredential(1)
            //obtener todos hacer un GetAll DE TODAS LAS CREDENCIALES CON SU DETALLE...!

        }
    }
        suspend fun GetCredentialWithDetailCredentia(): MutableList<CredentialWithDetailCredential> {
            return withContext(Dispatchers.IO) {
                database.dtbase.getCredentialWithDetailCredentialProbar()
                //obtener todos hacer un GetAll DE TODAS LAS CREDENCIALES CON SU DETALLE...!
            }
        }

    }
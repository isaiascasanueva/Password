package com.example.password.DAO.dataBase

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.basededatospruebas.DataBase.relations.CredentialWithDetailCredential
import com.example.basededatospruebas.DataBase.relations.ProfilewithCredentials
import com.example.password.DAO.Entitys.Credential
import com.example.password.DAO.Entitys.DetailCredential
import com.example.password.DAO.Entitys.Profile
import com.example.password.fragments.CreatePassword
import kotlinx.coroutines.flow.Flow


@Dao
interface CredentialDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProfile(profile: Profile)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCredential(credential: Credential)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailCredential(detailCredential: DetailCredential)

    @Transaction
    @Query("Select * from profile where id_profile= :profile")
    fun getProfileWithCredential(profile: Int): MutableList<ProfilewithCredentials>

    @Transaction
    @Query("Select * from profile where id_profile= :profile")
    fun getProfile(profile: Int): MutableList<Profile>

    @Transaction
    @Query("Select * from credential where id_profile= :credential")
    fun getCredentialWithDetailCredential(credential: Int): MutableList<CredentialWithDetailCredential>

    @Transaction
    @Query("Select * from Profile where email= :email AND password= :password")
    fun validateProfile( email:String, password: String):Profile



}
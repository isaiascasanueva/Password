package com.example.password.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.password.DAO.Entitys.Credential
import com.example.password.DAO.MainRepository
import com.example.password.DAO.dataBase.getDatabBase
import kotlinx.coroutines.launch

class FragtmentsViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabBase(application)
    private val repository = MainRepository(database)


    fun insercredential(nameCredential:String, idprofile:Int,password:String,commentary:String) {
        viewModelScope.launch {


            repository.insertCredential(Credential(nameCredential, idprofile, 1))

        }
    }


}
package com.example.password.ViewModel

import android.app.Application
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.password.DAO.Entitys.Credential
import com.example.password.DAO.Entitys.Profile
import com.example.password.DAO.MainRepository
import com.example.password.DAO.dataBase.getDatabBase
import com.example.password.MainActivity
import kotlinx.coroutines.launch

private val TAG = MainViewModel::class.java.simpleName

class MainViewModel(application: Application) : AndroidViewModel(application) {


    private val database = getDatabBase(application)
    private val repository = MainRepository(database)


    private var _result: MutableLiveData<Int> = MutableLiveData()
    val result: LiveData<Int>
        get() = _result


    var email = MutableLiveData<String>()
    val password = MutableLiveData<String>()


    private val _profile = MutableLiveData<List<Profile>>()
    val profile: LiveData<List<Profile>>
        get() = _profile


    private var _insertprofile = MutableLiveData<Profile>()
    val insertprofile: LiveData<Profile>
        get() = _insertprofile


    init {

    }


    fun insertProf(profile: Profile) {
        viewModelScope.launch {
            repository.insertProfile(profile)

        }
    }


    public fun CheckProfile(usuario: String, contrasenia: String) {
        viewModelScope.launch {

            try {
                _insertprofile.value = repository.validateProfile(usuario, contrasenia)
             //  val g =  _insertprofile.value!!.id_profile

                //repository.insertCredential(Credential("netflix", g,g,1))

                if (_insertprofile.value == null) {
                    _result.value = 1
                } else {
                    _result.value = 0
                }

            } catch (e: UnknownError) {
                Log.d(TAG, "Error", e)
            }

        }

    }


}
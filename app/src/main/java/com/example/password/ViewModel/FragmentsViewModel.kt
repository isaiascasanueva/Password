package com.example.password.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.basededatospruebas.DataBase.relations.CredentialWithDetailCredential
import com.example.password.DAO.Entitys.Credential
import com.example.password.DAO.Entitys.DetailCredential
import com.example.password.DAO.MainRepository
import com.example.password.DAO.dataBase.getDatabBase
import com.example.password.DAO.getEntity.CredentialDeta
import com.example.password.DAO.getEntity.NameCredential
import kotlinx.coroutines.launch

class FragmentsViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabBase(application)
    private val repository = MainRepository(database)


    private var _insertprofile = MutableLiveData<MutableList<DetailCredential>>()
    val insertprofile: LiveData<MutableList<DetailCredential>>
        get() = _insertprofile

    private var _getProfileCredential = MutableLiveData<MutableList<NameCredential>>()
    val getProfileCredential: LiveData<MutableList<NameCredential>>
        get() = _getProfileCredential


    private var _getLastProfileCredential =
        MutableLiveData<MutableList<CredentialWithDetailCredential>>()
    val getLastProfileCredential: MutableLiveData<MutableList<CredentialWithDetailCredential>>
        get() = _getLastProfileCredential


    init {
        getDetailCredentialWithCredential()
    }


    fun insertCedential(credential: Credential) {
        viewModelScope.launch {
            repository.insertCredential(credential)
        }
    }


    fun insertDetailCredential(detailCredential: DetailCredential) {
        viewModelScope.launch {
            repository.insertDetailCredential(detailCredential)
            _insertprofile.value = repository.getDetailCredentia()
            _getLastProfileCredential.value = repository.GetOneCredentialWithDetailCredentia()

        }
    }

     fun getDetailCredentialWithCredential() {

      viewModelScope.launch {


            val lista :MutableList<CredentialWithDetailCredential> = repository.GetCredentialWithDetailCredentia()

            val nameuser: MutableList<NameCredential> = arrayListOf()

            for (credencial in lista) {
                val pass: List<CredentialDeta> = listOf(
                    CredentialDeta(
                        credencial.credential.id_credential,
                        credencial.credential.name_credential,
                        credencial.detailCredential.password
                    )
                )
                val nameCreden = NameCredential(credencial.credential.name_credential, pass)
                nameuser.add(nameCreden)
            }
            _getProfileCredential.value = nameuser
        }

    }
}
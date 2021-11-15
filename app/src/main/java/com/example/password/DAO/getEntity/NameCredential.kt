package com.example.password.DAO.getEntity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class NameCredential(val nombre:String, val usuarioLists: List<CredentialDeta>, var expanded:Boolean = true  ):
    Parcelable

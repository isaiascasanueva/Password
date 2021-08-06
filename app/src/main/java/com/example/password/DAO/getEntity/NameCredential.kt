package com.example.password.DAO.getEntity

import android.os.Parcelable
import com.example.password.DAO.getEntity.DetailCredential
import kotlinx.android.parcel.Parcelize


@Parcelize
data class NameCredential(val nombre:String, val usuarioLists: List<DetailCredential>, var expanded:Boolean = true  ):
    Parcelable

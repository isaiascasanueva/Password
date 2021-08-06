package com.example.password.DAO.getEntity

import android.os.Parcelable
import com.example.password.DAO.getEntity.DetailCredential
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Profile(val id:Int, val name: String, val password:String, val NameCredential:List<DetailCredential>): Parcelable
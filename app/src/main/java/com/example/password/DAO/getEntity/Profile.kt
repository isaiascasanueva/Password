package com.example.password.DAO.getEntity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Profile(val id:Int, val name: String, val password:String, val nameCredentialDeta:List<CredentialDeta>): Parcelable
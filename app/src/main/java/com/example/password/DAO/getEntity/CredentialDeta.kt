package com.example.password.DAO.getEntity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class CredentialDeta(val id: Int, val nombre: String, val Contrasenia: String) : Parcelable
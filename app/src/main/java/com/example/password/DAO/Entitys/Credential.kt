package com.example.password.DAO.Entitys

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Credential(
    val name_credential: String,
    val id_profile: Int,//perfil
    val id_detail_profile: Int,//detalle credencial
    @PrimaryKey(autoGenerate = true)
    val id_credential: Int = 0
) : Parcelable




package com.example.password.DAO.Entitys

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class DetailCredential(
    @PrimaryKey(autoGenerate = true) val id_detail_profile: Int = 0,
    val type_service: String,
    val name_user: String,
    val password: String,
    val comentario: String
) : Parcelable
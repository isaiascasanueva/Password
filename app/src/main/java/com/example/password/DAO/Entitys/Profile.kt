package com.example.password.DAO.Entitys

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Profile(
    val email: String,
    val password: String,
    @PrimaryKey(autoGenerate = true) val id_profile: Int = 0
) : Parcelable
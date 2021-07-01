package com.example.password.DAO

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "user")
data class usuario (@PrimaryKey val id :Int, val nombre: String,  val Contrasenia:String): Parcelable
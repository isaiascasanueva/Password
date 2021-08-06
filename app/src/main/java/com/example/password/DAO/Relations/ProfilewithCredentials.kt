package com.example.basededatospruebas.DataBase.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.password.DAO.Entitys.Credential
import com.example.password.DAO.Entitys.Profile

data class ProfilewithCredentials(
    @Embedded val profile: Profile,

    @Relation(
        parentColumn = "id_profile",
        entityColumn = "id_profile"
    )
    val credential:MutableList<Credential>
    )


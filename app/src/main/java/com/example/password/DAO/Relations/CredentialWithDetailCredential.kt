package com.example.basededatospruebas.DataBase.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.password.DAO.Entitys.Credential
import com.example.password.DAO.Entitys.DetailCredential

data class CredentialWithDetailCredential (
    @Embedded
    val credential: Credential,
    @Relation(
        parentColumn = "id_detail_profile",
        entityColumn = "id_detail_profile"
    )

    val detailCredential: DetailCredential
    )
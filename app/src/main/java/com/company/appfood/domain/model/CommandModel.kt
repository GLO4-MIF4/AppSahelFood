package com.company.appfood.domain.model

import androidx.room.Entity

@Entity
data class CommandModel(
//    var id: String,
    var date_cmd: String,
    var quantite: String,
    var plat_id: String,
    var user_id: String,
)
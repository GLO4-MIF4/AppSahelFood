package com.company.appfood.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlatModel(
    var id:String,
    var label: String,
    var prix: String,
    var type_menu: String,
    var descrition: String,
    var image: String
)
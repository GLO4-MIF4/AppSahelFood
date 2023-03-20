package com.company.appfood.domain.model

import android.content.Intent
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MenuModel(
    // on below line we are creating variables for name and job
//    @PrimaryKey(autoGenerate = true) val id: Int ?= null,
    var id:String,
    var label: String,
    var categorie: String,
    var descrition: String,
    var image: String
)
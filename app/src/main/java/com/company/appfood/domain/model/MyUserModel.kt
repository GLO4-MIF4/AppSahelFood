package com.company.appfood.domain.model

import androidx.room.Entity

@Entity
data class MyUserModel(
    var id: String,
    var name: String,
    var email: String,
    var phone: String,
    var role: String,
//    var password: String,
)

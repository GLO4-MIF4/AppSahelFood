package com.company.appfood.domain.model

import androidx.room.Entity

@Entity
data class SecurityModel(
    var id:String,
    var email: String,
    var password:String

)
package com.jty.dandelion.net

import com.jty.dandelion.register.bean.User

data class Result(
    val code: Int,
    val users: List<User>?,
    val message: String,
    val success: Boolean
)


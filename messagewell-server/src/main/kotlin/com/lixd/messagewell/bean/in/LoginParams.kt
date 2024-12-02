package com.lixd.messagewell.bean.`in`

import jakarta.validation.constraints.NotEmpty

data class LoginParams(
    @NotEmpty(message = "账号不能为空")
    val account: String? = null,
    @NotEmpty(message = "账户密码不能为空")
    val password: String? = null
)
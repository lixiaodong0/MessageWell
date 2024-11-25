package com.lixd.messagewell.bean.`in`

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class RegisterParams(
    @NotEmpty(message = "账号不能为空")
    val account: String,
    @NotEmpty(message = "账户密码不能为空")
    @Size(min = 4, max = 20, message = "密码格式不正确，4~10位")
    val password: String
)
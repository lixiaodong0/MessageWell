package com.lixd.messagewell.bean.`in`

import jakarta.validation.constraints.NotEmpty

data class MsgWellParams(
    @NotEmpty(message = "内容不能为空")
    val content: String,
    @NotEmpty(message = "用户ID不能为空")
    val userId: Int,
    val moodId: Int?,
)
package com.lixd.messagewell.model

import jakarta.validation.constraints.NotEmpty
import org.springframework.web.bind.annotation.RequestParam

data class MsgWellParams(
    @NotEmpty(message = "内容不能为空")
    val content: String,
    @NotEmpty(message = "用户ID不能为空")
    val userId: Int,
    val moodId: Int?,
)
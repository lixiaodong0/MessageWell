package com.lixd.messagewell.bean.`in`

import jakarta.validation.constraints.NotEmpty

class MsgWellParams {
    @NotEmpty(message = "内容不能为空")
    var content: String = ""
    var userId: Int? = null
    var moodId: Int? = null
}
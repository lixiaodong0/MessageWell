package com.lixd.messagewell.service

import com.lixd.messagewell.model.MsgWell
import com.lixd.messagewell.bean.`in`.MsgWellParams

interface MsgWellService {
    fun addMsgWell(msgWellParams: MsgWellParams): Boolean

    fun findAll(): List<MsgWell>
}
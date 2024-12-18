package com.lixd.messagewell.mapper

import com.lixd.messagewell.model.MsgWell
import com.lixd.messagewell.bean.`in`.MsgWellParams

interface MsgWellMapper {
    fun insertMsgWell(msgWellParams: MsgWellParams): Boolean?
    fun findAll(): List<MsgWell>?
}
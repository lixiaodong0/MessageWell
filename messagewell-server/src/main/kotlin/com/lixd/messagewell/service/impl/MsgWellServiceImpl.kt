package com.lixd.messagewell.service.impl

import com.lixd.messagewell.mapper.MsgWellMapper
import com.lixd.messagewell.model.MsgWell
import com.lixd.messagewell.model.MsgWellParams
import com.lixd.messagewell.service.MsgWellService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MsgWellServiceImpl : MsgWellService {
    @Autowired
    private lateinit var msgWellMapper: MsgWellMapper

    override fun addMsgWell(msgWellParams: MsgWellParams): Boolean {
        return msgWellMapper.insertMsgWell(msgWellParams) ?: false
    }

    override fun findAll(): List<MsgWell> {
        return msgWellMapper.findAll() ?: emptyList()
    }
}
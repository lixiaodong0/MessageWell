package com.lixd.messagewell.controller

import com.lixd.messagewell.bean.BaseResult
import com.lixd.messagewell.model.MsgWell
import com.lixd.messagewell.bean.`in`.MsgWellParams
import com.lixd.messagewell.service.MsgWellService
import com.lixd.messagewell.service.TokenService
import com.lixd.messagewell.service.UserService
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 留言墙Controller
 */
@RequestMapping("/well")
@RestController
class MsgWellController {
    @Autowired
    private lateinit var msgWellService: MsgWellService

    @Autowired
    private lateinit var tokenService: TokenService

    @PostMapping("/add")
    fun addMsgWell(@Validated msgWellParams: MsgWellParams, request: HttpServletRequest): BaseResult<String> {
        val token = request.getHeader("token")
        val tokenModel = tokenService.findToken(token)
        if (tokenModel == null) {
            return BaseResult.failure(-1, "添加识失败")
        }
        val userId = tokenModel.id
        msgWellParams.userId = userId
        val success = msgWellService.addMsgWell(msgWellParams)
        if (success) {
            return BaseResult.success(null)
        }
        return BaseResult.failure(-1, "添加识失败")
    }

    @GetMapping("/get")
    fun findAll(): BaseResult<List<MsgWell>> {
        return BaseResult.success(msgWellService.findAll())
    }
}
package com.lixd.messagewell.config

import com.lixd.messagewell.model.BaseResult
import jakarta.validation.ConstraintViolationException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody

@ControllerAdvice
class ErrorHandlerController {
    @ExceptionHandler(value = [ConstraintViolationException::class])
    @ResponseBody
    fun validError(e: ConstraintViolationException): BaseResult<String> {
        val builder = StringBuilder()
        e.constraintViolations.forEach {
            builder.append(it.message).append(";")
        }
        return BaseResult.failure(-1, builder.toString())
    }
}
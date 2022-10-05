package com.example.zoo.infrastructure.controller

import com.example.zoo.domain.DomainException
import com.example.zoo.domain.ZooMaxSurfaceException
import com.example.zoo.domain.ZooMinSurfaceException
import com.example.zoo.infrastructure.repository.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.context.request.WebRequest
import java.time.Instant

@ControllerAdvice
@ResponseBody
class ControllerAdviceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException::class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    fun resourceNotFoundException(ex: ResourceNotFoundException, request: WebRequest): ErrorMessage {
        return ErrorMessage(HttpStatus.NOT_FOUND.value(), Instant.now(), ex.message ?: "", ex.message ?: "");
    }

    @ExceptionHandler(DomainException::class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    fun domainException(ex: DomainException, request: WebRequest): ErrorMessage {
        return ErrorMessage(HttpStatus.BAD_REQUEST.value(), Instant.now(), ex.message ?: "", ex.message ?: "");
    }
}

class ErrorMessage(val statusCode: Int, val timeStamp: Instant, val message: String, val description: String)
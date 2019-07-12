package com.loyofo.spa.webapp.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 在异常的声明上指定对应的 http 状态码
 */
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "my status code Exception")
public class MyStatusCodeException extends RuntimeException{
}

package com.santos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.santos.service.ListaNaoEncontradaException;


@ControllerAdvice
public class ListaNaoEncontradaAdvice {
        @ResponseBody
        @ExceptionHandler(ListaNaoEncontradaException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String todoListNotFoundHandler(ListaNaoEncontradaException ex) {
                return ex.getMessage();
        }

}
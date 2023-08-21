package com.example.taleadventure.base.error.exception;

import com.example.taleadventure.base.error.ErrorResponseResult;

public class NotFoundException extends TaleAdventureException{

    public NotFoundException(String message, ErrorResponseResult responseResult){
        super(message, responseResult);
    }
}

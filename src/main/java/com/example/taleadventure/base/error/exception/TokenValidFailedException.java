package com.example.taleadventure.base.error.exception;

import com.example.taleadventure.base.error.ErrorResponseResult;

public class TokenValidFailedException extends TaleAdventureException{

    public TokenValidFailedException(String message, ErrorResponseResult errorResponseResult) {
        super(message, errorResponseResult);
    }
}

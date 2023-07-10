package com.example.taleadventure.base.error.exception;

import com.example.taleadventure.base.error.ErrorResponseResult;
import lombok.Getter;

@Getter
public class TaleAdventureException extends RuntimeException{

    private final ErrorResponseResult result;

    public TaleAdventureException(String message, ErrorResponseResult errorResponseResult){
        super(message);
        this.result = errorResponseResult;
    }

    public int getStatus(){
        return result.getStatus();
    }

}

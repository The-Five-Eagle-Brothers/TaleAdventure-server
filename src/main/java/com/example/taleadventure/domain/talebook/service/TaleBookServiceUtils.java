package com.example.taleadventure.domain.talebook.service;

import com.example.taleadventure.base.error.ErrorResponseResult;
import com.example.taleadventure.base.error.exception.NotFoundException;
import com.example.taleadventure.domain.member.entity.Member;
import com.example.taleadventure.domain.member.repository.MemberRepository;
import com.example.taleadventure.domain.talebook.entity.TaleBook;
import com.example.taleadventure.domain.talebook.repository.TaleBookRepository;

import java.util.List;

public class TaleBookServiceUtils {

    public static List<TaleBook> findAll(TaleBookRepository taleBookRepository){
        List<TaleBook> taleBooks = taleBookRepository.findAll();
        if(taleBooks == null){
            throw new NotFoundException(String.format("동화책이 존재하지 않습니다."), ErrorResponseResult.NOT_FOUND_USER_EXCEPTION);
        }
        return taleBooks;
    }
}

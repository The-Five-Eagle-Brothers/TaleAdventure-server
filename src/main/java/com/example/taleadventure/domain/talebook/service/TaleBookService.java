package com.example.taleadventure.domain.talebook.service;

import com.example.taleadventure.domain.talebook.dto.TaleBookInfoDto;
import com.example.taleadventure.domain.talebook.dto.TaleBookRequest;
import com.example.taleadventure.domain.talebook.entity.TaleBook;
import com.example.taleadventure.domain.talebook.repository.TaleBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TaleBookService {

    private final TaleBookRepository taleBookRepository;

    @Transactional
    public TaleBookInfoDto saveTaleBook(TaleBookRequest taleBookRequest){
        TaleBook taleBook = taleBookRepository.save(taleBookRequest.toTaleBookEntity());
        return TaleBookInfoDto.of(taleBook);
    }
}

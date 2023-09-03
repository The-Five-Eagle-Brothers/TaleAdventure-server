package com.example.taleadventure.domain.word.service;

import com.example.taleadventure.domain.chapter.entity.Chapter;
import com.example.taleadventure.domain.chapter.repository.ChapterRepository;
import com.example.taleadventure.domain.image.service.S3Upload;
import com.example.taleadventure.domain.word.dto.WordInfoDto;
import com.example.taleadventure.domain.word.dto.WordRequest;
import com.example.taleadventure.domain.word.entity.Word;
import com.example.taleadventure.domain.word.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class WordService {
    private final WordRepository wordRepository;
    private final ChapterRepository chapterRepository;
    private final S3Upload s3Upload;

    @Transactional
    public WordInfoDto saveWord(WordRequest wordRequest, MultipartFile multipartFile){
        try {
            String imageUrl = s3Upload.upload(multipartFile);
            Chapter chapter = chapterRepository.findById(wordRequest.getChapterId()).get();
            Word word = wordRepository.save(wordRequest.toWordEntity(chapter,imageUrl));
            return WordInfoDto.of(word);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.example.taleadventure.domain.word.service;

import com.example.taleadventure.domain.auth.service.AuthService;
import com.example.taleadventure.domain.chapter.dto.ChapterInfoDto;
import com.example.taleadventure.domain.chapter.entity.Chapter;
import com.example.taleadventure.domain.chapter.repository.ChapterRepository;
import com.example.taleadventure.domain.chapter.service.ChapterServiceUtils;
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
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WordService {
    private final AuthService authService;
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

    @Transactional
    public List<WordInfoDto> retrieveWord(String title, String token){
        Long memberId = authService.getMemberId(token);
        List<Word> words = WordServiceUtils.findAllByTitle(wordRepository, title);
        return words.stream()
                .map(word -> {
                    return WordInfoDto.of(word);
                }).collect(Collectors.toList());
    }

    @Transactional
    public void updateBookMark(List<WordInfoDto> wordInfoDtos, String token){
        Long memberId = authService.getMemberId(token);
        for(int i = 0; i < wordInfoDtos.size(); i++){
            Word word = WordServiceUtils.findById(wordRepository, wordInfoDtos.get(i).getId());
            word.updateBookMark(wordInfoDtos.get(i).getBookMark());
            wordRepository.save(word);
        }
    }
}

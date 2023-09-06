package com.example.taleadventure.domain.chapter.service;

import com.example.taleadventure.domain.auth.service.AuthService;
import com.example.taleadventure.domain.chapter.dto.ChapterInfoDto;
import com.example.taleadventure.domain.chapter.dto.ChapterRequest;
import com.example.taleadventure.domain.chapter.entity.Chapter;
import com.example.taleadventure.domain.chapter.repository.ChapterRepository;
import com.example.taleadventure.domain.image.service.S3Upload;
import com.example.taleadventure.domain.member.repository.MemberRepository;
import com.example.taleadventure.domain.talebook.dto.TaleBookInfoDto;
import com.example.taleadventure.domain.talebook.entity.TaleBook;
import com.example.taleadventure.domain.talebook.repository.TaleBookRepository;
import com.example.taleadventure.domain.talebook.service.TaleBookServiceUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChapterService {
    private final AuthService authService;
    private final ChapterRepository chapterRepository;
    private final TaleBookRepository taleBookRepository;
    private final S3Upload s3Upload;

    @Transactional
    public ChapterInfoDto saveChapter(ChapterRequest chapterRequest, MultipartFile multipartFile){
        try {
            String imageUrl = s3Upload.upload(multipartFile);
            TaleBook taleBook = taleBookRepository.findById(chapterRequest.getTaleBookId()).get();
            Chapter chapter = chapterRepository.save(chapterRequest.toChapterEntity(taleBook, imageUrl));
            return ChapterInfoDto.of(chapter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public List<ChapterInfoDto> retrieveChapter(String name, String token){
        Long memberId = authService.getMemberId(token);
        List<Chapter> chapters = ChapterServiceUtils.findAllByName(chapterRepository, name);
        return chapters.stream()
                .map(chapter -> {
                    return ChapterInfoDto.of(chapter);
                }).collect(Collectors.toList());
    }


}

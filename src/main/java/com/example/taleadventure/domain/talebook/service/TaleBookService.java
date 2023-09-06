package com.example.taleadventure.domain.talebook.service;

import com.example.taleadventure.domain.auth.service.AuthService;
import com.example.taleadventure.domain.image.service.S3Upload;
import com.example.taleadventure.domain.talebook.dto.TaleBookInfoDto;
import com.example.taleadventure.domain.talebook.dto.TaleBookRequest;
import com.example.taleadventure.domain.talebook.entity.TaleBook;
import com.example.taleadventure.domain.talebook.repository.TaleBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TaleBookService {
    private final AuthService authService;
    private final S3Upload s3Upload;
    private final TaleBookRepository taleBookRepository;

    @Transactional
    public TaleBookInfoDto saveTaleBook(TaleBookRequest taleBookRequest, List<MultipartFile> multipartFile){
        try {
            String libraryImageUrl = s3Upload.upload(multipartFile.get(0));
            String chapterImageUrl = s3Upload.upload(multipartFile.get(1));
            String wordBookImageUrl = s3Upload.upload(multipartFile.get(2));
            TaleBook taleBook = taleBookRepository.save(taleBookRequest.toTaleBookEntity(libraryImageUrl, chapterImageUrl, wordBookImageUrl));
            return TaleBookInfoDto.of(taleBook);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public List<TaleBookInfoDto> retrieveTaleBook(String token){
        Long memberId = authService.getMemberId(token);
        List<TaleBook> taleBooks = TaleBookServiceUtils.findAll(taleBookRepository);
        return taleBooks.stream()
                .map(taleBook -> {
                return TaleBookInfoDto.of(taleBook);
                }).collect(Collectors.toList());
    }
}

package com.example.taleadventure.domain.talebook.service;

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

@RequiredArgsConstructor
@Service
public class TaleBookService {

    private final S3Upload s3Upload;
    private final TaleBookRepository taleBookRepository;

    @Transactional
    public TaleBookInfoDto saveTaleBook(TaleBookRequest taleBookRequest, MultipartFile multipartFile){
        try {
            String imageUrl = s3Upload.upload(multipartFile);
            TaleBook taleBook = taleBookRepository.save(taleBookRequest.toTaleBookEntity(imageUrl));
            return TaleBookInfoDto.of(taleBook);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

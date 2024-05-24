package com.memesapp.web.mapper;

import com.memesapp.web.dto.MemesDto;
import com.memesapp.web.model.Memes;

public class MemesMapper {
    public static Memes mapToMemes(MemesDto memesDto){
        Memes memes = Memes.builder()
                .id(memesDto.getId())
                .title(memesDto.getTitle())
                .image(memesDto.getImage())
                .category(memesDto.getCategory())
                .labels(memesDto.getLabels())
                .createdOn(memesDto.getCreatedOn())
                .updatedOn(memesDto.getUpdatedOn())
                .createdBy(memesDto.getCreatedBy())
                .build();

        return memes;
    }

    public static MemesDto mapToMemesDto(Memes memes){
        MemesDto memesdto = MemesDto.builder()
                .id(memes.getId())
                .title(memes.getTitle())
                .image(memes.getImage())
                .category(memes.getCategory())
                .labels(memes.getLabels())
                .createdOn(memes.getCreatedOn())
                .updatedOn(memes.getUpdatedOn())
                .createdBy(memes.getCreatedBy())
                .build();

        return memesdto;
    }
}

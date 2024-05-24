package com.memesapp.web.service;

import com.memesapp.web.dto.CategoriesDto;
import com.memesapp.web.dto.LabelsDto;
import com.memesapp.web.dto.MemesDto;

import java.util.List;

public interface MemesService {

    List<MemesDto> listAllMemes();
    List<CategoriesDto> listAllCategories();
    List<LabelsDto> listAllLabels();
    List<MemesDto> searchMemes(String query);
    List<MemesDto> filterMemesByCategories(String query);
    List<MemesDto> filterMemesByLabels(String query);
    void uploadMemes(MemesDto memesDto);
    void deleteMemes(Long memeId);
    List<MemesDto> listAllMemesCreatedByUser(String query);
}

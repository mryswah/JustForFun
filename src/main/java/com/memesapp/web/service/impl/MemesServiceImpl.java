package com.memesapp.web.service.impl;

import com.memesapp.web.dto.CategoriesDto;
import com.memesapp.web.dto.LabelsDto;
import com.memesapp.web.dto.MemesDto;
import com.memesapp.web.model.Categories;
import com.memesapp.web.model.Labels;
import com.memesapp.web.model.Memes;
import com.memesapp.web.model.Users;
import com.memesapp.web.repository.CategoriesRepository;
import com.memesapp.web.repository.LabelsRepository;
import com.memesapp.web.repository.MemesRepository;
import com.memesapp.web.repository.UsersRepository;
import com.memesapp.web.security.SecurityUtil;
import com.memesapp.web.service.MemesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.memesapp.web.mapper.CategoriesMapper.mapToCategoriesDto;
import static com.memesapp.web.mapper.LabelsMapper.mapToLabelsDto;
import static com.memesapp.web.mapper.MemesMapper.mapToMemes;
import static com.memesapp.web.mapper.MemesMapper.mapToMemesDto;

@Service
public class MemesServiceImpl implements MemesService {

    private MemesRepository memesRepository;
    private CategoriesRepository categoriesRepository;
    private LabelsRepository labelsRepository;
    private UsersRepository usersRepository;

    @Autowired
    public MemesServiceImpl(MemesRepository memesRepository,CategoriesRepository categoriesRepository, LabelsRepository labelsRepository, UsersRepository usersRepository) {
        this.memesRepository = memesRepository;
        this.categoriesRepository = categoriesRepository;
        this.labelsRepository = labelsRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public List<MemesDto> listAllMemes(){
        List<Memes> memes = memesRepository.findAll(Sort.by("createdOn").descending());
        return memes.stream().map((meme) -> mapToMemesDto(meme)).collect(Collectors.toList());
    }

    @Override
    public List<CategoriesDto> listAllCategories(){
        List<Categories> categories = categoriesRepository.findAll();
        return categories.stream().map((category) -> mapToCategoriesDto(category)).collect(Collectors.toList());
    }

    @Override
    public List<LabelsDto> listAllLabels(){
        List<Labels> labels = labelsRepository.findAll();
        return labels.stream().map((label) -> mapToLabelsDto(label)).collect(Collectors.toList());
    }

    @Override
    public List<MemesDto> searchMemes(String query){
        List<Memes> memes = memesRepository.searchMemes(query);
        return memes.stream().map((meme) -> mapToMemesDto(meme)).collect(Collectors.toList());
    }

    @Override
    public List<MemesDto> filterMemesByCategories(String query){
        List<Memes> memes = memesRepository.filterMemesByCategories(query);
        return memes.stream().map((meme) -> mapToMemesDto(meme)).collect(Collectors.toList());
    }

    @Override
    public List<MemesDto> filterMemesByLabels(String query){
        List<Memes> memes = memesRepository.filterMemesByLabels(query);
        return memes.stream().map((meme) -> mapToMemesDto(meme)).collect(Collectors.toList());
    }

    @Override
    public void uploadMemes(MemesDto memesDto) {
        String username = SecurityUtil.getSessionUser();
        Users users = usersRepository.searchByUsername(username);
        Memes memes = mapToMemes(memesDto);
        memes.setUsers(users);
        memesRepository.save(memes);
    }

    @Override
    public void deleteMemes(Long memeId) {
        memesRepository.deleteById(memeId);
    }

    @Override
    public List<MemesDto> listAllMemesCreatedByUser(String query){
        List<Memes> memes = memesRepository.listAllMemesCreatedByUser(query);
        return memes.stream().map((meme) -> mapToMemesDto(meme)).collect(Collectors.toList());
    }
}

package com.memesapp.web.controllers;

import com.memesapp.web.constants.CommonConstants;
import com.memesapp.web.dto.CategoriesDto;
import com.memesapp.web.dto.LabelsDto;
import com.memesapp.web.dto.MemesDto;
import com.memesapp.web.model.Memes;
import com.memesapp.web.model.Users;
import com.memesapp.web.security.SecurityUtil;
import com.memesapp.web.service.MemesService;
import com.memesapp.web.service.UsersService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
public class MemesController {
    private MemesService memesService;
    private UsersService usersService;

    @Autowired
    public MemesController(MemesService memesService, UsersService usersService) {
        this.memesService = memesService;
        this.usersService = usersService;
    }

    // Populate the common Categories and Labels model attribute on the Nav Bar (on the left)
    private void populateCommonModelAttributes(Model model) {
        List<CategoriesDto> categories = memesService.listAllCategories();
        List<LabelsDto> labels = memesService.listAllLabels();
        model.addAttribute(CommonConstants.ATTRIB_CATEGORIES, categories);
        model.addAttribute(CommonConstants.ATTRIB_LABELS, labels);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/memes")
    public String listMemes(Model model) {
        Users users = new Users();
        String username = SecurityUtil.getSessionUser();
        if (username != null) {
            users = usersService.searchByUsername(username);
        }
        model.addAttribute(CommonConstants.ATTRIB_USERS, users);
        List<MemesDto> memes;
        Object memesFilter = model.getAttribute(CommonConstants.ATTRIB_MEMES_FILTER);
        if (memesFilter instanceof List<?>) {
            memes = (List<MemesDto>) memesFilter;
        } else {
            memes = memesService.listAllMemes();
        }

        List<String> image = new ArrayList<>();
        if (!memes.isEmpty()) {
            for (MemesDto memeDto : memes) {
                String imageString = Base64.getEncoder().encodeToString(memeDto.getImage());
                image.add(imageString);
                model.addAttribute(CommonConstants.ATTRIB_IMAGE, image);
            }
        }
        model.addAttribute(CommonConstants.ATTRIB_MEMES, memes);

        populateCommonModelAttributes(model);
        return CommonConstants.PAGE_MEMES_LIST;
    }

    @GetMapping("/memes/search")
    public String searchMemes(@RequestParam(value = "query") String query, RedirectAttributes redirectAttributes) {
        List<MemesDto> searchMemes = memesService.searchMemes(query);
        redirectAttributes.addFlashAttribute(CommonConstants.ATTRIB_MEMES_FILTER, searchMemes);
        return CommonConstants.REDIRECT_MEMES;
    }

    @GetMapping("/memes/category/{query}")
    public String listMemesByCategory(@PathVariable("query") String query, RedirectAttributes redirectAttributes) {
        List<MemesDto> memesCategory = memesService.filterMemesByCategories(query);
        redirectAttributes.addFlashAttribute(CommonConstants.ATTRIB_MEMES_FILTER, memesCategory);
        return CommonConstants.REDIRECT_MEMES;
    }

    @GetMapping("/memes/labels/{query}")
    public String listMemesByLabels(@PathVariable("query") String query, RedirectAttributes redirectAttributes) {
        List<MemesDto> memesLabel = memesService.filterMemesByLabels(query);
        redirectAttributes.addFlashAttribute(CommonConstants.ATTRIB_MEMES_FILTER, memesLabel);
        return CommonConstants.REDIRECT_MEMES;
    }

    @GetMapping("/memes/upload")
    public String uploadMemesForm(Model model) {
        Users users = new Users();
        String username = SecurityUtil.getSessionUser();
        if (username != null) {
            users = usersService.searchByUsername(username);
        }
        model.addAttribute(CommonConstants.ATTRIB_USERS, users);

        populateCommonModelAttributes(model);

        Memes memes = new Memes();
        model.addAttribute(CommonConstants.ATTRIB_MEMES, memes);
        return CommonConstants.PAGE_MEMES_UPLOAD;
    }

    @PostMapping("/memes/upload")
    public String uploadMemes(@Valid @ModelAttribute("memes") MemesDto memesDto, BindingResult result, Model model, @RequestParam("image") MultipartFile image) {
        Users users = new Users();
        String username = SecurityUtil.getSessionUser();
        if (username != null) {
            users = usersService.searchByUsername(username);
        }
        model.addAttribute(CommonConstants.ATTRIB_USERS, users);
        populateCommonModelAttributes(model);
        if (!image.isEmpty() && !CommonConstants.ALLOWED_CONTENT_TYPES.contains(image.getContentType())) {
            FieldError error = new FieldError("memes", "image", "Please upload a Meme Image file (png, jpeg, jpg, gif)");
            result.addError(error);
        }
        if (result.hasErrors()) {
            model.addAttribute(CommonConstants.ATTRIB_MEMES, memesDto);
            return CommonConstants.PAGE_MEMES_UPLOAD;
        }
        memesService.uploadMemes(memesDto);
        return "redirect:/memes?successfulPost";
    }

    @PostMapping("/memes/{memesid}/{query}/delete")
    public String deleteMeme(@PathVariable("memesid") Long memesid, @PathVariable("query") String query) {
        memesService.deleteMemes(memesid);
        return "redirect:/profile/{query}";
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws ServletException {
        // Convert multipart object to byte[]
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
    }
}

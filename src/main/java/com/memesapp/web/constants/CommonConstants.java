package com.memesapp.web.constants;

import java.util.Arrays;
import java.util.List;

public class CommonConstants {
    public static final List<String> ALLOWED_CONTENT_TYPES = Arrays.asList("image/jpeg", "image/png", "image/gif");

    public static final String ATTRIB_CATEGORIES = "categories";
    public static final String ATTRIB_LABELS = "labels";

    public static final String ATTRIB_IMAGE = "image";
    public static final String ATTRIB_MEMES = "memes" ;
    public static final String ATTRIB_MEMES_FILTER = "memesFilter" ;
    public static final String ATTRIB_USERS = "users" ;

    public static final String PAGE_LOGIN_PAGE = "login-page";
    public static final String PAGE_MEMES_LIST = "memes-list";
    public static final String PAGE_MEMES_UPLOAD = "memes-upload";
    public static final String PAGE_REGISTER_PAGE = "register-page";
    public static final String PAGE_USER_PROFILE = "user-profile";
    public static final String PAGE_USER_SETTINGS = "user-settings";

    public static final String REDIRECT_MEMES = "redirect:/memes";
}

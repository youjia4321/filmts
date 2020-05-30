package com.dream.utils;

import javax.servlet.http.Cookie;

public class CookieUtil {

    public static Cookie updateCookie(String key, String value, int time) {

        Cookie cookie = new Cookie(key, value);

        cookie.setMaxAge(time);

        return cookie;
    }

}

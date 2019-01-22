package com.company;

import java.util.Arrays;

/**
 * Created by pranavi on 1/21/19.
 */
public class Utils {

    public static String sort(String src) {
        char[] ret = src.toCharArray();
        Arrays.sort(ret);
        return new String(ret);
    }
}

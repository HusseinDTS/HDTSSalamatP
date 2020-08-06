package com.app.salamat.utils;

public class Tools {
    public static String getProductStatus(boolean published){
        if(published)
            return "موجود";
        else
            return "نا موجود";
    }
}

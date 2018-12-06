package com.susufa.zoo.utils;

public class StringUtils {
    private static final String TAG = StringUtils.class.getSimpleName();

    public static String decodeUtf8String(String encodeString) {
        String decodeString = "";
        try {
//            byte[] bytes = encodeString.getBytes("UTF-8");
//            decodeString = new String(bytes, "UTF-8");
            decodeString = new String(encodeString.getBytes("iso-8859-1"), "UTF-8");
        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());
        }

        return decodeString;
    }
}

package com.susufa.zoo.constants;

import com.susufa.zoo.BuildConfig;

public class Constants {
    //測試外網
    private static final String SERVER_URL_DEV = "https://data.taipei/opendata/datalist/apiAccess";

    //正式外網
    private static final String SERVER_URL = "https://data.taipei/opendata/datalist/apiAccess";

    public static String getServerUrl() {
        return BuildConfig.DEBUG ? SERVER_URL_DEV : SERVER_URL;
    }

}

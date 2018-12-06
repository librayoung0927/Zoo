package com.susufa.zoo.module.apiParams;

import com.android.volley.Request;

import java.util.Map;

public class InParamsParkIntro extends InParamsBase {

    public InParamsParkIntro() {
        super("?scope=resourceAquire&rid=5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a", null);
        setMethod(Request.Method.GET);
    }

    @Override
    public Map<String, String> renderMap() {
        return null;
    }
}

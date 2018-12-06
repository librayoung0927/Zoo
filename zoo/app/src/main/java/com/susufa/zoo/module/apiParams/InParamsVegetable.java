package com.susufa.zoo.module.apiParams;

import com.android.volley.Request;

import java.util.Map;

public class InParamsVegetable extends InParamsBase {
    public InParamsVegetable() {
        super("?scope=resourceAquire&rid=f18de02f-b6c9-47c0-8cda-50efad621c14", null);
        setMethod(Request.Method.GET);
    }

    @Override
    public Map<String, String> renderMap() {
        return null;
    }
}

package com.susufa.zoo.interfaces;

public interface OnAPIListener {
    void onPreExecute();

    void onResponse(String response);

    void onError(int statusCode, String error);
}

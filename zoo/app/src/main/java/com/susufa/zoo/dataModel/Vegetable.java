package com.susufa.zoo.dataModel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Vegetable extends RecyclerBaseItem implements Serializable {

    public Vegetable() {
        super(-1);
    }

    @SerializedName("F_Name_Latin")
    private String mFNameLatin;

    @SerializedName("F_pdf02_ALT")
    private String mFPdf02Alt;

    @SerializedName("F_Location")
    private String mFLocation;

    @SerializedName("F_pdf01_ALT")
    private String mFPdf01Alt;

    @SerializedName("F_Summary")
    private String mFSummary;

    @SerializedName("F_Pic01_URL")
    private String mFPic01Url;

    @SerializedName("F_pdf02_URL")
    private String mFPdf02Url;

    @SerializedName("F_Pic02_URL")
    private String mPic02Url;

    @SerializedName("F_Keywords")
    private String mFKeyWords;

    @SerializedName("F_Code")
    private String mFCode;

    @SerializedName("F_Geo")
    private String mFGeo;

    @SerializedName("F_Pic03_URL")
    private String mFPic03Url;

    @SerializedName("F_Voice01_ALT")
    private String mFVoice01Alt;

    @SerializedName("F_AlsoKnown")
    private String mFAlsoKnown;

    @SerializedName("F_Voice02_ALT")
    private String mFVoice02Alt;

    @SerializedName("F_Name_Ch")
    private String mFNameCh;

    @SerializedName("F_Pic04_ALT")
    private String mFPic04Alt;

    @SerializedName("F_Name_En")
    private String mFNameEn;

    @SerializedName("F_Brief")
    private String mFBrief;

    @SerializedName("F_Pic04_URL")
    private String mFPic04Url;

    @SerializedName("F_Voice01_URL")
    private String mFVoice01Url;

    @SerializedName("F_Feature")
    private String mFFeature;

    @SerializedName("F_Pic02_ALT")
    private String mFPic02Alt;

    @SerializedName("F_Family")
    private String mFFamily;

    @SerializedName("F_Voice03_ALT")
    private String mFVoice03Alt;

    @SerializedName("F_Function&Application")
    private String mFFunction;

    @SerializedName("F_Voice02_URL")
    private String mFVoice02Url;

    @SerializedName("F_Pic03_ALT")
    private String mFPic03Alt;

    @SerializedName("F_Pic01_ALT")
    private String mFPic01Alt;

    @SerializedName("F_CID")
    private String mFCid;

    @SerializedName("F_pdf01_URL")
    private String mFPdf01Url;

    @SerializedName("F_Vedio_URL")
    private String mFVideoUrl;

    @SerializedName("F_Genus")
    private String mFGenus;

    @SerializedName("F_Voice03_URL")
    private String mFVoice03Url;

    @SerializedName("F_Update")
    private String mFUpdate;

    @SerializedName("_id")
    private int mID;


    public String getFNameLatin() {
        return mFNameLatin;
    }

    public void setFNameLatin(String FNameLatin) {
        mFNameLatin = FNameLatin;
    }

    public String getFPdf02Alt() {
        return mFPdf02Alt;
    }

    public void setFPdf02Alt(String FPdf02Alt) {
        mFPdf02Alt = FPdf02Alt;
    }

    public String getFLocation() {
        return mFLocation;
    }

    public void setFLocation(String FLocation) {
        mFLocation = FLocation;
    }

    public String getFPdf01Alt() {
        return mFPdf01Alt;
    }

    public void setFPdf01Alt(String FPdf01Alt) {
        mFPdf01Alt = FPdf01Alt;
    }

    public String getFSummary() {
        return mFSummary;
    }

    public void setFSummary(String FSummary) {
        mFSummary = FSummary;
    }

    public String getFPic01Url() {
        return mFPic01Url;
    }

    public void setFPic01Url(String FPic01Url) {
        mFPic01Url = FPic01Url;
    }

    public String getFPdf02Url() {
        return mFPdf02Url;
    }

    public void setFPdf02Url(String FPdf02Url) {
        mFPdf02Url = FPdf02Url;
    }

    public String getPic02Url() {
        return mPic02Url;
    }

    public void setPic02Url(String pic02Url) {
        mPic02Url = pic02Url;
    }

    public String getFKeyWords() {
        return mFKeyWords;
    }

    public void setFKeyWords(String FKeyWords) {
        mFKeyWords = FKeyWords;
    }

    public String getFCode() {
        return mFCode;
    }

    public void setFCode(String FCode) {
        mFCode = FCode;
    }

    public String getFGeo() {
        return mFGeo;
    }

    public void setFGeo(String FGeo) {
        mFGeo = FGeo;
    }

    public String getFPic03Url() {
        return mFPic03Url;
    }

    public void setFPic03Url(String FPic03Url) {
        mFPic03Url = FPic03Url;
    }

    public String getFVoice01Alt() {
        return mFVoice01Alt;
    }

    public void setFVoice01Alt(String FVoice01Alt) {
        mFVoice01Alt = FVoice01Alt;
    }

    public String getFAlsoKnown() {
        return mFAlsoKnown;
    }

    public void setFAlsoKnown(String FAlsoKnown) {
        mFAlsoKnown = FAlsoKnown;
    }

    public String getFVoice02Alt() {
        return mFVoice02Alt;
    }

    public void setFVoice02Alt(String FVoice02Alt) {
        mFVoice02Alt = FVoice02Alt;
    }

    public String getFNameCh() {
        return mFNameCh;
    }

    public void setFNameCh(String FNameCh) {
        mFNameCh = FNameCh;
    }

    public String getFPic04Alt() {
        return mFPic04Alt;
    }

    public void setFPic04Alt(String FPic04Alt) {
        mFPic04Alt = FPic04Alt;
    }

    public String getFNameEn() {
        return mFNameEn;
    }

    public void setFNameEn(String FNameEn) {
        mFNameEn = FNameEn;
    }

    public String getFBrief() {
        return mFBrief;
    }

    public void setFBrief(String FBrief) {
        mFBrief = FBrief;
    }

    public String getFPic04Url() {
        return mFPic04Url;
    }

    public void setFPic04Url(String FPic04Url) {
        mFPic04Url = FPic04Url;
    }

    public String getFVoice01Url() {
        return mFVoice01Url;
    }

    public void setFVoice01Url(String FVoice01Url) {
        mFVoice01Url = FVoice01Url;
    }

    public String getFFeature() {
        return mFFeature;
    }

    public void setFFeature(String FFeature) {
        mFFeature = FFeature;
    }

    public String getFPic02Alt() {
        return mFPic02Alt;
    }

    public void setFPic02Alt(String FPic02Alt) {
        mFPic02Alt = FPic02Alt;
    }

    public String getFFamily() {
        return mFFamily;
    }

    public void setFFamily(String FFamily) {
        mFFamily = FFamily;
    }

    public String getFVoice03Alt() {
        return mFVoice03Alt;
    }

    public void setFVoice03Alt(String FVoice03Alt) {
        mFVoice03Alt = FVoice03Alt;
    }

    public String getFFunction() {
        return mFFunction;
    }

    public void setFFunction(String FFunction) {
        mFFunction = FFunction;
    }

    public String getFVoice02Url() {
        return mFVoice02Url;
    }

    public void setFVoice02Url(String FVoice02Url) {
        mFVoice02Url = FVoice02Url;
    }

    public String getFPic03Alt() {
        return mFPic03Alt;
    }

    public void setFPic03Alt(String FPic03Alt) {
        mFPic03Alt = FPic03Alt;
    }

    public String getFPic01Alt() {
        return mFPic01Alt;
    }

    public void setFPic01Alt(String FPic01Alt) {
        mFPic01Alt = FPic01Alt;
    }

    public String getFCid() {
        return mFCid;
    }

    public void setFCid(String FCid) {
        mFCid = FCid;
    }

    public String getFPdf01Url() {
        return mFPdf01Url;
    }

    public void setFPdf01Url(String FPdf01Url) {
        mFPdf01Url = FPdf01Url;
    }

    public String getFVideoUrl() {
        return mFVideoUrl;
    }

    public void setFVideoUrl(String FVideoUrl) {
        mFVideoUrl = FVideoUrl;
    }

    public String getFGenus() {
        return mFGenus;
    }

    public void setFGenus(String FGenus) {
        mFGenus = FGenus;
    }

    public String getFVoice03Url() {
        return mFVoice03Url;
    }

    public void setFVoice03Url(String FVoice03Url) {
        mFVoice03Url = FVoice03Url;
    }

    public String getFUpdate() {
        return mFUpdate;
    }

    public void setFUpdate(String FUpdate) {
        mFUpdate = FUpdate;
    }

    public int getID() {
        return mID;
    }

    public void setID(int ID) {
        mID = ID;
    }
}

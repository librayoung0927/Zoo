package com.susufa.zoo.dataModel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ParkIntro extends RecyclerBaseItem implements Serializable {

    public ParkIntro() {
        super(-1);
    }

    @SerializedName("E_Pic_URL")
    private String mEPicUrl;

    @SerializedName("E_Geo")
    private String mEGeo;

    @SerializedName("E_Info")
    private String mEInfo;

    @SerializedName("E_no")
    private String mENo;

    @SerializedName("E_Category")
    private String mECategory;

    @SerializedName("E_Name")
    private String mEName;

    @SerializedName("E_Memo")
    private String mEMemo;

    @SerializedName("_id")
    private int mID;

    @SerializedName("E_URL")
    private String mEUrl;

    public String getEPicUrl() {
        return mEPicUrl;
    }

    public void setEPicUrl(String EPicUrl) {
        mEPicUrl = EPicUrl;
    }

    public String getEGeo() {
        return mEGeo;
    }

    public void setEGeo(String EGeo) {
        mEGeo = EGeo;
    }

    public String getEInfo() {
        return mEInfo;
    }

    public void setEInfo(String EInfo) {
        mEInfo = EInfo;
    }

    public String getENo() {
        return mENo;
    }

    public void setENo(String ENo) {
        mENo = ENo;
    }

    public String getECategory() {
        return mECategory;
    }

    public void setECategory(String ECategory) {
        mECategory = ECategory;
    }

    public String getEName() {
        return mEName;
    }

    public void setEName(String EName) {
        mEName = EName;
    }

    public String getEMemo() {
        return mEMemo;
    }

    public void setEMemo(String EMemo) {
        mEMemo = EMemo;
    }

    public int getID() {
        return mID;
    }

    public void setID(int ID) {
        mID = ID;
    }

    public String getEUrl() {
        return mEUrl;
    }

    public void setEUrl(String EUrl) {
        mEUrl = EUrl;
    }
}

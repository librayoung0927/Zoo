package com.susufa.zoo.dataModel;

import java.io.Serializable;

public class RecyclerBaseItem implements Serializable {
    private int mLayoutType = -1;
    private boolean nClickable = true;
    private String mTitle;
    private Object mTag;

    public RecyclerBaseItem(int layoutType) {
        this.mLayoutType = layoutType;
    }

    public int getLayoutType() {
        return mLayoutType;
    }

    public void setLayoutType(int layoutType) {
        this.mLayoutType = layoutType;
    }

    public boolean isnClickable() {
        return nClickable;
    }

    public void setnClickable(boolean nClickable) {
        this.nClickable = nClickable;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public Object getTag() {
        return mTag;
    }

    public void setTag(Object tag) {
        this.mTag = tag;
    }
}

package com.thatkawaiiguy.meleehandbook.other;


import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

public class CustomParentObject implements ParentObject {
    private List<Object> mChildObjectList;

    private String mParentText;


    public CustomParentObject() {
    }

    public String getParentText() {
        return mParentText;
    }

    public void setParentText(String parentText) {
        mParentText = parentText;
    }

    @Override
    public List<Object> getChildObjectList() {
        return mChildObjectList;
    }

    @Override
    public void setChildObjectList(List<Object> childObjectList) {
        mChildObjectList = childObjectList;
    }
}
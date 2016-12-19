package com.thatkawaiiguy.meleehandbook.other;

/**
 * Created by Ivan Martinez on 12/17/2016.
 */

public class ItemObjects {
    String title;
    String desc;

    public ItemObjects(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

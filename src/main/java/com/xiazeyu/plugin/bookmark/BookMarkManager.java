package com.xiazeyu.plugin.bookmark;

import com.xiazeyu.plugin.bookmark.tool.XmlToObject;

public class BookMarkManager {

    public static void main(String[] args) {
        XmlToObject.init();
        XmlToObject.transform();
        System.out.println("ok");
    }

}

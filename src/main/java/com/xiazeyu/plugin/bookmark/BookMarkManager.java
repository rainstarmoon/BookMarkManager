package com.xiazeyu.plugin.bookmark;

import com.xiazeyu.plugin.bookmark.bean.BookRoot;
import com.xiazeyu.plugin.bookmark.tool.ObjectToXml;
import com.xiazeyu.plugin.bookmark.tool.XmlToObject;

public class BookMarkManager {

    public static void main(String[] args) {
        XmlToObject.init();
        BookRoot root = XmlToObject.transform();
        ObjectToXml.init();
        ObjectToXml.transform(root);
    }

}

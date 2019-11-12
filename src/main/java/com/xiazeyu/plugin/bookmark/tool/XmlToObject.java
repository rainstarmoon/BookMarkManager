package com.xiazeyu.plugin.bookmark.tool;

import com.xiazeyu.plugin.bookmark.bean.BookMarkRoot;
import com.xiazeyu.plugin.bookmark.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class XmlToObject {

    static String inputPath;

    static List<String> contextList;

    static BookMarkRoot root;

    static long beginIndex = 0L;

    static long endIndex = -1L;

    static long currentIndex = -1L;

    public static void init() {
        inputPath = "";
        contextList = new ArrayList<>();
        root = new BookMarkRoot();
    }

    public static void transform() {
        FileUtil.inputJavaFile(inputPath, contextList);
        for (int i = 0; i < contextList.size(); i++) {


        }


    }

}

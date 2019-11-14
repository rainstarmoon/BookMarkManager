package com.xiazeyu.plugin.bookmark.tool;

import com.xiazeyu.plugin.bookmark.bean.BookRoot;
import com.xiazeyu.plugin.bookmark.bean.Folder;
import com.xiazeyu.plugin.bookmark.bean.Page;
import com.xiazeyu.plugin.bookmark.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class ObjectToXml {

    static String outputPath;

    static List<String> contextList;

    public static void init() {
        outputPath = "D:\\Github_Workspace\\BookMarkManager\\demo\\out.html";
        contextList = new ArrayList<>();
    }

    public static void transform(BookRoot root) {
        contextList.add("<!DOCTYPE NETSCAPE-Bookmark-file-1>");
        contextList.add("<!-- This is an automatically generated file.");
        contextList.add("     It will be read and overwritten.");
        contextList.add("     DO NOT EDIT! -->");
        contextList.add("<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=UTF-8\">");
        transformRoot(root);
        FileUtil.outputProtoFile(outputPath, contextList);
    }

    private static void transformRoot(BookRoot root) {
        contextList.add("<TITLE>" + root.getTitle() + "</TITLE>");
        contextList.add("<H1>" + root.getH1() + "</H1>");
        transformDL(root.getFolder(), 0);
    }

    private static void transformDL(Folder folder, int level) {
        Folder.H3 h3 = folder.getH3();
        if (h3 != null) {
            StringBuilder builder = new StringBuilder();
            builder.append(calcBlank(level))
                    .append("<DT>")
                    .append("<H3 ")
                    .append("ADD_DATE=")
                    .append(h3.getAdd_date())
                    .append(" ")
                    .append("LAST_MODIFIED=")
                    .append(h3.getLast_modified())
                    .append(">")
                    .append(h3.getValue())
                    .append("</H3>");
            contextList.add(builder.toString());
        }
        contextList.add(calcBlank(level) + "<DL><p>");
        List<Folder> folders = folder.getFolders();
        for (Folder tmpFolder : folders) {
            transformDL(tmpFolder, level + 1);
        }
        List<Page> pages = folder.getPages();
        for (Page tmpPage : pages) {
            transformDT(tmpPage, level + 1);
        }
        contextList.add(calcBlank(level) + "</DL><p>");
    }

    private static void transformDT(Page page, int level) {
        StringBuilder builder = new StringBuilder();
        builder.append(calcBlank(level))
                .append("<DT>")
                .append("<A ")
                .append("HREF=")
                .append(page.getHref())
                .append(" ")
                .append("ADD_DATE=")
                .append(page.getAdd_date());
        if (page.getIcon() != null) {
            builder.append(" ")
                    .append("ICON=")
                    .append(page.getIcon());
        }
        builder.append(">")
                .append(page.getValue())
                .append("</A>");
        contextList.add(builder.toString());
    }

    private static String calcBlank(int level) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < level; i++) {
            builder.append("    ");
        }
        return builder.toString();
    }

}

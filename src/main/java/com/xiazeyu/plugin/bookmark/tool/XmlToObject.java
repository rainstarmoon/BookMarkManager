package com.xiazeyu.plugin.bookmark.tool;

import com.xiazeyu.plugin.bookmark.bean.BookRoot;
import com.xiazeyu.plugin.bookmark.bean.Folder;
import com.xiazeyu.plugin.bookmark.bean.Page;
import com.xiazeyu.plugin.bookmark.util.FileUtil;
import com.xiazeyu.plugin.bookmark.util.LabelUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class XmlToObject {

    static String inputPath;

    static List<String> contextList;

    public static void init() {
        inputPath = "D:\\Github_Workspace\\BookMarkManager\\demo\\bookmarks_2019_11_13.html";
        contextList = new ArrayList<>();
    }

    public static BookRoot transform() {
        int beginIndex = 0;
        FileUtil.inputJavaFile(inputPath, contextList);
        for (int i = beginIndex; i < contextList.size(); i++) {
            String context = contextList.get(i);
            if (context.startsWith("<META ")) {
                beginIndex = i;
            }
        }
        BookRoot root = new BookRoot();
        Map<String, List<String>> title = LabelUtil.analysisLabel("TITLE", beginIndex + 1, contextList);
        root.setTitle(title.get("VALUE").get(0));
        Map<String, List<String>> h1 = LabelUtil.analysisLabel("H1", beginIndex + 2, contextList);
        root.setH1(h1.get("VALUE").get(0));
        Map<String, List<String>> dl = LabelUtil.analysisLabel("DL", beginIndex + 3, contextList);
        root.setFolder(transformDL(dl.get("VALUE")));
        return root;
    }

    private static Folder transformDL(List<String> contextList) {
        Folder folder = new Folder();
        for (int i = 0; i < contextList.size(); ) {
            String context = contextList.get(i).trim();
            if (context.startsWith("<DT><A")) {
                Map<String, List<String>> a = LabelUtil.analysisLabel("A", i, contextList);
                folder.addPage(new Page(a));
                i++;
                continue;
            }
            if (context.startsWith("<DT><H3")) {
                Map<String, List<String>> h3 = LabelUtil.analysisLabel("H3", i, contextList);
                Map<String, List<String>> dl = LabelUtil.analysisLabel("DL", i + 1, contextList);
                List<String> value = dl.get("VALUE");
                Folder tmp = transformDL(value);
                tmp.setH3(new Folder.H3(h3));
                folder.addFolder(tmp);
                i += value.size() + 3;
                continue;
            }
        }
        return folder;
    }


}

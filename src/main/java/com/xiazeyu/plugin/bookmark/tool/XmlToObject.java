package com.xiazeyu.plugin.bookmark.tool;

import com.xiazeyu.plugin.bookmark.bean.BookMarkDL;
import com.xiazeyu.plugin.bookmark.bean.BookMarkDT;
import com.xiazeyu.plugin.bookmark.bean.BookMarkRoot;
import com.xiazeyu.plugin.bookmark.util.FileUtil;
import com.xiazeyu.plugin.bookmark.util.LabelUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class XmlToObject {

    static String inputPath;

    static List<String> contextList;

    public static void init() {
        inputPath = "E:\\workspace_MySelf\\BookMarkManager\\demo\\bookmarks_2019_11_13.html";
        inputPath = "E:\\workspace_MySelf\\BookMarkManager\\demo\\收藏20191113-005311.html";
        contextList = new ArrayList<>();
    }

    public static BookMarkRoot transform() {
        BookMarkRoot root = new BookMarkRoot();
        int beginIndex = 0;
        FileUtil.inputJavaFile(inputPath, contextList);
        for (int i = beginIndex; i < contextList.size(); i++) {
            String context = contextList.get(i);
            if (context.startsWith("<META ")) {
                beginIndex = i;
            }
        }
        Map<String, List<String>> title = LabelUtil.analysisLabel("TITLE", beginIndex + 1, contextList);
        root.setTitle(title.get("VALUE").get(0));
        Map<String, List<String>> h1 = LabelUtil.analysisLabel("H1", beginIndex + 2, contextList);
        root.setH1(h1.get("VALUE").get(0));
        Map<String, List<String>> dl = LabelUtil.analysisLabel("DL", beginIndex + 3, contextList);
        root.setDl(transformDl(dl.get("VALUE")));
        return root;
    }

    public static BookMarkDL transformDl(List<String> contextList) {
        BookMarkDL bookMarkDL = new BookMarkDL();
        for (int i = 0; i < contextList.size(); ) {
            String context = contextList.get(i).trim();
            if (context.startsWith("<DT><A")) {
                Map<String, List<String>> a = LabelUtil.analysisLabel("A", i, contextList);
                bookMarkDL.addDt(new BookMarkDT(a.get("HREF"), a.get("ADD_DATE"), a.get("ICON"), a.get("VALUE")));
                i++;
                continue;
            }
            if (context.startsWith("<DT><H3")) {
                Map<String, List<String>> h3 = LabelUtil.analysisLabel("H3", i, contextList);
                Map<String, List<String>> dl = LabelUtil.analysisLabel("DL", i + 1, contextList);
                List<String> value = dl.get("VALUE");
                BookMarkDL tmp = transformDl(value);
                tmp.setH3(new BookMarkDL.H3(h3.get("ADD_DATE").get(0), h3.get("LAST_MODIFIED").get(0), h3.get("VALUE").get(0)));
                bookMarkDL.addDl(tmp);
                i += value.size() + 3;
                continue;
            }
        }
        return bookMarkDL;
    }


}

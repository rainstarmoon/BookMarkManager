package com.xiazeyu.plugin.bookmark.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 文件夹
 */
@Getter
@Setter
public class Folder {

    // 文件夹标题
    private H3 h3;

    // 子文件夹
    private List<Folder> folders = new ArrayList<>();

    // 书签
    private List<Page> pages = new ArrayList<>();

    public void addFolder(Folder folder) {
        folders.add(folder);
    }

    public void addPage(Page page) {
        pages.add(page);
    }

    @Override
    public String toString() {
        return "Folder{" + h3 + "}";
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class H3 {

        private String add_date;
        private String last_modified;
        //private String personal_toolbar_folder;
        private String value;

        public H3(Map<String, List<String>> map) {
            this.add_date = map.get("ADD_DATE").stream().findFirst().orElse(null);
            this.last_modified = map.get("LAST_MODIFIED").stream().findFirst().orElse(null);
            this.value = map.get("VALUE").stream().findFirst().orElse(null);
        }

        @Override
        public String toString() {
            return value;
        }
    }

}

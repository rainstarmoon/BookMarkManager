package com.xiazeyu.plugin.bookmark.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件夹
 * <DT><H3 ADD_DATE="" LAST_MODIFIED="">test</H3>
 * <DL>
 * <DT><A HREF="" ADD_DATE="" ICON="">RSA</A>
 * </DL>
 * <DT><A HREF="" ADD_DATE="" ICON="">百度一下</A>
 */
@Data
public class BookMarkDL {

    /**
     * 文件夹标题
     */
    private H3 h3;

    /**
     * 子文件夹
     */
    private List<BookMarkDL> dls = new ArrayList<>();

    /**
     * 书签
     */
    private List<BookMarkDT> dts = new ArrayList<>();

    public void addDl(BookMarkDL dl) {
        dls.add(dl);
    }

    public void addDt(BookMarkDT dt) {
        dts.add(dt);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class H3 {
        private String add_date;
        private String last_modified;
        //private String personal_toolbar_folder;
        private String value;
    }

}

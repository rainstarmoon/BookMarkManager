package com.xiazeyu.plugin.bookmark.bean;

import lombok.*;

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
@Getter
@Setter
public class BookMarkDL {

    /**
     * 文件夹标题
     */
    private H3 h3 = new H3();

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

    @Override
    public String toString() {
        return "BookMarkDL{" +
                "h3=" + h3.value +
                '}';
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

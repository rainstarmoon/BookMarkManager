package com.xiazeyu.plugin.bookmark.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 文件夹
 * <DT><H3 ADD_DATE="" LAST_MODIFIED="">test</H3>
 * <DL>
 * 	    <DT><A HREF="" ADD_DATE="" ICON="">RSA</A>
 * </DL>
 * <DT><A HREF="" ADD_DATE="" ICON="">百度一下</A>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookMarkDL {

    /**
     * 文件夹标题
     */
    private H3 h3;

    /**
     * 子文件夹
     */
    private List<BookMarkDL> dl;

    /**
     * 书签
     */
    private List<BookMarkDT> dt;

    @Data
    public static class H3 {
        private String add_date;
        private String last_modified;
        private String personal_toolbar_folder;
        private String value;
    }

}

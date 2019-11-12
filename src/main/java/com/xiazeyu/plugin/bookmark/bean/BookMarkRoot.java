package com.xiazeyu.plugin.bookmark.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据根
 * <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
 * <TITLE>Bookmarks</TITLE>
 * <H1>Bookmarks</H1>
 * <DL>
 *
 * </DL>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookMarkRoot {

    private String title;

    private String h1;

    /**
     * 默认第一个是书签栏目录
     */
    private BookMarkDL dl;


}

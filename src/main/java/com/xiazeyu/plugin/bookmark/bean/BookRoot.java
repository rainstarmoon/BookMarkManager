package com.xiazeyu.plugin.bookmark.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * 数据根
 * <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
 * <TITLE>Bookmarks</TITLE>
 * <H1>Bookmarks</H1>
 * <DL>
 *
 * </DL>
 */
@Getter
@Setter
public class BookRoot {

    private String title;

    private String h1;

    /**
     * 默认第一个是书签栏目录
     * 没有标题
     */
    private Folder folder;

}

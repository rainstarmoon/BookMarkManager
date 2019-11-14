package com.xiazeyu.plugin.bookmark.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * <DT><A HREF="https://docs.open.alipay.com/58/103242" ADD_DATE="1573021397" ICON="data:image/png;base64,iVBORw">开放平台文档中心</A>
 */
@Getter
@Setter
public class Page {

    private String href;

    private String add_date;

    private String icon;

    private String value;

    public Page(Map<String, List<String>> map) {
        if (map.get("HREF") != null) {
            this.href = map.get("HREF").stream().findFirst().orElse(null);
        }
        if (map.get("ADD_DATE") != null) {
            this.add_date = map.get("ADD_DATE").stream().findFirst().orElse(null);
        }
        if (map.get("ICON") != null) {
            this.icon = map.get("ICON").stream().findFirst().orElse(null);
        }
        if (map.get("VALUE") != null) {
            this.value = map.get("VALUE").stream().findFirst().orElse(null);
        }
    }

    @Override
    public String toString() {
        return "Page{" + value + "}";
    }

}

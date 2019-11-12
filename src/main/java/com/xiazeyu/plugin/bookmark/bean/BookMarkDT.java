package com.xiazeyu.plugin.bookmark.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * <DT><A></A>
 */
@Getter
@Setter
@NoArgsConstructor
public class BookMarkDT {

    private String href;

    private String add_date;

    private String icon;

    private String value;

    public BookMarkDT(List<String> hrefs, List<String> add_dates, List<String> icons, List<String> values) {
        this.href = hrefs != null ? hrefs.get(0) : null;
        this.add_date = add_dates != null ? add_dates.get(0) : null;
        this.icon = icons != null ? icons.get(0) : null;
        this.value = values != null ? values.get(0) : null;
    }

    @Override
    public String toString() {
        return "BookMarkDT{" +
                "value='" + value + '\'' +
                '}';
    }
}

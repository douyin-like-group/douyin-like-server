package com.rocky.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class PagedGridResult {

    private int page; // current page

    private long total; // total number of pages

    private long records; // total records

    private List<?> rows;  // 每行显示的内容

}

package com.gary.ym.utils;

import java.util.ArrayList;
import java.util.List;

public class JqgridPage<T> {

    //-- 公共变量 --//
    public static final String ASC = "asc";
    public static final String DESC = "desc";

    //-- 分页参数 --//
    protected int pageNo = 1;
    protected int pageSize = -1;
    protected long total = -1;
    private String sort;
    private String sord;//asc
    private String sidx;//code
    private List<T> rows= new ArrayList<T>();
    private int page;//rows=50
    private long totPage;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getTotPage() {
        return totPage;
    }

    public void setTotPage(long totPage) {
        this.totPage = totPage;
    }
}

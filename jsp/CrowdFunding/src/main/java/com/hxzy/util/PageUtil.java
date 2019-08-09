package com.hxzy.util;

import java.util.List;

public class PageUtil<T> {
    private int pageIndex = 1;  //当前页码
    private int pageSize = 3; //每页显示多少条数据
    private int total;      //总共有多少条数据，应该从数据库查出
    private int pages;   //总共有多少页
    private List<T> data;   //分页查询出的数据
    final int navigationCount = 5;
    int[] pageNavigation = null;  //用于存储分页数字

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
        getPages();
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPages(){
        //计算总共有多少页
        //double pages = Math.ceil((double) total / pageSize);
        if (total % pageSize == 0) {
            this.pages = total / pageSize;
        } else {
            this.pages = total / pageSize + 1;
        }
        this.pageNavigation = getNav();
        return this.pages;
    }


    public int[] getNav(){
        //当总页数小于或等于导航页码数时
        if (pages <= navigationCount) {
            pageNavigation = new int[pages];
            for (int i = 0; i < pages; i++) {
                pageNavigation[i] = i + 1;
            }
        } else { //当总页数大于导航页码数时
            pageNavigation = new int[navigationCount];
            int startNum = pageIndex - navigationCount / 2;
            int endNum = pageIndex + navigationCount / 2;

            if (startNum < 1) {
                startNum = 1;
                //(最前navPageCount页
                for (int i = 0; i < navigationCount; i++) {
                    pageNavigation[i] = startNum++;
                }
            } else if (endNum > pages) {
                endNum = pages;
                //最后navPageCount页
                for (int i = navigationCount - 1; i >= 0; i--) {
                    pageNavigation[i] = endNum--;
                }
            } else {
                //所有中间页
                for (int i = 0; i < navigationCount; i++) {
                    pageNavigation[i] = startNum++;
                }
            }
        }
        return pageNavigation;
    }
}

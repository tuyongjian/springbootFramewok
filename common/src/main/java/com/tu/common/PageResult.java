package com.tu.common;

import java.util.List;

/**
 * @Description 分页结果实体
 * @Classname PageResult
 * @Date 2019/9/2 14:33
 * @Created by tuyongjian
 */
public class PageResult<T> {

    //结果集
    private List<T> list;

    //总页数
    private Integer totalPages;

    //总记录数
    private Long total;

    //最后一页
    private Integer lastPage;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }
}
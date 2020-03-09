package com.sages.app.model.vo;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * @author wanyifan
 * @date 2020/3/4
 */
@Data
public class PageTable {
    private Integer code;
    private String msg;
    private Long total;
    private Integer count;
    private List<?> data;

    public PageTable(PageInfo<?> pageInfo) {
        this.code = 0;
        this.msg = "ok";
        this.total = pageInfo.getTotal();
        this.count = pageInfo.getPageNum();
        this.data = pageInfo.getList();
    }

    public PageTable(PageInfo<?> pageInfo, List<?> pageList) {
        this.code = 0;
        this.msg = "ok";
        this.total = pageInfo.getTotal();
        this.count = pageInfo.getPageNum();
        this.data = pageList;
    }

    public PageTable(Long total, Integer count, List<?> pageList) {
        this.code = 0;
        this.msg = "";
        this.total = total;
        this.count = count;
        this.data = pageList;
    }
}

package com.sages.app.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wanyifan
 * @date 2020/3/5
 */
@Data
@NoArgsConstructor
public class TreeVO {
    private Integer id;
    private String title;
    private String fieId;
    private Boolean spread;
    private List<TreeVO> children;

    public TreeVO(Integer id, String title, String fieId, List<TreeVO> children) {
        this.spread = true;
        this.id = id;
        this.title = title;
        this.fieId = fieId;
        this.children = children;
    }
}

package com.sages.app.model.post;

import com.sages.app.model.entity.BookInfo;
import com.sages.app.model.entity.BookSpu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wanyifan
 * @date 2020/3/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookSpuPost {

    private Integer id;
    private String name;
    private String title;
    private Integer authorId;
    private String authorName;
    private Integer publishingHouseId;
    private String publishingHouseName;
    private Integer categoryId;
    private String description;

    private String catalog;
    private String contentIntro;
    private String editorRecommend;

    public BookSpu getBookSpu() {
        BookSpu res = new BookSpu();
        res.setId(id);
        res.setName(name);
        res.setTitle(title);
        res.setAuthorId(authorId);
        res.setPublishingHouseId(publishingHouseId);
        res.setCategoryId(categoryId);
        res.setDescription(description);
        return res;
    }

    public BookInfo getBookInfo() {
        BookInfo res = new BookInfo();
        res.setCatalog(catalog);
        res.setContentIntro(contentIntro);
        res.setEditorRecommend(editorRecommend);
        res.setSpuId(id);
        return res;
    }

}

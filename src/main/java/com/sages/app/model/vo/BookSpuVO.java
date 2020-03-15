package com.sages.app.model.vo;

import com.sages.app.constant.SystemConstant;
import com.sages.app.model.entity.*;
import lombok.Data;

import java.util.List;

/**
 * @author wanyifan
 * @date 2020/3/14
 */
@Data
public class BookSpuVO {
    private Integer id;

    private String name;

    private String title;

    private Integer authorId;

    private Integer publishingHouseId;

    private Integer categoryId;

    private String coverPic;

    private String description;

    private BookInfo bookInfo;

    private List<BookSku> bookSkuList;

    private List<BookSpuPic> bookSpuPicList;

    private Author author;

    private PublishingHouse publishingHouse;

    private Category category;

    public BookSpuVO(BookSpu bookSpu) {
        this.id = bookSpu.getId();
        this.name = bookSpu.getName();
        this.title = bookSpu.getTitle();
        this.authorId = bookSpu.getAuthorId();
        this.publishingHouseId = bookSpu.getPublishingHouseId();
        this.categoryId = bookSpu.getCategoryId();
        this.coverPic = SystemConstant.BOOK_PIC_URL + bookSpu.getCoverPic();
        this.description = bookSpu.getDescription();
        this.bookInfo = bookSpu.getBookInfo();
        bookInfo.setCatalog(bookInfo.getCatalog().replace("/n", "</br>"));
        this.bookSkuList = bookSpu.getBookSkuList();
        this.bookSpuPicList = bookSpu.getBookSpuPicList();
        for (BookSpuPic bookSpuPic : bookSpuPicList) {
            bookSpuPic.setPicUrl(SystemConstant.BOOK_PIC_URL + bookSpuPic.getPicUrl());
        }
        this.author = bookSpu.getAuthor();
        this.publishingHouse = bookSpu.getPublishingHouse();
        this.category = bookSpu.getCategory();
    }
}

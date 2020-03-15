package com.sages.app.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sages.app.constant.SystemConstant;
import com.sages.app.constant.enums.BookSkuTypeEnum;
import com.sages.app.model.entity.BookSku;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author wanyifan
 * @date 2020/3/6
 */
@Data
@NoArgsConstructor
public class BookSkuVO {
    private Integer id;

    private String name;

    private String coverPic;

    private Integer type;

    private String typeName;

    private String version;

    @JsonFormat(pattern = "yyyy-MM")
    private LocalDateTime publishTime;

    private Integer repertoryNum;

    private Double currentPrice;

    private Double originalPrice;

    private Integer soldNum;

    private Integer spuId;

    public BookSkuVO(BookSku sku) {
        this.id = sku.getId();
        this.name = sku.getName();
        this.coverPic = SystemConstant.BOOK_PIC_URL + sku.getCoverPic();
        this.type = sku.getType();
        this.typeName = BookSkuTypeEnum.getName(sku.getType());
        this.version = sku.getVersion();
        this.publishTime = sku.getPublishTime();
        this.repertoryNum = sku.getRepertoryNum();
        if (repertoryNum.equals(-1)){
            repertoryNum = 999;
        }
        this.currentPrice = sku.getCurrentPrice();
        this.originalPrice = sku.getOriginalPrice();
        this.soldNum = sku.getSoldNum();
        this.spuId = sku.getSpuId();
    }
}

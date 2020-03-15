package com.sages.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sages.app.model.entity.BookSku;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wanyifan
 * @since 2020-03-03
 */
public interface BookSkuMapper extends BaseMapper<BookSku> {

    /**
     * 根据spuId搜索所有sku
     *
     * @param id spu_id
     * @return list
     */
    @Select("select * from book_sku where spu_id = #{id}")
    List<BookSku> selectBySpuId(Integer id);
}

package com.sages.app.service;

import com.sages.app.model.vo.MessageVO;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wanyifan
 * @version 1.0
 * @date 2020/3/10 8:57 下午
 */
public interface FileService {
    /**
     * 保存书籍图片
     *
     * @Title: saveBookPicture
     *
     * @param id: 
	 * @param file: 
     * @return com.sages.app.model.vo.MessageVO
     * @Author: wanyifan
     * @Date: 2020/3/10 9:36 下午
     */
    MessageVO saveBookPicture(Integer id,MultipartFile file);

    /**
     * 上传多个图片
     *
     * @Title: saveBookPicture
     *
     * @param id:
     * @param files:
     * @return com.sages.app.model.vo.MessageVO
     * @Author: wanyifan
     * @Date: 2020/3/11 12:33 下午
     */
    MessageVO saveBookPicture(Integer id,MultipartFile[] files);

    /**
     * 保存书籍封面
     *
     * @Title: saveBookCover
     *
     * @param id: 
	 * @param file:
     * @param type 1:spu 2:sku
     * @return com.sages.app.model.vo.MessageVO
     * @Author: wanyifan
     * @Date: 2020/3/10 9:34 下午
     */
    MessageVO saveBookCover(Integer id,MultipartFile file,Integer type);
}

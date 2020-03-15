package com.sages.app.service.impl;

import com.sages.app.constant.ConstantProperty;
import com.sages.app.constant.SystemConstant;
import com.sages.app.model.entity.BookSku;
import com.sages.app.model.entity.BookSpu;
import com.sages.app.model.entity.BookSpuPic;
import com.sages.app.model.vo.MessageVO;
import com.sages.app.service.FileService;
import com.sages.app.service.IBookSkuService;
import com.sages.app.service.IBookSpuPicService;
import com.sages.app.service.IBookSpuService;
import com.sages.app.util.FileUtil;
import com.sages.app.util.ImageTypeUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wanyifan
 * @version 1.0
 * @date 2020/3/10 9:22 下午
 */
@Service
public class FileServiceImpl implements FileService {
    private final Integer SPU_TYPE = 1;
    private final Integer SKU_TYPE = 2;

    private final IBookSpuPicService bookSpuPicService;
    private final IBookSpuService bookSpuService;
    private final IBookSkuService bookSkuService;

    public FileServiceImpl(IBookSpuPicService bookSpuPicService, IBookSpuService bookSpuService, IBookSkuService bookSkuService) {
        this.bookSpuPicService = bookSpuPicService;
        this.bookSpuService = bookSpuService;
        this.bookSkuService = bookSkuService;
    }

    @Override
    public MessageVO saveBookPicture(Integer id, MultipartFile file) {
        String s = saveLocalPath(file);
        if (s == null) {
            return MessageVO.fail("文件格式转换异常");
        }
        boolean b = bookSpuPicService.save(new BookSpuPic(id, s));
        return b ? MessageVO.successUrl(SystemConstant.BOOK_PIC_URL + s) : MessageVO.fail();
    }

    @Override
    public MessageVO saveBookPicture(Integer id, MultipartFile[] files) {
        Integer count = 0;
        List<BookSpuPic> res = new ArrayList<>();
        List<String> successUrls = new ArrayList<>();
        for (MultipartFile file : files) {
            String s = saveLocalPath(file);
            if (s == null) {
                count++;
            } else {
                successUrls.add(s);
                res.add(new BookSpuPic(id, s));
            }
        }
        boolean b = bookSpuPicService.saveBatch(res);
        return b ? MessageVO.successUrl(successUrls) : MessageVO.fail();
    }

    @Override
    public MessageVO saveBookCover(Integer id, MultipartFile file, Integer type) {
        String s = saveLocalPath(file);
        if (s == null) {
            return MessageVO.fail("文件格式转换异常");
        }
        boolean b = false;
        if (type.equals(SPU_TYPE)){
            BookSpu bookSpu = new BookSpu();
            bookSpu.setId(id);
            bookSpu.setCoverPic(s);
            b = bookSpuService.updateById(bookSpu);
        }else{
            BookSku bookSku = new BookSku();
            bookSku.setId(id);
            bookSku.setCoverPic(s);
            b = bookSkuService.updateById(bookSku);
        }
        return b ? MessageVO.successUrl(SystemConstant.BOOK_PIC_URL + s) : MessageVO.fail();
    }

    private String saveLocalPath(MultipartFile file) {
        // 得到路径
        String path = ConstantProperty.localBookPicPath;
        // 得到后缀名
        String suffix = null;
        try {
            suffix = ImageTypeUtil.getPicType(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (suffix == null) {
            return null;
        }
        // 文件夹名
        String folder = FileUtil.reFolderNameToDate();
        path += folder;
        // 文件名
        String filename = FileUtil.renameToUUID(suffix);
        try {
            FileUtil.uploadFile(file.getBytes(), path, filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return folder + filename;
    }
}

package com.tuhu.future.Util;

import com.tuhu.future.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author yangcheng1
 * @Title: FileUtil
 * @ProjectName future-mybatis-parent
 * @Description: TODO
 * @date 2018/7/1217:55
 */
public class FileUtil {

    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);



    public static void uploadFile(MultipartFile file){
        if (file == null) {
            throw new BizException("文件为空");
        }
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取文件后缀
        String suffixName = fileName.substring(fileName.indexOf("."));
        logger.info("文件的后缀名是:"+suffixName);
        File dest = new File(Contants.FILEPATH+fileName);
        //检测目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }

        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkSuffixName(MultipartFile file){
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取文件后缀
        String suffixName = fileName.substring(fileName.indexOf("."));

        if (!suffixName.equals(".jpg") || !suffixName.equals(".jpge") || !suffixName.equals(".png")) {
            return false;
        }

        return true;
    }

}

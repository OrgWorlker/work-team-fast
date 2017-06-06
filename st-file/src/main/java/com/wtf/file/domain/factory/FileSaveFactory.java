package com.wtf.file.domain.factory;

import com.wtf.infsc.infrastructure.configure.FileProperties;
import com.wtf.infsc.infrastructure.stereotype.FactoryService;
import com.wtf.infsc.infrastructure.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * The type File save factory.
 */
@Slf4j
@FactoryService
public class FileSaveFactory {

    @Resource
    private FileProperties fileProperties;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * Save file boolean.
     *
     * @param file the file
     * @return the boolean
     */
    public String saveFile(MultipartFile file) {
        if (file.isEmpty()) {
            return null;
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        log.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件上传后的路径
        // 解决中文问题，liunx下中文路径，图片显示问题
        final String filePath = this.fileProperties.getFilePath() + this.fileProperties.getDir();
        final String pathname = filePath + UUID.randomUUID() + suffixName;
        File dest = new File(pathname);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            if (dest.getParentFile().mkdirs()){
                log.info("检测到文件夹不存在，创建 {}", filePath);
            }
        }
        try {
            file.transferTo(dest);
            final String filekey = MD5Util.md5Encode(UUID.randomUUID().toString());
            this.stringRedisTemplate.opsForValue().set(filekey, pathname);
            return filekey;
        } catch (IllegalStateException | IOException e) {
            log.error(e.getMessage(),e);
        }
        return null;
    }

    /**
     * Gets file path name.
     *
     * @param fileKey the file key
     * @return the file path name
     */
    public String getFilePathName(String fileKey) {
        return this.stringRedisTemplate.opsForValue().get(fileKey);
    }
}

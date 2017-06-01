package com.wtf.file.application;

import com.wtf.file.domain.dto.FileResult;
import com.wtf.file.domain.factory.FileSaveFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * The type File controller.
 */
@Controller
@Slf4j
public class FileController {

    @Resource
    private FileSaveFactory fileSaveFactory;
    @Resource
    private  ResourceLoader resourceLoader;

    /**
     * Upload file result.
     *
     * @param file the file
     * @return the file result
     */
//文件上传相关代码
    @RequestMapping(value = "upload")
    @ResponseBody
    public FileResult upload(@RequestParam MultipartFile file) {
        final String fileKey = this.fileSaveFactory.saveFile(file);
        if (StringUtils.isNotBlank(fileKey)) {
            return new FileResult("200", fileKey);
        }
        return new FileResult("20001", "error");
    }


    /**
     * Download file output stream.
     *
     * @param filekey the filekey
     * @return the response entity
     * @throws Exception the exception
     */
    @RequestMapping("/download/{filekey}")
    public ResponseEntity<?> downloadFile(@PathVariable String filekey) throws Exception {
        try {
            final String filePathName = this.fileSaveFactory.getFilePathName(filekey);
            FileSystemResource file = new FileSystemResource(filePathName);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentLength(file.contentLength())
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(new InputStreamResource(file.getInputStream()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Gets file.
     *
     * @param filekey the filekey
     * @return the file
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{filekey}")
    public void getFile(@PathVariable String filekey, HttpServletResponse response) {
        FileInputStream in;
        response.setContentType("application/octet-stream;charset=UTF-8");
        try {
            //图片读取路径
            final String filePathName = this.fileSaveFactory.getFilePathName(filekey);
            in=new FileInputStream(filePathName);
            int i=in.available();
            byte[]data=new byte[i];
            in.read(data);
            in.close();

            //写图片
            OutputStream outputStream=new BufferedOutputStream(response.getOutputStream());
            outputStream.write(data);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Handle file upload object.
     *
     * @param request the request
     * @return the object
     */
//多文件上传
    @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
    @ResponseBody
    public Object handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        final List<String> fileKeys = new ArrayList<>();
        for (MultipartFile file : files) {
            final String fileKey = this.fileSaveFactory.saveFile(file);
            if (StringUtils.isNotBlank(fileKey)){
                fileKeys.add(fileKey);
            }
        }
        if (!fileKeys.isEmpty()) {
            return new FileResult("200", fileKeys);
        }
        return new FileResult("20001", "error");
    }
}

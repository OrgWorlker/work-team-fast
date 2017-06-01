package com.wtf.file.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The type File result.
 */
@Setter
@Getter
public class FileResult {

    private String code = "200";

    private String fileKey;

    private List<String> fileKeys;

    /**
     * Instantiates a new File result.
     *
     * @param code    the code
     * @param fileKey the file key
     */
    public FileResult(String code, String fileKey) {
        this.code = code;
        this.fileKey = fileKey;
    }

    /**
     * Instantiates a new File result.
     *
     * @param code     the code
     * @param fileKeys the file keys
     */
    public FileResult(String code, List<String> fileKeys) {
        this.code = code;
        this.fileKeys = fileKeys;
    }
}

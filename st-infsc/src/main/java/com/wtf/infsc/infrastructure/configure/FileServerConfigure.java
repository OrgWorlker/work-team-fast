package com.wtf.infsc.infrastructure.configure;

import com.wtf.infsc.infrastructure.stereotype.Properties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The type File server configure.
 */
@Setter
@Getter
@Properties
@ConfigurationProperties(prefix = FileServerConfigure.PREFIX)
public class FileServerConfigure {
    /**
     * The constant PREFIX.
     */
    final static String PREFIX = "file-server";
    private static final String HTTP_START = "http://";
    private static final String PORT_PREFIX = ":";
    private static final String SEQ = "/";
    /**
     * The Host.
     */
    private String host = "http://localhost";

    /**
     * The Port.
     */
    private String port = "9100";

    /**
     * The App name.
     */
    private String appName = "";


    /**
     * The Download.
     */
    private String download = "download";

    /**
     * The Upload.
     */
    private String upload = "upload";

    /**
     * The Batch upload.
     */
    private String batchUpload = "batch/upload";

    /**
     * Gets file server url.
     * 获取文件服务的HTTP地址
     *
     * @return the file server url
     */
    public String getFileServerUrl() {
        if (!this.host.startsWith(HTTP_START)) {
            this.host = HTTP_START + this.host;
        }
        return this.host + PORT_PREFIX + this.port + SEQ + this.appName;
    }
}

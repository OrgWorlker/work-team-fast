package com.wtf.file.infrastructure.configure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The type File config.
 */
@Setter
@Getter
@ToString
@ConfigurationProperties(prefix = "file")
@Component
public class FileConfigure {

    private static final  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     *  linux path
     */
    private String linuxPath;

    /**
     * window path
     */
    private String windowPath;

    /**
     * Gets file path.
     *
     * @return the file path
     */
    public String getFilePath() {
        final String osName = System.getProperty("os.name").toLowerCase();
        if (osName.startsWith("window")) {
            return this.windowPath;
        }
        return this.linuxPath;
    }

    /**
     * Gets dir.
     *
     * @return the dir
     */
    public String getDir() {
        return simpleDateFormat.format(new Date()) + simpleDateFormat.format(new Date())+ File.separator;
    }
}

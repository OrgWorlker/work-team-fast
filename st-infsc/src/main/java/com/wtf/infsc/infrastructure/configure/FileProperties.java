package com.wtf.infsc.infrastructure.configure;

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
@ConfigurationProperties(prefix = FileProperties.PREFIX)
@Component
public class FileProperties {

    public  static final String PREFIX = "file";

    private String pattern = "yyyy-MM-dd";

    private  SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.pattern);

    /**
     *  linux path
     */
    private String linuxPath = "/SPRING/FILE/";

    /**
     * window path
     */
    private String windowPath ="C:/Users/SPRING/FILE/";
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
        return this.simpleDateFormat.format(new Date()) + File.separator;
    }
}

package com.wtf;

import com.wtf.infsc.infrastructure.configure.FileServerConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

/**
 * The type Buyers application.
 */
@EnableTransactionManagement
@SpringBootApplication
@ServletComponentScan
@EnableCaching
@EnableScheduling
public class BuyersApplication {

    @Resource
    private FileServerConfigure fileServerConfigure;
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        SpringApplication.run(BuyersApplication.class, args);

    }
}

package com.wtf.file.infrastructure.configure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FileConfigureTest {
    @Resource
    private FileConfigure fileConfig;
    @Test
    public void getFilePath() throws Exception {
        this.fileConfig.getFilePath();
        System.out.println(this.fileConfig.toString());
    }

}
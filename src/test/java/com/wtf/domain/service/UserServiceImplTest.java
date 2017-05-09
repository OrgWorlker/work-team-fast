package com.wtf.domain.service;

import com.wtf.interfaces.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * The type User service impl test.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    @Resource
    private IUserService userService;

    /**
     * Find by user name.
     *
     * @throws Exception the exception
     */
    @Test
    public void findByUserName() throws Exception {
        this.userService.findByUserName("ROOT");
    }

    /**
     * Find by id.
     *
     * @throws Exception the exception
     */
    @Test
    public void findById() throws Exception {
        this.userService.findById(1L);
    }

}
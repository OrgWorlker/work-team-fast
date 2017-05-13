package com.wtf.common.dao;

import com.github.pagehelper.PageHelper;
import com.wtf.domain.model.User;
import com.wtf.interfaces.repository.IUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zc.lin on 2017/5/4.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class IUserMapperTest {
    @Resource
    IUserMapper usersMapper;

    @Test
    public void findById() throws Exception {
        this.usersMapper.findById(1L);
    }

    @Test
    public void findAll() throws Exception {
        PageHelper.startPage(0, 10);
        final List<User> all = this.usersMapper.findAll(new User());
        for (User user : all) {
            System.out.println("user = " + user);
        }
    }
}
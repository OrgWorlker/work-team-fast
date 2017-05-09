package com.wtf.domain.manager;

import com.wtf.domain.dto.UserLoginDto;
import com.wtf.interfaces.manager.IUserManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * The type User manager impl test.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserManagerImplTest {
    @Resource
    private IUserManager userManager;

    /**
     * Check user name and login password.
     *
     * @throws Exception the exception
     */
    @Test
    public void checkUserNameAndLoginPassword() throws Exception {
        final UserLoginDto userLoginDto = this.userManager.checkUserNameAndLoginPassword("ROOT", "ROOT", 1);
        Assert.assertTrue(userLoginDto.getFlag() == 1);
        final UserLoginDto root = this.userManager.checkUserNameAndLoginPassword("ROOT", "123456", 2);
        Assert.assertTrue(root.getFlag() == 0);
        final UserLoginDto root1 = this.userManager.checkUserNameAndLoginPassword("ROOT1", "123456", 2);
        Assert.assertTrue(root1.getFlag() == 0);
    }

    /**
     * Check user trade pwd.
     *
     * @throws Exception the exception
     */
    @Test
    public void checkUserTradePwd() throws Exception {

    }

}
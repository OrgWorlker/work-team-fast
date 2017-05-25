package com.wtf.core.domain.dto;


import com.wtf.core.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The type User login dto.
 */
@Setter
@Getter
@AllArgsConstructor
public class UserLoginDto {
    private int flag;
    private String msg;
    private User user;

    /**
     * Instantiates a new User login dto.
     *
     * @param flag the flag
     * @param msg  the msg
     */
    public UserLoginDto(int flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    /**
     * Clear pwd.清理数据中的密码，防止泄漏
     */
    public void clearPwd() {
        if (this.user != null) {
            this.user.setLoginPwd("");
            this.user.setTradePwd("");
        }
    }

}

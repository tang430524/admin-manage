package org.javajidi.admin.interfaces.commondobject;

/**
 * @author qiang.xie
 * @date 2016/9/29
 */
public class UserCommond {

    /** 主键ID */
    private String id;

    /** 登录名称 */
    private String username;

    /** 密码 */
    private String password;

    /** 邮箱 */
    private String email;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

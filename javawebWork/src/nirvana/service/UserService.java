package nirvana.service;

import nirvana.domain.User;

/**
 * @author YJL
 */
public interface UserService {
    /**
     * 用户登录
      * @param username 用户名
     * @param password 密码
     * @return
     */
    User login(String username,String password);

    /**
     * 新用户注册
     * @param username
     * @param password
     * @return
     */
    User regist(String username, String password);
    Boolean userNameExist(String username);
}

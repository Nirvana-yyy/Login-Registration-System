package nirvana.dao;

import nirvana.domain.User;

/**
 * @author YJL
 */
public interface UserDao {
    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    Boolean userNameExist(String username);

    /**
     * 添加新用户
     * @param username
     * @param password
     */
    User addUser(String username, String password);

    /**
     * 找到输入的用户，密码错误则返回null
     * @param username
     * @param password
     * @return
     */
    User usernameMatch(String username,String password);
}

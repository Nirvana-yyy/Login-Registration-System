package nirvana.service.impl;

import nirvana.dao.UserDao;
import nirvana.dao.impl.UserDaoImpl;
import nirvana.domain.User;
import nirvana.service.UserService;

/**
 * @author YJL
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public User login(String username, String password) {
        return dao.usernameMatch(username,password);
    }

    @Override
    public User regist(String username, String password) {
        if (dao.userNameExist(username)) {
            return null;
        }
        return dao.addUser(username,password);
    }

    @Override
    public Boolean userNameExist(String username) {
        return dao.userNameExist(username);
    }
}

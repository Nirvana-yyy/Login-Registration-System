package nirvana.dao.impl;

import nirvana.dao.UserDao;
import nirvana.domain.User;
import nirvana.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author YJL
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Boolean userNameExist(String username) {

        try{
            String sql = "select * from users where username = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public User addUser(String username, String password) {
        //定义sql
        String sql = "insert into users value(null, ? ,?)";
        //执行sql
        template.update(sql, username, password);

        return new User(null,username,password);
    }

    @Override
    public User usernameMatch(String username, String password) {
        try{
            String sql = "select * from users where username = ? and password = ?";
            User user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username,password);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

package com.online.market.db;

import com.online.market.model.User;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;

/**
 * Created by Alexander on 04.06.2017.
 */
@Repository
public class UserRepository extends BaseRepository<User> {

    public UserRepository(DataSource dataSource) {
        super(dataSource);
    }

    public void createUser(User user) {
        executeQuery("", rs -> null);
    }

    public User findByEmail() {
        return executeQuery("", rs -> new User());
    }

    public User findByLogin() {
        return executeQuery("", rs -> new User());
    }
}

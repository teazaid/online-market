package com.online.market.db;

import com.online.market.model.User;
import com.online.market.model.UserBuilder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alexander on 04.06.2017.
 */
@Repository
public class UserRepository extends BaseRepository<User> {

    public UserRepository(DataSource dataSource) {
        super(dataSource);
    }

    public void createUser(User user) {
        executeQuery("", null, this::mapper);
    }

    public List<User> findByEmail(String email) {
        return executeQuery("select * from users where email = ?", Arrays.asList(email), this::mapper);
    }

    public List<User> findByLogin(String login) {
        return executeQuery("select * from users where login = ?", Arrays.asList(login), this::mapper);
    }

    private List<User> mapper(ResultSet resultSet) {
        List<User> users = new ArrayList<User>();
        try {
            while (resultSet.next()) {
                UserBuilder ub = new UserBuilder();
                ub.id(resultSet.getLong("Id"))
                        .uuid(resultSet.getString("UUID"))
                        .firstName(resultSet.getString("FirstName"))
                        .lastName(resultSet.getString("LastName"))
                        .birthday(resultSet.getDate("Birthday"))
                        .country(resultSet.getString("Country"))
                        .email(resultSet.getString("Email"))
                        .login(resultSet.getString("Login"))
                        .passwordHash(resultSet.getString("Password"))
                        .phoneNumber(resultSet.getString("PhoneNumber"));

                User build = ub.build();

                users.add(build);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}

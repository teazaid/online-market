package com.online.market.configuration;

import com.online.market.db.UserRepository;
import com.online.market.http.model.CreateUserRequest;
import com.online.market.http.validation.*;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Date;

/**
 * Created by Alexander on 04.06.2017.
 */
@Configuration
public class CoreConfiguration {

    private DataSource dataSource;

    public CoreConfiguration() {
        HikariConfig config = new HikariConfig();
//        config.setDataSourceClassName("org.h2.jdbcx.JdbcDataSource");
        config.setDriverClassName("org.h2.Driver");
        config.setJdbcUrl("jdbc:h2:mem:test;INIT=runscript from 'classpath:/create.sql'\\;runscript from 'classpath:/init.sql'");
        config.setUsername("sa");
        config.setPassword("password");
        config.setMaximumPoolSize(5);
        dataSource = new HikariDataSource(config);
    }

    @Bean
    public Validator<CreateUserRequest> registrationValidator() {
        return new RegistrationValidatorImpl();
    }

    @Bean
    public Validator<Date> ageValidator() {
        return new AgeValidator();
    }

    @Bean
    public Validator<String> emailValidator() {
        return new EmailValidator();
    }

    @Bean
    public Validator<String> loginValidator() {
        return new LoginValidator();
    }

    @Bean
    public Validator<String> passwordValidator() {
        return new PasswordValidator();
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository(dataSource);
    }
}

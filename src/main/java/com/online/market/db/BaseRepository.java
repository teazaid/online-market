package com.online.market.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Function;

/**
 * Created by Alexander on 04.06.2017.
 */
abstract class BaseRepository<T> {
    private DataSource dataSource;

    public BaseRepository(javax.sql.DataSource dataSource) {
        this.dataSource = dataSource;
    }

    protected DataSource getDataSource() {
        return dataSource;
    }

    public T executeQuery(String query, Function<ResultSet, T> fun) {
        T result = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            resultSet = statement.executeQuery(query);
            result = fun.apply(resultSet);

            connection.commit();

        } catch (SQLException e) {

        } finally {
            closeResultSet(resultSet);
            closeStatement(statement);
            closeConnection(connection);
        }
        return result;
    }

    private void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
        } catch (SQLException e) {

        }
    }

    private void closeStatement(Statement statement) {
        try {
            if (statement != null) statement.close();
        } catch (SQLException e) {

        }
    }

    private void closeConnection(Connection connection) {
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {

        }
    }
}

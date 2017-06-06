package com.online.market.db;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
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

    public List<T> executeQuery(String query, List<String> params, Function<ResultSet, List<T>> fun) {
        List<T> result = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(query);
            for(int i = 1; i <= params.size(); i++) {
                statement.setString(i, params.get(i - 1));
            }

            resultSet = statement.executeQuery();
            result = fun.apply(resultSet);

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
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

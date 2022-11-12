package com.dao.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2022-11-12
 **/
public class MysqlConnectionUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(MysqlConnectionUtil.class);

    static class MysqlConnection {
        public Connection connection;
        public Statement statement;
        public PreparedStatement preStatement;

        MysqlConnection() throws Exception {
            connection = createConnection();
            statement = connection.createStatement();
        }

        public void closeStatement() throws Exception {
            if (null == statement) {
                return;
            }
            statement.close();
        }

        public void closePreStatement() throws Exception {
            if (null == preStatement) {
                return;
            }
            preStatement.close();
        }

        public void closeConnection() throws Exception {
            closeStatement();
            closePreStatement();
            if (null == connection) {
                return;
            }
            connection.close();
        }
    }

    /***
     *
     * @return
     * @throws Exception
     */
    private static Connection createConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/d_test";
        String user = "root";
        String password = "20190228";
        return DriverManager.getConnection(url, user, password);
    }

    /***
     * close connection & statement
     * @param mysqlConn
     * @throws Exception
     */
    public static void closeConnection(MysqlConnection mysqlConn) throws Exception {
        if (null == mysqlConn) {
            return;
        }
        mysqlConn.closeConnection();
    }

    public static void main(String[] args) throws Exception {
        MysqlConnection mysqlConn = new MysqlConnection();
        String sql = "select * from t1";
        mysqlConn.preStatement = mysqlConn.connection.prepareStatement(sql);
        ResultSet resultSet = mysqlConn.preStatement.executeQuery();
        while (resultSet.next()) {
            LOGGER.info("id: {}", resultSet.getInt("id"));
            LOGGER.info("name: {}", resultSet.getString("name"));
        }
        closeConnection(mysqlConn);
    }
}
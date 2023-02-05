package com.dao.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * @project: Dao
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

    public static void insertPre() throws Exception {
        String sql = "insert into t1 (name) values (\"user1\"), (\"user2\"), (\"user3\")";
        MysqlConnection mysqlConn = new MysqlConnection();
        try {
            mysqlConn.preStatement = mysqlConn.connection.prepareStatement(sql);
            ParameterMetaData parameterMetaData = mysqlConn.preStatement.getParameterMetaData();
            mysqlConn.preStatement.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(mysqlConn);
        }
    }

    public static void insert() throws Exception {
        String sql = "insert into t1 (name) values (\"user1\"), (\"user2\"), (\"user3\"); drop table t1;";
        MysqlConnection mysqlConn = new MysqlConnection();
        try {
            mysqlConn.statement.execute(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(mysqlConn);
        }
    }

    public static void update() throws Exception {
        String name = "user1'; drop table t1 -- 'a";
        String sql = "delete from t1 where name = '" +  name + "'";
        MysqlConnection mysqlConn = new MysqlConnection();
        try {
            mysqlConn.preStatement = mysqlConn.connection.prepareStatement(sql);
            LOGGER.info("SQL: {}", sql);
            mysqlConn.preStatement.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(mysqlConn);
        }
    }

    public static void updatePre() throws Exception {
        String name = "user1; drop table t1";
        String sql = "delete from t1 where name = ?";
        MysqlConnection mysqlConn = new MysqlConnection();
        try {
            mysqlConn.preStatement = mysqlConn.connection.prepareStatement(sql);
            mysqlConn.preStatement.setString(1, name);
            LOGGER.info("SQL: {}", sql);
            mysqlConn.preStatement.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(mysqlConn);
        }
    }

    public static void dropTable() throws Exception {
        String sql = "drop table t1";
        MysqlConnection mysqlConn = new MysqlConnection();
        try {
            mysqlConn.statement.execute(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(mysqlConn);
        }
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
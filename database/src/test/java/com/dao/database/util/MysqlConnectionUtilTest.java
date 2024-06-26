package com.dao.database.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2022-11-12
 **/
@ExtendWith(MockitoExtension.class)
public class MysqlConnectionUtilTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MysqlConnectionUtilTest.class);

    @Test
    public void preStatementTest() throws Exception{
        MysqlConnectionUtil.MysqlConnection mysqlConn = new MysqlConnectionUtil.MysqlConnection();
        try {
            String sql = "select * from t1";
            mysqlConn.preStatement = mysqlConn.connection.prepareStatement(sql);
            ResultSet resultSet = mysqlConn.preStatement.executeQuery();
            while (resultSet.next()) {
                LOGGER.info("id: {}", resultSet.getInt("id"));
                LOGGER.info("name: {}", resultSet.getString("name"));
                LOGGER.info("add_dt: {}", resultSet.getString("add_dt"));
                LOGGER.info("update_dt: {}", resultSet.getString("update_dt"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            MysqlConnectionUtil.closeConnection(mysqlConn);
        }
    }

    @Test
    public void insertTest() throws Exception {
        MysqlConnectionUtil.insert();
    }

    @Test
    public void insertPreTest() throws Exception {
        MysqlConnectionUtil.insertPre();
    }

    @Test
    public void updateTest() throws Exception {
        MysqlConnectionUtil.update();
    }

    @Test
    public void updatePreTest() throws Exception {
        MysqlConnectionUtil.updatePre();
    }

    @Test
    public void dropTableTest() throws Exception {
        MysqlConnectionUtil.dropTable();
    }
}
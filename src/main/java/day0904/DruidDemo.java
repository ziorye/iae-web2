package day0904;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/*
    CREATE TABLE `user` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `name` varchar(255) DEFAULT NULL,
        `balance` int(11) DEFAULT NULL,
        PRIMARY KEY (`id`)
    );
 */
public class DruidDemo {
    private static DataSource dataSource;

    static {
        //1.引入依赖
        //2.提供配置文件
        //3.load 配置文件
        Properties prop = new Properties();
        Connection connection = null;
        try (InputStream inputStream = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties")) {
            prop.load(inputStream);
            //4. 获取数据库连接池对象 DataSource
            dataSource = DruidDataSourceFactory.createDataSource(prop);
            //5. 获取数据库连接 Connection
            connection = dataSource.getConnection();
            System.out.println(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(connection);
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = dataSource.getConnection();

        DruidDemo.testStatement(connection);
//        DruidDemo.add(connection);
//        DruidDemo.testStatement(connection);
//        DruidDemo.update(connection);
//        DruidDemo.testPreparedStatement(connection);
//        DruidDemo.delete(connection);
//        DruidDemo.batchAdd(connection);
//        DruidDemo.testTransactions(connection);
    }

    public static void testStatement(Connection connection) {
        String query = "select id, name, balance from user";

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int balance = rs.getInt("balance");
                System.out.println(id + "\t" + name+ "\t" + balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void testPreparedStatement(Connection connection) {
        String query = "select id, name, balance from user where id = ?";

        try (PreparedStatement ppstmt = connection.prepareStatement(query);) {
            ppstmt.setInt(1, 1);
            ResultSet rs = ppstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int balance = rs.getInt("balance");
                System.out.println(id + "\t" + name + "\t" + balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void add(Connection connection) {
        String insertSql = "insert into user(name, balance) values(?, ?);";

        try (PreparedStatement ppstmt = connection.prepareStatement(insertSql)) {
            ppstmt.setString(1, "alex");
            ppstmt.setInt(2, 50);
            ppstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void batchAdd(Connection connection) {
        String insertSql = "insert into user(name, balance) values(?, ?);";

        try (PreparedStatement ppstmt = connection.prepareStatement(insertSql)) {
            ppstmt.setString(1, "alex");
            ppstmt.setInt(2, 50);
            ppstmt.addBatch();

            ppstmt.setString(1, "bob");
            ppstmt.setInt(2, 30);
            ppstmt.addBatch();

            ppstmt.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Connection connection) {
        String updateSql = "update user set balance = balance + 5 where id = ?";

        try (PreparedStatement ppstmt = connection.prepareStatement(updateSql)) {
            ppstmt.setInt(1, 1);
            ppstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Connection connection) {
        String updateSql = "delete from user where name = ?";

        try (PreparedStatement ppstmt = connection.prepareStatement(updateSql)) {
            ppstmt.setString(1, "alex");
            ppstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void testTransactions(Connection connection) {
        String update1 = "update user set balance = balance - 10 where id = ?";
        String update2 = "update user set balance = balance + 10 where id = ?";

        try (PreparedStatement ppstmt1 = connection.prepareStatement(update1);
             PreparedStatement ppstmt2 = connection.prepareStatement(update2)) {

            connection.setAutoCommit(false);

            ppstmt1.setInt(1, 1);
            ppstmt1.executeUpdate();

            int i = 2 / 0;

            ppstmt2.setInt(1, 2);
            ppstmt2.executeUpdate();

            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

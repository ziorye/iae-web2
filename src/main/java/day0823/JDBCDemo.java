package day0823;

import java.sql.*;

/*
    CREATE TABLE `user` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `name` varchar(255) DEFAULT NULL,
        `balance` int(11) DEFAULT NULL,
        PRIMARY KEY (`id`)
    );
 */
public class JDBCDemo {
    public Connection getConnection() {
        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "secret_mysql");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connected to database");
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        JDBCDemo jdbcTest = new JDBCDemo();
        Connection connection = jdbcTest.getConnection();

        jdbcTest.testStatement(connection);
//        jdbcTest.add(connection);
//        jdbcTest.update(connection);
//        jdbcTest.testPreparedStatement(connection);
//        jdbcTest.delete(connection);
//        jdbcTest.batchAdd(connection);
//        jdbcTest.testTransactions(connection);
    }

    public void testStatement(Connection connection) {
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

    public void testPreparedStatement(Connection connection) {
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

    public void add(Connection connection) {
        String insertSql = "insert into user(name, balance) values(?, ?);";

        try (PreparedStatement ppstmt = connection.prepareStatement(insertSql)) {
            ppstmt.setString(1, "alex");
            ppstmt.setInt(2, 50);
            ppstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void batchAdd(Connection connection) {
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

    public void update(Connection connection) {
        String updateSql = "update user set balance = balance + 5 where id = ?";

        try (PreparedStatement ppstmt = connection.prepareStatement(updateSql)) {
            ppstmt.setInt(1, 1);
            ppstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Connection connection) {
        String updateSql = "delete from user where name = ?";

        try (PreparedStatement ppstmt = connection.prepareStatement(updateSql)) {
            ppstmt.setString(1, "alex");
            ppstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void testTransactions(Connection connection) throws SQLException {
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
        } finally {
            connection.rollback();
        }
    }
}

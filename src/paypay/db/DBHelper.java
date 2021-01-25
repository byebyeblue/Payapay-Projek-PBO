package paypay.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBHelper {

    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DB = "papay";
    private static final String MYCONN = "jdbc:mysql://localhost/" + DB;
    private static final String SQCONN = "jdbc:sqlite:C:\\Users\\ACER\\Downloads\\SQLiteStudio-3.2.1\\SQLiteStudio\\paypay.sqlite";

    public static Connection getConnection(String driver) throws SQLException {
        Connection conn = null;
        switch (driver) {
            case "SQLITE": {
                try {
                    Class.forName("org.sqlite.JDBC");
                    conn = DriverManager.getConnection(SQCONN);
                    createTable(conn,driver);
                } catch (ClassNotFoundException ex) {
                    System.out.println("library tidak ada");
                    Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "MYSQL": {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(MYCONN, USER, PASSWORD);
                    createTable(conn,driver);
                } catch (ClassNotFoundException ex) {
                    System.out.println("library tidak ada");
                    Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);

                }
                break;
            }
        }

        return conn;
    }

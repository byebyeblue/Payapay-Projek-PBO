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
    
    public static void createTable(Connection conn, String driver) throws SQLException {
        String sqlCreate = "";
        switch (driver) {
            case "MYSQL": {
                sqlCreate = "CREATE TABLE IF NOT EXISTS `akun` ("
                        + "  `ID` int(10) NOT NULL,"
                        + "  `name` varchar(100) DEFAULT NULL,"
                        + "  `address` varchar(200) DEFAULT NULL,"
                        + "  `email` varchar(35) DEFAULT NULL,"
                        + "  `no_hp` varchar(15) DEFAULT NULL,"
                        + "  `saldo` double DEFAULT NULL,"
                        + "  PRIMARY KEY (`ID`)"
                        + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;"
                        + "CREATE TABLE IF NOT EXISTS `bisnis` ("
                        + "  `ID` int(10) NOT NULL,"
                        + "  `telp_bisnis` varchar(15) DEFAULT NULL,"
                        + "  `nama_bisnis` varchar(50) DEFAULT NULL,"
                        + "  `mata_uang` varchar(20) DEFAULT NULL,"
                        + "  PRIMARY KEY (`ID`),"
                        + "  FOREIGN KEY (`ID`) REFERENCES `akun` (`ID`) ON UPDATE CASCADE"
                        + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;"
                        + "CREATE TABLE IF NOT EXISTS `card` ("
                        + "  `CCN` double NOT NULL,"
                        + "  `jenis_kartu` varchar(50) DEFAULT NULL,"
                        + "  `exp_date` date DEFAULT NULL,"
                        + "  `alamat_penagihan` varchar(200) DEFAULT NULL,"
                        + "  `sec_num` int(3) DEFAULT NULL,"
                        + "  `ID` int(10) DEFAULT NULL,"
                        + "  PRIMARY KEY (`CCN`),"
                        + "  KEY `ID` (`ID`),"
                        + "  FOREIGN KEY (`ID`) REFERENCES `akun` (`ID`) ON UPDATE CASCADE"
                        + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;"
                        + "CREATE TABLE IF NOT EXISTS `personal` ("
                        + "  `ID` int(10) NOT NULL,"
                        + "  `KTP` double DEFAULT NULL,"
                        + "  `tgl_lahir` date DEFAULT NULL,"
                        + "  PRIMARY KEY (`ID`),"
                        + "  FOREIGN KEY (`ID`) REFERENCES `akun` (`ID`) ON UPDATE CASCADE"
                        + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
                break;
            }
            case "SQLITE": {
                sqlCreate = "CREATE TABLE IF NOT EXIST akun ("
                        + "    ID      INT (10)      PRIMARY KEY,"
                        + "    name    VARCHAR (100),"
                        + "    address VARCHAR (200),"
                        + "    email   VARCHAR (35),"
                        + "    no_hp   VARCHAR (15),"
                        + "    saldo   DOUBLE"
                        + ");"
                        + "CREATE TABLE IF NOT EXIST bisnis ("
                        + "    ID          INT (10)     PRIMARY KEY"
                        + "                             REFERENCES akun (ID) ON DELETE RESTRICT"
                        + "                                                  ON UPDATE CASCADE,"
                        + "    telp_bisnis VARCHAR (15),"
                        + "    nama_bisnis VARCHAR (50),"
                        + "    mata_uang   VARCHAR (20)"
                        + ");"
                        + "CREATE TABLE IF NOT EXIST card ("
                        + "    CCN              DOUBLE        PRIMARY KEY,"
                        + "    jenis_kartu      VARCHAR (50),"
                        + "    exp_date         DATE,"
                        + "    alamat_penagihan VARCHAR (200),"
                        + "    sec_num          INT (3),"
                        + "    ID               INT (10)      REFERENCES akun (ID) ON DELETE RESTRICT"
                        + "                                                        ON UPDATE CASCADE"
                        + ");"
                        + "CREATE TABLE IF NOT EXIST personal ("
                        + "    ID        INT (10) PRIMARY KEY"
                        + "                       REFERENCES akun (ID) ON DELETE RESTRICT"
                        + "                                            ON UPDATE CASCADE,"
                        + "    KTP       DOUBLE,"
                        + "    tgl_lahir DATE"
                        + ");";
                break;
            }
        }
        String sqls[] = sqlCreate.split(";");
        for (String sql : sqls) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
        }
    }
    }

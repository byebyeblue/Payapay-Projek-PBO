package paypay.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBHelper {
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DB = "paypay";
    private static final String MYCONN = "jdbc:mysql://localhost/" + DB;
    private static final String SQCONN = "jdbc:sqlite:E:\\1 COOLYEAH\\SEMESTER 3\\PBO\\sqlliteDB\\Akun.sqlite";

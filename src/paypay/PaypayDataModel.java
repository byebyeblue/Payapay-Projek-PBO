package paypay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import paypay.db.DBHelper;

public class PaypayDataModel {
    private final Connection conn;

    public PaypayDataModel(String Driver) throws SQLException {
        this.conn = DBHelper.getConnection(Driver);
    }

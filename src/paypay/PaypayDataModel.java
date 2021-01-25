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
    public final Connection conn;

    public PaypayDataModel(String Driver) throws SQLException {
        this.conn = DBHelper.getConnection(Driver);
    }
    
    public void addAkun(Personal holder) throws SQLException{
        String insertAkun = "INSERT INTO akun (ID, name, address, email, no_hp, saldo)" + " VALUES (?, ?, ?, ?, ?, ?)";
        String insertPersonal = "INSERT INTO personal (ID, KTP, tgl_lahir)" + " VALUES (?, ?, ?)";
        String insertCard = "INSERT INTO card (CCN, jenis_kartu, exp_date, alamat_penagihan, sec_num, ID)" + " VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmtAkun = conn.prepareStatement(insertAkun);
        stmtAkun.setInt(1, holder.getID());
        stmtAkun.setString(2, holder.getName());
        stmtAkun.setString(3, holder.getAddress());
        stmtAkun.setString(4, holder.getEmail());
        stmtAkun.setString(5, holder.getNo_hp());
        stmtAkun.setDouble(6, holder.getSaldo());
        stmtAkun.execute();

                
        PreparedStatement stmtPersonal = conn.prepareStatement(insertPersonal);
        stmtPersonal.setInt(1, holder.getID());
        stmtPersonal.setDouble(2, holder.getKTP());
        stmtPersonal.setString(3, holder.getTgl_lahir());
        stmtPersonal.execute();
        
        PreparedStatement stmtCard = conn.prepareStatement(insertCard);
        stmtCard.setDouble(1, holder.getCards().get(0).getCCN());
        stmtCard.setString(2, holder.getCards().get(0).getJenisKartu());
        stmtCard.setString(3, holder.getCards().get(0).getExpDate());
        stmtCard.setString(4, holder.getCards().get(0).getAlamat_penagihan());
        stmtCard.setInt(5, holder.getCards().get(0).getSecNum());
        stmtCard.setInt(6, holder.getID());
        stmtCard.execute();
    }
    public void addAkun(Bisnis holder) throws SQLException{
        String insertAkun = "INSERT INTO akun (ID, name, address, email, no_hp, saldo)" + " VALUES (?, ?, ?, ?, ?, ?)";
        String insertBisnis = "INSERT INTO bisnis (ID, telo_bisnis, nama_bisnis, mata_uang)" + " VALUES (?, ?, ?, ?)";
        String insertCard = "INSERT INTO card (CCN, jenis_kartu, exp_date, alamat_penagihan, sec_num, ID)" + " VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmtAkun = conn.prepareStatement(insertAkun);
        stmtAkun.setInt(1, holder.getID());
        stmtAkun.setString(2, holder.getName());
        stmtAkun.setString(3, holder.getAddress());
        stmtAkun.setString(4, holder.getEmail());
        stmtAkun.setString(5, holder.getNo_hp());
        stmtAkun.setDouble(6, holder.getSaldo());
        stmtAkun.execute();
        

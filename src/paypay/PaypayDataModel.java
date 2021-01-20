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
        
        PreparedStatement stmtBisnis = conn.prepareStatement(insertBisnis);
        stmtBisnis.setInt(1, holder.getID());
        stmtBisnis.setString(2, holder.getTelp_bisnis());
        stmtBisnis.setString(3, holder.getNama_bisnis());
        stmtBisnis.setString(4, holder.getMata_uang());
        stmtBisnis.execute();
        
        PreparedStatement stmtCard = conn.prepareStatement(insertCard);
        stmtCard.setDouble(1, holder.getCards().get(0).getCCN());
        stmtCard.setString(2, holder.getCards().get(0).getJenisKartu());
        stmtCard.setString(3, holder.getCards().get(0).getExpDate());
        stmtCard.setString(4, holder.getCards().get(0).getAlamat_penagihan());
        stmtCard.setInt(5, holder.getCards().get(0).getSecNum());
        stmtCard.setInt(6, holder.getID());
        stmtCard.execute();
    }

    public ObservableList<Personal> getPersonals(){
        ObservableList<Personal> data = FXCollections.observableArrayList();
        String sql = "SELECT `ID`, `name`, `address`, `email`, `no_hp`, `saldo`, `KTP`, `tgl_lahir` FROM `akun` NATURAL JOIN `personal` ORDER BY Name";
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while(rs.next()){
                String sqlCard = "SELECT CCN, jenis_kartu, exp_date, alamat_penagihan, sec_num WHERE ID" + rs.getInt(1);
                ResultSet rsCard = conn.createStatement().executeQuery(sqlCard);
                ArrayList<Card> dataCard = new ArrayList<>();
                while(rsCard.next()){
                    dataCard.add(new Card(rsCard.getDouble(1), 
                            rsCard.getString(2), rsCard.getString(3), 
                            rsCard.getString(4), rsCard.getInt(5)));
                }
                data.add(new Personal(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getDouble(6), 
                    rs.getDouble(7), rs.getString(8), dataCard));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PaypayDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

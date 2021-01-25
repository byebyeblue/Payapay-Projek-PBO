package paypay;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Card {
    private DoubleProperty CCN;
    private StringProperty jenisKartu;
    private StringProperty expDate;
    private StringProperty alamat_penagihan;
    private IntegerProperty SecNum;

    public Card(Double CCN, String jenisKartu, String expDate,
            String alamat_penagihan, Integer SecNum) {
        this.CCN = new SimpleDoubleProperty(CCN);
        this.jenisKartu = new SimpleStringProperty(jenisKartu);
        this.expDate = new SimpleStringProperty(expDate);
        this.alamat_penagihan = new SimpleStringProperty(alamat_penagihan);
        this.SecNum = new SimpleIntegerProperty(SecNum);
    }

    public Integer getSecNum() {
        return SecNum.get();
    }

    public void setSecNum(Integer SecNum) {
        this.SecNum.set(SecNum);
    }

    public Double getCCN() {
        return CCN.get();
    }

    public void setCCN(Integer CCN) {
        this.CCN.set(CCN);
    }

    public String getJenisKartu() {
        return jenisKartu.get();
    }

    public void setJenisKartu(String jenisKartu) {
        this.jenisKartu.set(jenisKartu);
    }

    public String getExpDate() {
        return expDate.get();
    }

    public void setExpDate(String expDate) {
        this.expDate.set(expDate);
    }

    public String getAlamat_penagihan() {
        return alamat_penagihan.get();
    }

    public void setAlamat_penagihan(String alamat_penagihan) {
        this.alamat_penagihan.set(alamat_penagihan);
    }
    
    public DoubleProperty CCNProperty(){
        return CCN;
    }
    
    public StringProperty jenisKartu(){
        return jenisKartu;
    }
    
    public StringProperty expDateProperty(){
        return expDate;
    }
    
    public StringProperty alamat_penagihanProperty(){
        return alamat_penagihan;
    }
    
    public IntegerProperty SecNumProperty(){
        return SecNum;
    }
}

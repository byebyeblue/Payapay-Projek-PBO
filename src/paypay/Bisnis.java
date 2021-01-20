package paypay;

import java.util.ArrayList;
import javafx.beans.property.StringProperty;

public class Bisnis extends Akun {
    StringProperty telp_bisnis;
    StringProperty nama_bisnis;
    StringProperty mata_uang;

    public Bisnis(Integer ID, String Name, String Address, String email, String no_hp,
            Double saldo, String telp_bisnis, String nama_bisnis, String mata_uang,
            ArrayList<Card> cards) {
        super(ID, Name, Address, email, no_hp, saldo, cards);
        this.telp_bisnis.set(telp_bisnis);
        this.nama_bisnis.set(nama_bisnis);
        this.mata_uang.set(mata_uang);
    }

    public Bisnis(Integer ID, String Name, String Address, String email, String no_hp, 
            Double saldo, String telp_bisnis, String nama_bisnis, String mata_uang,
            Card card) {
        super(ID, Name, Address, email, no_hp, saldo, card);
        this.telp_bisnis.set(telp_bisnis);
        this.nama_bisnis.set(nama_bisnis);
        this.mata_uang.set(mata_uang);
    }

    public String getTelp_bisnis() {
        return telp_bisnis.get();
    }

    public void setTelp_bisnis(String telp_bisnis) {
        this.telp_bisnis.set(telp_bisnis);
    }

    public String getNama_bisnis() {
        return nama_bisnis.get();
    }

    public void setNama_bisnis(String nama_bisnis) {
        this.nama_bisnis.set(nama_bisnis);
    }

    public String getMata_uang() {
        return mata_uang.get();
    }

    public void setMata_uang(String mata_uang) {
        this.mata_uang.set(mata_uang);
    }
    
    public StringProperty Telp_bisnisProperty() {
        return telp_bisnis;
    }

    public StringProperty Nama_bisnisProperty() {
        return nama_bisnis;
    }

    public StringProperty Mata_uangProperty() {
        return mata_uang;
    }
    
}

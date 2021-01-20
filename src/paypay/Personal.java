package paypay;

import java.util.ArrayList;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Personal extends Akun {
    DoubleProperty KTP;
    StringProperty tgl_lahir;

    public Personal(Integer ID, String Name, String Address, String email, String no_hp,
            Double saldo, Double KTP, String tgl_lahir, ArrayList<Card> cards) {
        super(ID, Name, Address, email, no_hp, saldo, cards);
        this.KTP = new SimpleDoubleProperty(KTP);
        this.tgl_lahir = new SimpleStringProperty(tgl_lahir);
    }

    public Personal(Integer ID, String Name, String Address, String email, String no_hp,
            Double saldo, Double KTP, String tgl_lahir, Card card) {
        super(ID, Name, Address, email, no_hp, saldo, card);
        this.KTP = new SimpleDoubleProperty(KTP);
        this.tgl_lahir = new SimpleStringProperty(tgl_lahir);
    }
    
    public Double getKTP() {
        return KTP.get();
    }

    public void setKTP(Double KTP) {
        this.KTP.set(KTP);
    }

    public String getTgl_lahir() {
        return tgl_lahir.get();
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir.set(tgl_lahir);
    }
    
    public DoubleProperty KTPProperty() {
        return KTP;
    }
    
    public StringProperty Tgl_lahirProperty() {
        return tgl_lahir;
    }
}

package paypay;

import java.util.ArrayList;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Akun {
    private IntegerProperty ID;
    private StringProperty Name;
    private StringProperty Address;
    private StringProperty email;
    private StringProperty no_hp;
    private DoubleProperty saldo;
    private ArrayList<Card> cards;

    public Akun(Integer ID, String Name, String Address, String email, String no_hp,
            Double saldo, ArrayList<Card> cards) {
        this.ID = new SimpleIntegerProperty(ID);
        this.Name = new SimpleStringProperty(Name);
        this.Address = new SimpleStringProperty(Address);
        this.email = new SimpleStringProperty(email);
        this.no_hp = new SimpleStringProperty(no_hp);
        this.saldo = new SimpleDoubleProperty(saldo);
        this.cards = cards;
    }
    
    public Akun(Integer ID, String Name, String Address, String email, String no_hp,
            Double saldo, Card card) {
        cards = new ArrayList<>();
        this.ID = new SimpleIntegerProperty(ID);
        this.Name = new SimpleStringProperty(Name);
        this.Address = new SimpleStringProperty(Address);
        this.email = new SimpleStringProperty(email);
        this.no_hp = new SimpleStringProperty(no_hp);
        this.saldo = new SimpleDoubleProperty(saldo);
        this.cards.add(card);
    }
    

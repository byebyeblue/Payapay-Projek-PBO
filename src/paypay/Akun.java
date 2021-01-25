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

    public Integer getID() {
        return ID.get();
    }

    public void setID(Integer ID) {
        this.ID.set(ID);
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String Name) {
        this.Name.set(Name);
    }

    public String getAddress() {
        return Address.get();
    }

    public void setAddress(String Address) {
        this.Address.set(Address);
    }
public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getNo_hp() {
        return no_hp.get();
    }

    public void setNo_hp(String no_hp) {
        this.no_hp.set(no_hp);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    
    public Double getSaldo() {
        return saldo.get();
    }

    public void setSaldo(Double saldo) {
        this.saldo.set(saldo);
    }
    
    public void deposit(Double amt){
        this.saldo.set(this.saldo.get()+amt);
    }

    public void withdraw(Double amt){
        this.saldo.set(this.saldo.get()-amt);
    }
    
    public IntegerProperty IDProperty(){
        return ID;
    }
    
    public StringProperty NameProperty(){
        return Name;
    }
    
    public StringProperty AddressProperty(){
        return Address;
    }
    
    public StringProperty emailProperty(){
        return email;
    }
    
    public StringProperty No_hpProperty() {
        return no_hp;
    }
    
    public DoubleProperty saldoProperty(){
        return saldo;
    }
}

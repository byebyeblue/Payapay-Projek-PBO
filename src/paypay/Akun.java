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

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

package paypay;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PaypayController implements Initializable {
    
    @FXML
    private TextField tfID;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfAddress;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNo_hp;

    @FXML
    private TextField tfKTP;
    
    @FXML
    private DatePicker dpTgl_lahir;

    @FXML
    private TextField tfSaldo;

    @FXML
    private TextField tfCCN;

    @FXML
    private TextField tfJenis_kartu;
    
    @FXML
    private DatePicker dpExp_date;

    @FXML
    private TextField tfAlamat_penagihan;

    @FXML
    private TextField tfSec_num;

    @FXML
    private Button btnAddAccount;

    @FXML
    private Button btnReload;

    @FXML
    private Button btnClear;

    @FXML
    private TableView<Personal> tblAkun;

    @FXML
    private TableColumn<Personal, Integer> colID;

    @FXML
    private TableColumn<Personal, String> colName;

    @FXML
    private TableColumn<Personal, String> colAddress;

    @FXML
    private TableColumn<Personal, String> colEmail;

    @FXML
    private TableColumn<Personal, String> colNo_hp;

    @FXML
    private TableColumn<Personal, Double> colKTP;

    @FXML
    private TableColumn<Personal, String> colTgl_lahir;

    @FXML
    private TableColumn<Personal, Double> colSaldo;
    
    @FXML
    private TableView<Card> tblCard;

    @FXML
    private TableColumn<Card, Double> colCCN;

    @FXML
    private TableColumn<Card, String> colJenis_kartu;

    @FXML
    private TableColumn<Card, String> colExp_date;

    @FXML
    private TableColumn<Card, String> colAlamat_penagihan;

    @FXML
    private TableColumn<Card, Integer> colSec_num;

    @FXML
    private TextField tfNewID;

    @FXML
    private TextField tfNewCCN;

    @FXML
    private TextField tfNewJenis_kartu;

    @FXML
    private DatePicker dpNewExp_date;

    @FXML
    private TextField tfNewAlamat_penagihan;

    @FXML
    private TextField tfNewSec_num;

    @FXML
    private Button btnAddCard;

    @FXML
    private Label lblDBStatus;
    
    @FXML
    private Label lblSaveStatus;
    private PaypayDataModel ahdm;
    
    public void viewDataCard(int ID){
        ObservableList<Card> data = ahdm.getCards(ID);
        colCCN.setCellValueFactory(new PropertyValueFactory<>("CCN"));
	colJenis_kartu.setCellValueFactory(new PropertyValueFactory<>("jenisKartu"));
	colExp_date.setCellValueFactory(new PropertyValueFactory<>("expDate"));
	colAlamat_penagihan.setCellValueFactory(new PropertyValueFactory<>("alamat_penagihan"));
	colSec_num.setCellValueFactory(new PropertyValueFactory<>("SecNum"));
        tblCard.setItems(null);
        tblCard.setItems(data);
    }

package paypay;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    private TextField tfSaldo;

    @FXML
    private DatePicker dpTgl_lahir;

    @FXML
    private TextField tlCCN;

    @FXML
    private TextField tfJenis_kartu;

    @FXML
    private TextField tfAlamat_penagihan;

    @FXML
    private TextField tfSec_num;

    @FXML
    private DatePicker dpExp_date;

    @FXML
    private Button btnAddAccount;

    @FXML
    private Button btnReload;

    @FXML
    private Button btnClear;

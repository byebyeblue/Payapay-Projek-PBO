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

    @FXML
    private TableView<?> tblAkun;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> ColName;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colNo_hp;

    @FXML
    private TableColumn<?, ?> colKTP;

    @FXML
    private TableColumn<?, ?> colTgl_lahir;

    @FXML
    private TableColumn<?, ?> colSaldo;

    @FXML
    private TableView<?> tblCard;

    @FXML
    private TableColumn<?, ?> colCCN;

    @FXML
    private TableColumn<?, ?> colJenis_kartu;

    @FXML
    private TableColumn<?, ?> colExp_date;

    @FXML
    private TableColumn<?, ?> colAlamat;

    @FXML
    private TableColumn<?, ?> colSec_num;

    @FXML
    private TextField tfNewID;

    @FXML
    private TextField tfNewCCN;

    @FXML
    private TextField tfNewJenis_kartu;

    @FXML
    private TextField tfNewExp_date;

    @FXML
    private TextField tfNewAlamat_penagihan;

    @FXML
    private TextField tfNewSec_num;

    @FXML
    private Button btnAddCard;

    @FXML
    private Label lblDBStatus;

    @FXML
    void handleAddAccountButton(ActionEvent event) {

    }

    @FXML
    void handleAddCardButton(ActionEvent event) {

    }

    @FXML
    void handleClearButton(ActionEvent event) {

    }

    @FXML
    void handleReloadButton(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

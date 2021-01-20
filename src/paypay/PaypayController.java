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
    private Label lblSaveStatus;
    private PaypayDataModel ahdm;
    
    @FXML    
    void handleAddAccountButton(ActionEvent event) {
        LocalDate ld = dpTgl_lahir.getValue();
        String Tgl_lahir = String.format("%d-%02d-%02d", ld.getYear(), 
                ld.getMonthValue(), ld.getDayOfMonth());
        LocalDate xd = dpExp_date.getValue();
        String Exp_date = String.format("%d-%02d-%02d", xd.getYear(), 
                xd.getMonthValue(), xd.getDayOfMonth());
        Personal holder = new Personal(Integer.parseInt(tfID.getText()), 
                tfName.getText(), tfAddress.getText(), tfEmail.getText(), 
                tfNo_hp.getText(), Double.parseDouble(tfSaldo.getText()), 
                Double.parseDouble(tfKTP.getText()), Tgl_lahir, 
                new Card(Double.parseDouble(tfCCN.getText()),
                tfJenis_kartu.getText(), Exp_date, tfAlamat_penagihan.getText(),
                Integer.parseInt(tfSec_num.getText())));
        
        try {
            ahdm.addAkun(holder);
            lblSaveStatus.setText("Akun Berhasil Dibuat");
            btnReload.fire();
            btnClear.fire();
        } catch (SQLException ex) {
            lblSaveStatus.setText("Akun Gagal Dibuat");
            Logger.getLogger(PaypayController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleAddCardButton(ActionEvent event) {
        
    }

    @FXML
    void handleClearButton(ActionEvent event) {
        try {
            tfID.setText(""+ahdm.nextID());
            tfName.setText("");
	    tfAddress.setText("");
	    tfEmail.setText("");
	    tfNo_hp.setText("");
	    tfKTP.setText("");
	    tfSaldo.setText("");
	    tfCCN.setText("");
	    tfJenis_kartu.setText("");
	    tfAlamat_penagihan.setText("");
	    tfSec_num.setText("");
            
            dpTgl_lahir.setValue(LocalDate.of(LocalDate.now().getYear() - 20, 
                    LocalDate.now().getMonthValue(), 
                    LocalDate.now().getDayOfMonth()));
            dpExp_date.setValue(LocalDate.of(LocalDate.now().getYear()+5, 
                    LocalDate.now().getMonthValue(), 
                    LocalDate.now().getDayOfMonth()));
        } catch (SQLException ex) {
            Logger.getLogger(PaypayController.class.getName()).log(Level.SEVERE, null, ex);
        }
	 
    }

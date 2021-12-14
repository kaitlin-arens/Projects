import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * This is the controller for the FXML document that contains the view. 
 */
public class HistoryController implements Initializable {

  @FXML
  private Button btngo;

  @FXML
  private TextField txtmonth;
  
  @FXML
  private TextField txtday;

  @FXML
  private Label lblevents;

  @FXML
  private Label lblbirths;

  @FXML
  private Label lbldeaths;

  @FXML
  private void handleButtonAction(ActionEvent e) {
    // Create object to access the Model
    HistoryModel history = new HistoryModel();

    // Has the go button been pressed?
    if (e.getSource() == btngo)
    {
      int month = Integer.parseInt(txtmonth.getText());
      int day = Integer.parseInt(txtday.getText());
      
      if (history.getHistory(month, day))
      {
        lblevents.setText(history.getEvents());
        lblbirths.setText(history.getBirths());
        lbldeaths.setText(history.getDeaths());
      }
      else
      {
        lblevents.setText("Invalid date");
        lblbirths.setText("");
        lbldeaths.setText("");
      }
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }    

}

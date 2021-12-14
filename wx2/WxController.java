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
 * Created by Tim McGowen on 3/22/2017
 *
 * This is the controller for the FXML document that contains the view. 
 */
public class WxController implements Initializable {

  @FXML
  private Button btngo;

  @FXML
  private TextField txtzipcode;

  @FXML
  private Label lblcity;

  @FXML
  private Label lbltemp;
  
  @FXML
  private Label lbltime;
  
  @FXML
  private Label lblweather;
  
  @FXML
  private Label lblwind;
  
  @FXML
  private Label lblpressure;
  
  @FXML
  private Label lblvisibility;

  @FXML
  private ImageView iconwx;

  @FXML
  private void handleButtonAction(ActionEvent e) {
    // Create object to access the Model
    WxModel weather = new WxModel();

    // Has the go button been pressed?
    if (e.getSource() == btngo)
    {
      String zipcode = txtzipcode.getText();
      if (weather.getWx(zipcode))
      {
        lblcity.setText("Location: " + weather.getLocation());
        lbltemp.setText("Temperature: " + String.valueOf(weather.getTemp()));
        iconwx.setImage(weather.getImage());
        lbltime.setText(weather.getTime());
        lblweather.setText("Weather: " + weather.getWeather());
        lblwind.setText("Wind: " + weather.getWind());
        lblpressure.setText("Pressure: " + weather.getPressure());
        lblvisibility.setText("Visibility in miles: " + weather.getVisibility());
      }
      else
      {
        lblcity.setText("Invalid Zipcode");
        lbltemp.setText("Temp: ");
        iconwx.setImage(new Image("badzipcode.png"));
        lbltime.setText("Time: ");
        lblweather.setText("Weather: ");
        lblwind.setText("Wind: ");
        lblpressure.setText("Pressure: ");
        lblvisibility.setText("Visibility: ");
      }
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }    

}

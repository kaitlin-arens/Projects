import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javafx.scene.image.Image;

/**
 * Created by Tim McGowen on 3/22/2017
 *
 * Model to get weather information based on zipcode.
 */
public class WxModel {
  private JsonElement jse;
  private final String apiKey = "151366ea85c82704";

  public boolean getWx(String zip)
  {
    try
    {
      URL wuURL = new URL("http://api.wunderground.com/api/" + apiKey +
          "/conditions/q/" + zip + ".json");

      // Open connection
      InputStream is = wuURL.openStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(is));

      // Read the results into a JSON Element
      jse = new JsonParser().parse(br);

      // Close connection
      is.close();
      br.close();
    }
    catch (java.io.UnsupportedEncodingException uee)
    {
      uee.printStackTrace();
    }
    catch (java.net.MalformedURLException mue)
    {
      mue.printStackTrace();
    }
    catch (java.io.IOException ioe)
    {
      ioe.printStackTrace();
    }
    catch (java.lang.NullPointerException npe)
    {
      npe.printStackTrace();
    }

    // Check to see if the zip code was valid.
    return isValid();
  }

  public boolean isValid()
  {
    // If the zip is not valid we will get an error field in the JSON
    try {
      String error = jse.getAsJsonObject().get("response").getAsJsonObject().get("error").getAsJsonObject().get("description").getAsString();
      return false;
    }

    catch (java.lang.NullPointerException npe)
    {
      // We did not see error so this is a valid zip
      return true;
    }
  }

  public String getLocation()
  {
    return jse.getAsJsonObject().get("current_observation").getAsJsonObject().get("display_location").getAsJsonObject().get("full").getAsString();
  }

  public double getTemp()
  {
    return jse.getAsJsonObject().get("current_observation").getAsJsonObject().get("temp_f").getAsDouble();
  }
  
  public String getTime()
  {
    return jse.getAsJsonObject().get("current_observation").getAsJsonObject().get("observation_time").getAsString();
  }
  
  public String getWeather()
  {
    return jse.getAsJsonObject().get("current_observation").getAsJsonObject().get("weather").getAsString();
  }
  
  public String getWind()
  {
    return jse.getAsJsonObject().get("current_observation").getAsJsonObject().get("wind_string").getAsString();
  }
  
  public String getPressure()
  {
    return jse.getAsJsonObject().get("current_observation").getAsJsonObject().get("pressure_in").getAsString();
  }
  
  public String getVisibility()
  {
    return jse.getAsJsonObject().get("current_observation").getAsJsonObject().get("visibility_mi").getAsString();
  }

  public Image getImage()
  {
    String iconURL = jse.getAsJsonObject().get("current_observation").getAsJsonObject().get("icon_url").getAsString();
    return new Image(iconURL);
  }
}

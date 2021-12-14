import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.net.URL;

import com.google.gson.*;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javafx.scene.image.Image;

public class HistoryModel {
  private JsonElement jse;

  public boolean getHistory(int month, int day)
  {
     if(isValid(month, day) == true)
     {
    
       try
       {
         URL wuURL = new URL("https://history.muffinlabs.com/date/" + month + "/" + day);
   
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
     return true;
     }
     
     else
     {
       //invalid date
       return false;
     }
    
  }

  public boolean isValid(int month, int day)
  {
    if(month == 1 && day >= 1 && day <= 31)
    {
      return true;
    }
    
    else if(month == 2 && day >= 1 && day <= 29)
    {
      return true;
    }
    
    else if(month == 3 && day >= 1 && day <= 31)
    {
      return true;
    }
    
    else if(month == 4 && day >= 1 && day <= 30)
    {
      return true;
    }
    
    else if(month == 5 && day >= 1 && day <= 31)
    {
      return true;
    }
    
    else if(month == 6 && day >= 1 && day <= 30)
    {
      return true;
    }
    
    else if(month == 7 && day >= 1 && day <= 31)
    {
      return true;
    }
    
    else if(month == 8 && day >= 1 && day <= 31)
    {
      return true;
    }
    
    else if(month == 9 && day >= 1 && day <= 30)
    {
      return true;
    }
    
    else if(month == 10 && day >= 1 && day <= 31)
    {
      return true;
    }
    
    else if(month == 11 && day >= 1 && day <= 30)
    {
      return true;
    }
    
    else if(month == 12 && day >= 1 && day <= 31)
    {
      return true;
    }
    
    else
    {
      return false;
    }
  }  

  public String getEvents()
  {
    JsonArray obs = jse.getAsJsonObject().get("data").getAsJsonObject().get("Events").getAsJsonArray();
    String year1 = obs.get(0).getAsJsonObject().get("year").getAsString();
    String events1 = obs.get(0).getAsJsonObject().get("text").getAsString();
    
    String history1 = "(Year: " + year1 + ")" + "Event: " + events1  + "\n";
    
    JsonArray obs1 = jse.getAsJsonObject().get("data").getAsJsonObject().get("Events").getAsJsonArray();
    String year2 = obs1.get(1).getAsJsonObject().get("year").getAsString();
    String events2 = obs1.get(1).getAsJsonObject().get("text").getAsString();
    
    String history2 = "(Year: " + year2 + ")" + "Event: " + events2 ;
    
    
    return  history1 + history2;
  }

  public String getDeaths()
  {
    JsonArray obs = jse.getAsJsonObject().get("data").getAsJsonObject().get("Deaths").getAsJsonArray();
    String year1 = obs.get(0).getAsJsonObject().get("year").getAsString();
    String deaths1 = obs.get(0).getAsJsonObject().get("text").getAsString();
    
    String history1 = "(Year: " + year1 + ")" + " Death: " + deaths1 + "\n";
    
    JsonArray obs1 = jse.getAsJsonObject().get("data").getAsJsonObject().get("Deaths").getAsJsonArray();
    String year2 = obs1.get(1).getAsJsonObject().get("year").getAsString();
    String deaths2 = obs1.get(1).getAsJsonObject().get("text").getAsString();
  
    String history2 = "(Year: " + year2 + ")" + " Death: " + deaths2;
    
    
    return history1 + history2;
  }

  public String getBirths()
  {
    JsonArray obs = jse.getAsJsonObject().get("data").getAsJsonObject().get("Births").getAsJsonArray();
    String year1 = obs.get(0).getAsJsonObject().get("year").getAsString();
    String birth1 = obs.get(0).getAsJsonObject().get("text").getAsString();
  
    String history1 = "(Year: " + year1 + ")" + " Births: " + birth1 + "\n";
    
    JsonArray obs1 = jse.getAsJsonObject().get("data").getAsJsonObject().get("Births").getAsJsonArray();
    String year2 = obs1.get(1).getAsJsonObject().get("year").getAsString();
    String birth2 = obs1.get(1).getAsJsonObject().get("text").getAsString();
  
    String history2 = "(Year: " + year2 + ")" + " Births: " + birth2;
    
    return history1 + history2;
  }
}

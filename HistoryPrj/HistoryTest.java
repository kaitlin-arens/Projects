import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Test the GenericList class
 */
public class HistoryTest
{ 
  @Test
  public void testHistory1()
  {
    HistoryModel h = new HistoryModel();
    Boolean b = h.getHistory(11,14);
  }

  @Test
  public void testHistory2()
  {
    HistoryModel h = new HistoryModel();
    Boolean b = h.getHistory(0,0);
    assertEquals(false, b); 
  }

  @Test
  public void testGetDeaths1()
  {
    HistoryModel h = new HistoryModel();
    Boolean b = h.getHistory(11,14);
    assertEquals(true, b);
    String deaths = h.getDeaths();
    assertEquals("(Year: 565) Death: Justinian I, Byzantine emperor (b. 482)\n(Year: 669) Death: Fujiwara no Kamatari, Japanese courtier and politician (b. 614)", deaths);
  }

  @Test
  public void testGetDeaths2()
  {
    HistoryModel h = new HistoryModel();
    Boolean b = h.getHistory(0,0);
    assertEquals(false, b);
  }

  @Test
  public void testGetBirths1()
  {
    HistoryModel h = new HistoryModel();
    Boolean b = h.getHistory(11,14);
    assertEquals(true, b);
    String births = h.getBirths();
    assertEquals("(Year: 1449) Births: Sidonie of Poděbrady, daughter of King of Bohemia (d. 1510)\n(Year: 1487) Births: John III of Pernstein, Bohemian land-owner, Governor of Moravia and Count of Kladsko (d. 1548)", births);
  }

  @Test
  public void testGetBirths2()
  {
    HistoryModel h = new HistoryModel();
    Boolean b = h.getHistory(0,0);
    assertEquals(false, b);
  }
}

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Test the GenericList class
 */
public class GenericListTest
{ 
  @Test
  public void testCreateArray()
  {
    GenericList<String> b = new GenericList<String>();
    assertEquals(0, b.size());
  }

  @Test
  public void testAddToArray()
  {
    GenericList<String> b = new GenericList<String>();
    b.add("Hello");
    assertEquals(1, b.size());
    b.add("Bye");
    assertEquals(2, b.size());
    b.add("Adios");
    assertEquals(3, b.size());
  }

  @Test
  public void testAdd12()
  {
    GenericList<String> b = new GenericList<String>();
    b.add("str1");
    b.add("str2");
    b.add("str3");
    b.add("str4");
    b.add("str5");
    b.add("str6");
    b.add("str7");
    b.add("str8");
    b.add("str9");
    b.add("str10");
    b.add("str11");
    b.add("str12");
    assertEquals(12, b.size());
  }

  @Test
  public void testAdd100()
  {
    GenericList<String> b = new GenericList<String>();

    for (int i = 0; i < 50; i++)
      b.add("str" + i);
    assertEquals(50, b.size());

    for (int i = 0; i < 50; i++)
      b.add("morestr" + i);

    assertEquals(100, b.size());
  }

  @Test
  public void testGet()
  {
    GenericList<String> b = new GenericList<String>();
    b.add("Hello");
    b.add("Bye");
    assertEquals("Hello", b.get(0));
    assertEquals("Bye", b.get(1));
  }

  @Test
  public void testGet12()
  {
    GenericList<String> b = new GenericList<String>();
    b.add("str1");
    b.add("str2");
    b.add("str3");
    b.add("str4");
    b.add("str5");
    b.add("str6");
    b.add("str7");
    b.add("str8");
    b.add("str9");
    b.add("str10");
    b.add("str11");
    b.add("str12");
    assertEquals("str8", b.get(7));
    assertEquals("str12", b.get(11));
    assertEquals("str1", b.get(0));
  }

  @Test
  public void testSet()
  {
    GenericList<String> b = new GenericList<String>();
    b.add("Hello");
    b.add("Bye");
    b.set(0, "Bonjour");
    assertEquals("Bonjour", b.get(0));
    assertEquals("Bye", b.get(1));
    b.set(1, "Adios");
    assertEquals("Bonjour", b.get(0));
    assertEquals("Adios", b.get(1));
  }

  @Test
  public void testToString()
  {
    GenericList<String> b = new GenericList<String>();
    assertEquals("", b.toString());
    b.add("hello");
    assertEquals("hello", b.toString());
    b.add("bye");
    assertEquals("hello, bye", b.toString());
    b.add("adios");
    assertEquals("hello, bye, adios", b.toString());
  }

  @Test
  public void testDelete()
  {
    GenericList<String> b = new GenericList<String>();
    b.add("hello");
    b.add("hola");
    b.remove(0);
    assertEquals(1, b.size());
    b.remove(0);
    assertEquals(0, b.size());
  }

  @Test
  public void testDelete10()
  {
    GenericList<String> b = new GenericList<String>();
    for (int i = 0; i < 10; i++)
      b.add("str" + i);
    assertEquals(10, b.size());
    b.remove(0);
    assertEquals(9, b.size());
    b.remove(0);
    b.remove(0);
    b.remove(0);
    b.remove(0);
    b.remove(0);
    b.remove(0);
    b.remove(0);
    b.remove(0);
    b.remove(0);
    assertEquals(0, b.size());
  }

  @Test
  public void testInsert()
  {
    GenericList<String> b = new GenericList<String>();
    b.add("hello");
    b.add("bye");
    b.insert(1, "adios");
    assertEquals("hello", b.get(0));
    assertEquals("adios", b.get(1));
    assertEquals("bye", b.get(2));
    assertEquals(3, b.size());

    b.insert(1, "buenos dias");
    assertEquals(4, b.size());
    assertEquals("hello", b.get(0));
    assertEquals("buenos dias", b.get(1));
    assertEquals("adios", b.get(2));

    b.insert(0, "hi");
    assertEquals(5, b.size());
    assertEquals("hi", b.get(0));
    assertEquals("hello", b.get(1));

    b.insert(4, "see ya");
    assertEquals(6, b.size());
    assertEquals("see ya", b.get(4));
    assertEquals("bye", b.get(5));
  }

  @Test
  public void testInsert11()
  {
    GenericList<String> b = new GenericList<String>();
    b.add("one");
    b.insert(0, "two");
    b.insert(0, "three");
    b.insert(0, "four");
    b.insert(0, "five");
    b.insert(0, "six");
    b.insert(0, "seven");
    b.insert(0, "eight");
    b.insert(0, "nine");
    b.insert(0, "ten");
    b.insert(0, "eleven");
    assertEquals(11, b.size());
    assertEquals("eleven", b.get(0));
    assertEquals("ten", b.get(1));
    assertEquals("two", b.get(9));
    assertEquals("one", b.get(10));
  }

  @Test
  public void testInsertAt0()
  {
    GenericList<String> b = new GenericList<String>();
    b.add("one");
    b.insert(0, "two");
    b.insert(0, "three");
    assertEquals(3, b.size());
    assertEquals("three", b.get(0));
    assertEquals("two", b.get(1));
    assertEquals("one", b.get(2));
  }

  @Test
  public void testDelete1()
  {
    GenericList<String> b = new GenericList<String>();
    b.add("hello");
    b.remove(0);
    assertEquals(0, b.size());
  }

  @Test
  public void testDeleteSeveral()
  {
    GenericList<String> b = new GenericList<String>();
    b.add("hello");
    b.add("bye");
    b.add("adios");
    b.add("ciao");
    b.add("see ya");
    b.remove(0);
    assertEquals(4, b.size());
    assertEquals("bye", b.get(0));
    assertEquals("adios", b.get(1));
    assertEquals("ciao", b.get(2));
    assertEquals("see ya", b.get(3));

    b.remove(3);
    assertEquals(3, b.size());
    assertEquals("bye", b.get(0));
    assertEquals("adios", b.get(1));
    assertEquals("ciao", b.get(2));

    b.remove(0);
    b.remove(0);
    b.remove(0);
    assertEquals(0, b.size());
  }

  @Test
  public void testJFrame()
  {
    GenericList<javax.swing.JFrame> b = new GenericList<javax.swing.JFrame>();
    javax.swing.JFrame j1 = new javax.swing.JFrame();
    javax.swing.JFrame j2 = new javax.swing.JFrame();
    b.add(j2);
    b.add(j1);
    assertEquals(j2, b.get(0));
    assertEquals(j1, b.get(1));
  }
  
  @Test (expected=ArrayIndexOutOfBoundsException.class)
    public void testGetException()
    {
      GenericList<String> b = new GenericList<String>();
      b.add("Hello");
      b.get(1);
      // No more code after this, because the exception
      // will cause the method to exit.
      // Don't create more that one exception per test method.
    }

  @Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testGetNegativeException()
    {
      GenericList<String> b = new GenericList<String>();
      b.get(-1);
    }

  @Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testSetException()
    {
      GenericList<String> b = new GenericList<String>();
      b.add("Hello");
      b.set(1, "Bye");
      // No more code after this, because the exception
      // will cause the method to exit.
      // Don't create more that one exception per test method.
    }

  @Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testSetEmptyException()
    {
      GenericList<String> b = new GenericList<String>();
      b.set(0, "Hello");
    }

  @Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testSetNegativeException()
    {
      GenericList<String> b = new GenericList<String>();
      b.set(-1, "Hello");
    }

  @Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testSetFullException()
    {
      GenericList<String> b = new GenericList<String>();
      b.add("Hello");
      b.add("Bye");
      b.set(2, "Bonjour");
    }

  @Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testDeleteException()
    {
      GenericList<String> b = new GenericList<String>();
      b.add("hello");
      b.remove(0);
      b.remove(0);
    }

  @Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testInsertException()
    {
      GenericList<String> b = new GenericList<String>();
      b.add("hello");
      b.insert(2, "bye");
    }

  @Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testInsertNegative()
    {
      GenericList<String> b = new GenericList<String>();
      b.insert(-1, "hello");
    }

  @Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testDeleteException2()
    {
      GenericList<String> b = new GenericList<String>();
      b.add("hello");
      b.remove(1);
    }

  @Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testDeleteNegative()
    {
      GenericList<String> b = new GenericList<String>();
      b.remove(-1);
    }

  @Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testDeleteEmpty()
    {
      GenericList<String> b = new GenericList<String>();
      b.add("hello");
      b.remove(0);
      b.remove(0);
    }
    
  @Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
    public void testHomework1()
    {
      GenericList<Integer> b = new GenericList<Integer>();
      b.add(44);
      b.insert(-1, 55);
    }
    
  @Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
  public void testHomework2()
  {
    GenericList<Integer> b = new GenericList<Integer>();
    b.add(69);
    b.remove(3);
  }
    
  @Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
  public void testHomework3()
  {
    GenericList<Integer> b = new GenericList<Integer>();
    b.get(0);
  }
    
}

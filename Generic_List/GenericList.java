public class GenericList<X>
{
  private X[] arr;
  private int size;
  
  public GenericList()
  {
    this.newArray(); 
  }
  
  
  public int size()
  {
     return size;
  }
  
  public void add(X value)
  {
    //System.out.println("add Array length: " + arr.length);
    //System.out.println("add Size: " + size);
    //System.out.println("Value " + value);
    
    if(size == arr.length)
    {
      this.expandArray(); 
    }
    
    arr[size] = value;
    size++;
  }
  
  public X get(int index) throws ArrayIndexOutOfBoundsException
    {
      if(index >=0 && index < size)
      {
        return arr[index];
      }
      
      else
      {
        throw new ArrayIndexOutOfBoundsException();
        //System.out.println("ERROR: Index is not within bounds (get method)"); 
        //return null;
      }
     
    }
    
  public void display()
  {
    //System.out.println("Array length: " + arr.length);
    //System.out.println("Size: " + size);
    for(int i = 0; i < size; i++)
    {
      
      System.out.println(i + ":" + arr[i]);
    }
    
    if(arr.length == size)
    {
      System.out.println("List is full\n");
    }
    
    else
    {
      System.out.println("List has " + (arr.length - size) + " space(s) left\n");
    }
  }
  
  private void newArray()
  {
    arr = (X[])new Object[10];
    size = 0;
  } 
  
  private void expandArray()
  {
    X[] arr2;
    arr2 = (X[])new Object[(int)(arr.length*1.2)];
        
    for(int i =0; i < arr.length; i++)
    {
      arr2[i] = arr[i];
    }  
    arr = arr2;
  }
  
  public void insert(int index, X value) throws ArrayIndexOutOfBoundsException
  {
    /*System.out.println("This is the insert index: " + index);
    System.out.println("This is the insert value: " + value);
    System.out.println("Array length: " + arr.length);
    System.out.println("Size: " + size);*/
    
    if(index < 0 || size < index)
    {
      throw new ArrayIndexOutOfBoundsException();
    } 
    
    else if (index >= size)
    {
      add(value);
    }
    
    else//Shift elements to insert
    {
      if(size == arr.length)//make more room to insert
      {
        this.expandArray();
      }
      
      for(int i = size; i > index; i--)//insert one more value/open a hole
      {
        arr[i] = arr[i-1];
      }  
      arr[index] = value;
      size++;
    }
  }
  
  public String toString()
  {
    String returnValue = String.valueOf(arr[0]);
   
    if(size == 0)
    {
      return "";
    }
    
    else
    {
    
      for(int i =1; i < size; i++)
      {
        returnValue = returnValue + ", " + arr[i];
      }
    
      return returnValue;
    }
  } 
  
  public void clear()
  {
    //arr = new X [10];
    //size = 0;
    this.newArray();
  }
  
  public void set(int index, X value) throws ArrayIndexOutOfBoundsException
  {
    if(index >=0 && index < size)
    {
      arr[index]= value;
    }
    
    else
    {
      throw new ArrayIndexOutOfBoundsException();
      //System.out.println("ERROR: Index is greater than the size (set method)");
    }
  } 
  
  public void remove(int index) throws ArrayIndexOutOfBoundsException
  {
    //System.out.println("Index inside remove method. Index = " + index);
    if(index >= 0 && index < size)
    {
      //arr[index] = 0;
      
      for(int i = index; i < size - 1; i++)
      {
        //System.out.println("Move arr["+ i +"] from arr[" + (i + 1) +"]" ); 
        arr[i] = arr[i+1];
      }  
      size--;
      //System.out.println("Size at the end of remove method " + size);
    }
    
    else
    {
      throw new ArrayIndexOutOfBoundsException();
      //System.out.println("ERROR: Index is not within boundaries (remove method)");
    }
  }
}
package com.mycompany.a3;

public class GameObjectCollection implements ICollection {
	 
	private GameObject[] theCollection;
	private int i = 0;
	
	public GameObjectCollection() {
		
		theCollection = new GameObject[8];
	}
	
	public GameObject[] getGOC() {
		return theCollection;
	}

	public void add(GameObject go) {
		theCollection[i] = go;
		i++;
	} 
	
	public IIterator getIterator() {
		return new ObjectArrayIterator();
	}
	
	private class ObjectArrayIterator implements IIterator {
		private int currentIndex;
		
		public ObjectArrayIterator(){
			currentIndex = - 1;
		}
		
		public boolean hasNext() {
			if(theCollection.length <= 0)
			{
				return false;
			}
			
			else if(currentIndex == theCollection.length - 1)
			{
				return false;
			}
			
			else
			{
				return true;
			}
		}
		
		public Object getNext() {
			currentIndex++;
			return (theCollection[currentIndex]);
		}
		
		
	}
}


package com.mycompany.a3;

import com.mycompany.a3.GameObject;
import com.mycompany.a3.IIterator;

public interface ICollection {
	
	public void add(GameObject go);
	public IIterator getIterator(); 

}
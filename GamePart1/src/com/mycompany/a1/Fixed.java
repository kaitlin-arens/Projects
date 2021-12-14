package com.mycompany.a1;



public abstract class Fixed extends GameObject{
	
	public Fixed(int size, int x, int  y, int r, int g, int b) {
		super(size, x, y, r, g, b);
		
		
	} 
	
	public void setLocation(int x, int y) {}
	
	public abstract void setColor(int r, int g, int b);

}

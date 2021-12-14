package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;
import com.codename1.ui.*;

public class MapView extends Container implements Observer{


	public MapView(Observable myGW) {
		
		/*System.out.println("Did you make it to MapView?");
		myGW.addObserver(this);
		CheckBox myCheck = new CheckBox("Check me out!");
		this.addComponent(myCheck);
		this.show();*/
	}

	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		//observable.map();
		//System.out.println("Did you make it to MapView?");
		
	}

}

package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Left extends Command{
	GameWorld g;

	public Left(GameWorld g) {
		super("Left");
		this.g = g;
		//System.out.println("Made it to the accelerate");
		//setTarget(g);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		
		
		g.left();
		
	}

}
package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Brake extends Command{
	GameWorld g;

	public Brake(GameWorld g) {
		super("Brake");
		this.g = g;
		//System.out.println("Made it to the accelerate");
		//setTarget(g);
	}

	@Override
	public void actionPerformed(ActionEvent e){

		g.brake();
		
	}

}

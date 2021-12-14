package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Accelerate extends Command{
	GameWorld g;

	public Accelerate(GameWorld g) {
		super("Accelerate");
		this.g = g;
		//System.out.println("Made it to the accelerate");
		//setTarget(g);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		
		//System.out.println("Made it to the accelerate");
		g.accelerate();
		
	}

}

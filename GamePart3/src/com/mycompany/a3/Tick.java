package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Tick extends Command{
	GameWorld g;

	public Tick(GameWorld g) {
		super("Tick");
		this.g = g;
	}

	@Override
	public void actionPerformed(ActionEvent e){

		g.time();
		
	}

}

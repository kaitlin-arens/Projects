package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CollideWithFood extends Command{
	GameWorld g;

	public CollideWithFood(GameWorld g) {
		super("Collide with Food");
		this.g = g;
	}

	@Override
	public void actionPerformed(ActionEvent e){

		g.gotFood();
		
	}

}
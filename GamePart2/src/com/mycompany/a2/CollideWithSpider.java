package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CollideWithSpider extends Command{
	GameWorld g;

	public CollideWithSpider(GameWorld g) {
		super("Collide with Spider");
		this.g = g;
	}

	@Override
	public void actionPerformed(ActionEvent e){

		g.attack();
		
	}

}

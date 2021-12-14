package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Yes extends Command{
	GameWorld g;

	public Yes(GameWorld g) {
		super("Yes");
		this.g = g;
	}

	@Override
	public void actionPerformed(ActionEvent e){

		g.yes();
		
	}

}

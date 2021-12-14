package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Right extends Command{
	GameWorld g;

	public Right(GameWorld g) {
		super("Right");
		this.g = g;
	}

	@Override
	public void actionPerformed(ActionEvent e){

		g.right();
		
	}

}

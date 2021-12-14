package com.mycompany.a3;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;

public class SoundCheck extends Command{
	GameWorld gw;
	ScoreView sv;

	public SoundCheck(ScoreView sv, GameWorld gw) {
		super("SoundCheck");
		this.gw = gw;
		this.sv = sv;
	}

	@Override
	public void actionPerformed(ActionEvent e){

		if(((CheckBox)e.getComponent()).isSelected()) {
			sv.setCheckStatus(true);
			gw.background.play();
			gw.b= true;
		}
		
		else {
			sv.setCheckStatus(false);
			gw.background.pause();
			gw.b= false;
		}
			
	}

}

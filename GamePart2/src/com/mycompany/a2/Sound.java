package com.mycompany.a2;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;

public class Sound extends Command{
	GameWorld g;
	ScoreView sv;
	private Label on;
	private Label off;

	public Sound(ScoreView sv) {
		super("Sound");
		this.g = g;
		this.sv = sv;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(((CheckBox)e.getComponent()).isSelected()) {
			sv.setCheckStatus(true);
			//String s = "Sound: ON";
			//sv.sound.setText(s);
			//sv.sound.repaint();
		}
		else {
			sv.setCheckStatus(false);
			//String s2 = "Sound: OFF";
			//sv.sound.setText(s2);
			//sv.sound.repaint();
		}
			
	}

}

package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;

public class ScoreView extends Container implements Observer{
	
	private Label time;
	private String t;
	private Label lives;
	private String l;
	private Label flag;
	private String f;
	private Label foodLevel;
	private String fl;
	private Label healthLevel;
	private String h;
	Label sound;
	private GameWorld g;
	private int i = 1;


	public ScoreView(Observable myModel) {
		super(new GridLayout(1,6));
		GameWorld g = (GameWorld) myModel;
		add(time = new Label("Time: 000" ) );
		add(lives = new Label("Lives: 3" ));
		add(flag = new Label("Last Flag Reached: 0"));
		add(foodLevel = new Label("New Food Level: 50"));
		add(healthLevel = new Label("Health Level: 10"));
		add(sound = new Label("Sound: OFF"));
		time.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		lives.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		flag.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		foodLevel.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		healthLevel.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		sound.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
	}

	@Override
	public void update(Observable ob, Object data) {
		// TODO Auto-generated method stub
		GameWorld g = (GameWorld) ob;

		t = "Time: " + Integer.toString(g.getTime());
		time.setText(t);
		time.repaint();
		l = "Lives: " + Integer.toString(g.getLives()); 
		lives.setText(l);
		lives.repaint();
		f = "Last Flag Reached: " + Integer.toString(g.gotTheFlag(i));
		flag.setText(f);
		flag.repaint();
		fl = "New Food Level: " + Integer.toString(g.foodLevel()) + " ";
		foodLevel.setText(fl);
		foodLevel.repaint();
		h = "Health Level: " + Integer.toString(g.health());
		healthLevel.setText(h);
		healthLevel.repaint();
		
	}
	
	public void setCheckStatus(boolean b) {
		if(b) {
			sound.setText("Sound: ON");
		}
		else {
			sound.setText("Sound: OFF");
		}
		
		revalidate();
	}
	
}


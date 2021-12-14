package com.mycompany.a3;
import com.codename1.charts.util.ColorUtil;
import com.codename1.media.MediaManager;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.codename1.ui.events.ActionEvent;

import java.io.InputStream;
import java.lang.String;  


public class Game extends Form implements Runnable{ 
	private GameWorld gw;
	private ScoreView sv;
	private MapView mv;
	private Accelerate acc;
	private Left left;
	private Brake brake;
	private Right right;
	private CollideWithFlag cwf;
	private CollideWithSpider cws;
	private CollideWithFood cwfood;
	private Exit e;
	private Tick t;
	private About ab;
	private SoundCheck sc;
	private Pause pause;
	private Help help;
	public static int width;
	public static int height;
	public static boolean b;
	public static int leftContX;
	Button p;
	
	
	public Game() {
		
		gw = new GameWorld(this);//create observable model
		sv = new ScoreView(gw);
		mv = new MapView(gw);
		gw.addObserver(mv);
		gw.addObserver(sv);
		acc = new Accelerate(gw);
		left = new Left(gw);
		brake = new Brake(gw);
		right = new Right(gw);
		cwf = new CollideWithFlag(gw);
		cws = new CollideWithSpider(gw);
		cwfood = new CollideWithFood(gw);
		t = new Tick(gw);
		e = new Exit(gw);
		ab = new About(gw);
		sc = new SoundCheck(sv, gw);
		help = new Help(gw);
		pause = new Pause(gw, this);
		

		
		this.setLayout(new BorderLayout());
		Toolbar myToolbar = new Toolbar();
		setToolbar(myToolbar);
		this.setTitle("ThePath Game");
		CheckBox menuSound = new CheckBox("SoundCheck");
		myToolbar.addComponentToSideMenu(menuSound);
		menuSound.getAllStyles().setBgTransparency(255);
		menuSound.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		menuSound.setCommand(sc);
		myToolbar.closeSideMenu();
		myToolbar.addCommandToRightBar(help);

		myToolbar.addCommandToSideMenu(acc);
		myToolbar.addCommandToSideMenu(ab);
		myToolbar.addCommandToSideMenu(e);
		
		
		addKeyListener('a', acc);
		addKeyListener('b', brake);
		addKeyListener('l', left);
		addKeyListener('r', right);
		//addKeyListener('f', cwfood);
		//addKeyListener('g', cws);
		//addKeyListener('t', t);
		
		
		sv.setLayout(new FlowLayout(Component.CENTER));
		add(BorderLayout.NORTH, sv);
		
		
		Container southCont = new Container(new GridLayout(1,4));
		southCont.setLayout(new BoxLayout(BoxLayout.X_AXIS));//////////////////////Buttons have been removed
		/*southCont.setLayout(new FlowLayout(Component.CENTER));
		Button collideFlag = new Button("Collide with Flag");
		setButton(collideFlag);
		collideFlag.setCommand(cwf);
		southCont.add(collideFlag);
		Button collideSpider = new Button("Collide with Spider");
		setButton(collideSpider);
		collideSpider.setCommand(cws);
		southCont.add(collideSpider);
		Button collideFood = new Button("Collide with Food Station");
		setButton(collideFood);
		collideFood.setCommand(cwfood);
		southCont.add(collideFood);*/
		
		
		/*Button clock = new Button("Tick");
		setButton(clock);
		clock.setCommand(t);
		southCont.add(clock);*/
	
		
		southCont.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		add(BorderLayout.SOUTH, southCont);
		
		//Container centerCont = new Container();
		//centerCont.setLayout(new FlowLayout());
		mv.getUnselectedStyle().setBorder(Border.createLineBorder(3, ColorUtil.rgb(255, 0, 0)));
		//mv.setLayout(new FlowLayout());
		//mv.add(new Label("Hello"));
		//add(BorderLayout.CENTER, centerCont);
		add(BorderLayout.CENTER, mv);
		
		
		
		Container rightCont = new Container(new GridLayout(2, 1));
		rightCont.setLayout(new FlowLayout(Component.CENTER));
		rightCont.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		Button brk = new Button("Brake");
		setButton(brk);
		brk.setCommand(brake);
		rightCont.add(brk);
		Button r = new Button("Right");
		setButton(r);
		r.setCommand(right);
		rightCont.add(r);
		rightCont.getUnselectedStyle().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		add(BorderLayout.EAST, rightCont);
		
		
		Container leftCont = new Container(new GridLayout(2,1));
		leftCont.setLayout(new FlowLayout(Component.CENTER));
		leftCont.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		Button accelerate = new Button("Accelerate");
		setButton(accelerate);
		accelerate.setCommand(acc);
		leftCont.add(accelerate);
		Button l = new Button("Left");
		setButton(l);
		l.setCommand(left);
		leftCont.add(l);
		leftCont.getUnselectedStyle().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		add(BorderLayout.WEST, leftCont);
		
		
		this.show();

		gw.init();
	
		Button p = new Button("Pause");
		setButton(p);
		p.setCommand(pause);
		southCont.add(p);
			
		
		gw.createSounds();
		//gw.bgsound(SoundCheck.b);
		
		revalidate();
		//gw.background.play();
		UITimer timer = new UITimer(this);
		timer.schedule(450, true, this);
		leftContX = leftCont.getWidth();
		width = mv.getWidth();
		height = mv.getHeight();
		//System.out.println("Map Width: " + width + " Map Height: " + height);
	} 
	
	public static int getMVWidth() {
		return width;
	}
	
	public static int getMVHeight() {
		return height;
	}
	
	public static int getLeftContX() {
		return leftContX;
	}
	
	private void setButton(Button b) {
		b.getUnselectedStyle().setBgTransparency(255);
		b.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		b.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		b.getUnselectedStyle().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		b.getAllStyles().setPadding(Component.TOP, 10);
		b.getAllStyles().setPadding(Component.BOTTOM, 10);
		
	}
	
	void pause(boolean bool) {
		if(bool == true) {
			p.setText("Play");
			//System.out.println("Made it to pause method");
		}
		else
		{
			p.setText("Pause");
		}
	}
	
	
	public void run() {
		// TODO Auto-generated method stub
		gw.time();
		mv.repaint();
	}


}
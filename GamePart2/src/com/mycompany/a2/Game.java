package com.mycompany.a2;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;  


public class Game extends Form{ 
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
	private Sound sound;
	private Help help;
	int width;
	int height;
	
	public Game() {
		gw = new GameWorld();//create observable model
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
		sound = new Sound(sv);
		help = new Help(gw);
		
		this.setLayout(new BorderLayout());
		Toolbar myToolbar = new Toolbar();
		setToolbar(myToolbar);
		this.setTitle("ThePath Game");
		CheckBox menuSound = new CheckBox("Sound");
		myToolbar.addComponentToSideMenu(menuSound);
		menuSound.getAllStyles().setBgTransparency(255);
		menuSound.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		menuSound.setCommand(sound);
		myToolbar.closeSideMenu();
		myToolbar.addCommandToRightBar(help);

		myToolbar.addCommandToSideMenu(acc);
		myToolbar.addCommandToSideMenu(ab);
		myToolbar.addCommandToSideMenu(e);
		
		
		addKeyListener('a', acc);
		addKeyListener('b', brake);
		addKeyListener('l', left);
		addKeyListener('r', right);
		addKeyListener('f', cwfood);
		addKeyListener('g', cws);
		addKeyListener('t', t);
		
		
		sv.setLayout(new FlowLayout(Component.CENTER));
		add(BorderLayout.NORTH, sv);
		
		
		Container southCont = new Container(new GridLayout(1,4));
		southCont.setLayout(new BoxLayout(BoxLayout.X_AXIS));
		southCont.setLayout(new FlowLayout(Component.CENTER));
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
		southCont.add(collideFood);
		Button clock = new Button("Tick");
		setButton(clock);
		clock.setCommand(t);
		southCont.add(clock);
		southCont.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		add(BorderLayout.SOUTH, southCont);
		
		//Container centerCont = new Container();
		//centerCont.setLayout(new FlowLayout());
		mv.getUnselectedStyle().setBorder(Border.createLineBorder(3, ColorUtil.rgb(255, 0, 0)));
		add(BorderLayout.CENTER, mv);
		
		
		Container rightCont = new Container(new GridLayout(2, 1));
		rightCont.setLayout(new FlowLayout(Component.CENTER));
		rightCont.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		Button brk = new Button("Break");
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
		
		width = mv.getWidth();
		height = mv.getHeight();
		//System.out.println("Map Width: " + width + " Map Height: " + height);
		
		this.show();

		gw.init();
	}
	
	private void setButton(Button b) {
		b.getUnselectedStyle().setBgTransparency(255);
		b.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		b.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		b.getUnselectedStyle().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		b.getAllStyles().setPadding(Component.TOP, 10);
		b.getAllStyles().setPadding(Component.BOTTOM, 10);
		
	}

/*	private void play(){
	
		
	 Label myLabel=new Label("Enter a Command:");
	 this.addComponent(myLabel);
	 final TextField myTextField=new TextField();
	 this.addComponent(myTextField);
	 this.show();
	 
	 myTextField.addActionListener(new ActionListener(){
		 
		 public void actionPerformed(ActionEvent evt) {

			 String sCommand=myTextField.getText().toString();
			 myTextField.clear();
			 if(sCommand.length() != 0)
				 switch (sCommand.charAt(0)) {
			 		case 'a':
			 			gw.accelerate();
			 			break;
			 		case 'b':
			 			gw.brake();
			 			break;
				 	case 'm':
				 		gw.map();
				 		break;
				 	case 'l':
				 		gw.left();
				 		break;
				 	case 'r':
				 		gw.right();
				 		break;
				 	case'1': 
				 		gw.gotFlag(1);
				 		break;
				 	case'2': 
				 		gw.gotFlag(2);
				 		break;
				 	case'3': 
				 		gw.gotFlag(3);
				 		break;
				 	case'4': 
				 		gw.gotFlag(4);
				 		break;
				 	case'5': 
				 		gw.gotFlag(5);
				 		break;
				 	case'6': 
				 		gw.gotFlag(6);
				 		break;
				 	case '7': 
				 		gw.gotFlag(7);
				 		break;
				 	case '8': 
				 		gw.gotFlag(8);
				 		break;
				 	case '9':
				 		gw.gotFlag(9);
				 		break;
				 	case 'f':
				 		gw.gotFood();
				 		break;
				 	case 'g':
				 		gw.attack();
				 		break;
				 	case't':
				 		gw.time();
				 		break;
				 	case'd':
				 		gw.displayStats();
				 		break;
				 	case'x':
				 		gw.exit();
				 		break;
				 		
				 	case'y':
				 		gw.yes();
				 		
				 		break;
				 	case'n':
				 		gw.nope();
				 		break;
				 		
			 			
				 } //switch
				 			 			
		 } //actionPerformed
		  		
	 } //new ActionListener()
	 ); //addActionListener
	 } //play */

}


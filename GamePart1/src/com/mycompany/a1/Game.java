package com.mycompany.a1;
import com.codename1.ui.Form; 
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;


public class Game extends Form{
	private GameWorld gw;

	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}

	
	
	private void play(){
	
		
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
				 		/*Label myLabel2=new Label("Enter a Command:");
				 		addComponent(myLabel2);
				 		final TextField myTextField2 = new TextField();
				 		addComponent(myTextField2);
				 		show();
				 		
				 	
				 		
				 		sCommand=myTextField2.getText().toString();
						myTextField.clear();
						System.out.println("About to go into the if statement " + sCommand.length());
				 		if(sCommand.length() != 0) 
				 			System.out.println("Made it past the if");
					 		switch(sCommand.charAt(0)) {
						 		case 'y':
						 			System.out.println("Byeeeeeeeee");
							 		//System.exit(0);
							 		break;
		
						 		case 'n':
						 		default:
						 			System.out.println("Have fun playing!");
						 			break;
					 		}
					 		System.out.println("Past if statement");
				 		//}
					 	System.out.println("Past if part 2");	
				 		break;*/
				 	case'y':
				 		gw.yes();
				 		
				 		break;
				 	case'n':
				 		gw.nope();
				 		break;
				 		
			 			
	 //add code to handle rest of the commands
				 } //switch
				 			 			
		 } //actionPerformed
		  		
	 } //new ActionListener()
	 ); //addActionListener*/
	 } //play 

}

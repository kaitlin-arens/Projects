package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.FlowLayout;

public class CollideWithFlag extends Command{
	GameWorld g;
	int i;

	public CollideWithFlag(GameWorld g) {
		super("Collide with Flag");
		this.g = g;
	}

	@Override
	public void actionPerformed(ActionEvent e){

		
		Dialog dlg = new Dialog("Exit");
		dlg.setLayout(new FlowLayout(Component.BOTTOM));

		Command okay = new Command("Okay");
		Command cancel = new Command("Cancel");
		Command [] cmds = new Command[] {okay, cancel};
		TextField tf = new TextField();
		Command c = Dialog.show("Choose a flag between 1-9", tf, cmds);
			if(c == okay) {
				String s = tf.getText();
				//i = (int)s;
				switch (s.charAt(0)) {		
				 	case'1': 
				 		g.gotFlag(1);
				 		break;
				 	case'2': 
				 		g.gotFlag(2);
				 		break;
				 	case'3': 
				 		g.gotFlag(3);
				 		break;
				 	case'4': 
				 		g.gotFlag(4);
				 		break;
				 	case'5': 
				 		g.gotFlag(5);
				 		break;
				 	case'6': 
				 		g.gotFlag(6);
				 		break;
				 	case '7': 
				 		g.gotFlag(7);
				 		break;
				 	case '8': 
				 		g.gotFlag(8);
				 		break;
				 	case '9':
				 		g.gotFlag(9);
				 		break;
				 	default:
				 		System.out.println("Error: Please try again");
				 		break;
					}//end switch
		}//end if
			
				
	}//end actionPerformed

}
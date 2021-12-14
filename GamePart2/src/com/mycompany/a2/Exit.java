package com.mycompany.a2;

import com.codename1.components.ButtonList;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.FlowLayout;

public class Exit extends Command{
	GameWorld g;

	public Exit(GameWorld g) {
		super("Exit");
		this.g = g;
	}
	

	@Override
	public void actionPerformed(ActionEvent e){
		Dialog dlg = new Dialog("Exit");
		dlg.setLayout(new FlowLayout(Component.BOTTOM));

		Command leave = new Command("Yes");
		Command stay = new Command("No");
		Command [] cmds = new Command[] {leave, stay};
		Command c = Dialog.show("Are you sure you want to quit?", "Click Yes to quit, click no to return to game", cmds);
		if(c==leave) {
			//System.exit(0);
			Display.getInstance().exitApplication();
		}

	}

}
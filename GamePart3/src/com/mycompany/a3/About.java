package com.mycompany.a3;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;

public class About extends Command{
	GameWorld g;

	public About(GameWorld g) {
		super("About");
		this.g = g;
	}

	@Override
	public void actionPerformed(ActionEvent e){

		Dialog dlg = new Dialog("About");
		dlg.setLayout(new FlowLayout(Component.BOTTOM));
		dlg.add(new SpanLabel("Kaitlin Arens, CSC 133"));
		int h = Display.getInstance().getDisplayHeight();
		dlg.setDisposeWhenPointerOutOfBounds(true);
		dlg.show(h/8*7,0,0,0);
	}

}
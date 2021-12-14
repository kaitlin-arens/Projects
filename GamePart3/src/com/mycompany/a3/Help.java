package com.mycompany.a3;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.FlowLayout;

public class Help extends Command{
	GameWorld g;

	public Help(GameWorld g) {
		super("Help");
		this.g = g;
	}

	@Override
	public void actionPerformed(ActionEvent e){

		Dialog dlg = new Dialog("About");
		dlg.setLayout(new FlowLayout(Component.CENTER));
		dlg.add(new SpanLabel("Press a to accelerate the speed of the ant."));
		dlg.add(new SpanLabel("Press b to slow down the ant."));
		dlg.add(new SpanLabel("Press l to turn left."));
		dlg.add(new SpanLabel("Press r to turn right."));
		dlg.add(new SpanLabel("Press f to collide with a food station."));
		dlg.add(new SpanLabel("Press g to collide with a spider."));
		dlg.add(new SpanLabel("Press t to increase the time."));
		dlg.setDisposeWhenPointerOutOfBounds(true);
		dlg.show();
	}

}

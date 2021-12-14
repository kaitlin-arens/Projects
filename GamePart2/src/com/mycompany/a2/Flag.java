package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class Flag extends Fixed { 
	
	int sequenceNumber=0;
	static int instanceCounter;
	int flagColor;
	
	public Flag(int size, int x, int y, int r, int g, int b) {
		super(size, x, y, r, g, b);
		flagColor = ColorUtil.rgb(r, g, b);
		instanceCounter++;
        sequenceNumber = instanceCounter;
	}
	
	public int getSequenceNumber() {
		return sequenceNumber;
	}

} 
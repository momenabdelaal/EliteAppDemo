package com.mobily.elite.appUtils;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import java.util.Random;

public class UtilsColor {
	private static Random mRandom = new Random();

	public static ColorDrawable[] vibrantLightColorList =
			{
					new ColorDrawable(Color.parseColor("#ffeead")),
					new ColorDrawable(Color.parseColor("#93cfb3")),
					new ColorDrawable(Color.parseColor("#fd7a7a")),
					new ColorDrawable(Color.parseColor("#faca5f")),
					new ColorDrawable(Color.parseColor("#1ba798")),
					new ColorDrawable(Color.parseColor("#6aa9ae")),
					new ColorDrawable(Color.parseColor("#ffbf27")),
					new ColorDrawable(Color.parseColor("#d93947"))
			};

	public static ColorDrawable getRandomDrawbleColor() {
		int idx = new Random().nextInt(vibrantLightColorList.length);
		return vibrantLightColorList[idx];
	}
	public static int getRandomColorCode(){

		Random random = new Random();

		return Color.argb(255, random.nextInt(257*322), random.nextInt(356*33), random.nextInt(226*434));

	}
 

}

package com.mobily.elite.appUtils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

class ImageUtil {
	public static void with(Context context, String imageUrl, ImageView imageView) {
		Glide.with(context).load(imageUrl).into(imageView);
	}

}

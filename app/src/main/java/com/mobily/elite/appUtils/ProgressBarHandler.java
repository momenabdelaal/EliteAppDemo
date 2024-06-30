package com.mobily.elite.appUtils;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.core.content.ContextCompat;

import com.mobily.elite.R;


class ProgressBarHandler {
	private ProgressBar mProgressBar;

	public ProgressBarHandler(Context context) {

		ViewGroup layout = (ViewGroup) ((Activity) context).findViewById(android.R.id.content).getRootView();

		mProgressBar = new ProgressBar(context, null);
		mProgressBar.setIndeterminate(true);

		mProgressBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(context, R.color.colorAccent),
				android.graphics.PorterDuff.Mode.MULTIPLY);

		RelativeLayout.LayoutParams params = new
				RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

		RelativeLayout rl = new RelativeLayout(context);

		rl.setGravity(Gravity.CENTER);
		rl.addView(mProgressBar);

		layout.addView(rl, params);

		hideProgress();
	}

	//to show progress bar
	public void showProgress() {
		mProgressBar.setVisibility(View.VISIBLE);
	}

	//to hide progress bar
	public void hideProgress() {
		mProgressBar.setVisibility(View.INVISIBLE);
	}
}

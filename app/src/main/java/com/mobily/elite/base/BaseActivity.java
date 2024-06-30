package com.mobily.elite.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.mobily.elite.R;
import com.mobily.elite.appUtils.Constants;
import com.mobily.elite.appUtils.Localization.LocalizationUtils;
import com.mobily.elite.appUtils.MovementHelper;
import com.mobily.elite.databinding.ActivityBaseBinding;
import com.mobily.elite.ui.home.HomeFragment;

import java.util.Objects;


public class BaseActivity extends AppCompatActivity {
	Fragment fragment = null;

	public ActivityBaseBinding activityBaseBinding;
	Bundle bundle;
	BaseActivityViewModel baseActivityViewModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		activityBaseBinding = DataBindingUtil.setContentView(BaseActivity.this,
				R.layout.activity_base);
		init();

	}

	private void init() {
		baseActivityViewModel = new ViewModelProvider(this).get(BaseActivityViewModel.class);
		activityBaseBinding.setLifecycleOwner(this);
		bundle = new Bundle();

		if (getIntent().getExtras() != null) {
			addFragment(getIntent().getExtras().getInt(Constants.INTENT_PAGE, 0));
		}


		activityBaseBinding.imgActionBarBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onBackPressed();
			}
		});
	}
	private void addFragment(int page) {
		switch (page){
			case Constants.LOGIN_PAGE:
				serializable(new HomeFragment());
				break;
//			case Constants.REGISTER_PAGE:
//				serializable(new RegisterationFragment());
//				break;
//				case Constants.FORGET_PASSWORD_PAGE:
//				serializable(new ForgetPasswordFragment());
//				break;
//			case Constants.VERIFY_CODE_PAGE:
//				serializable(new VerifyCodeFragment());
//				break;
//			case Constants.CONFIRM_PASSWORD_PAGE:
//				serializable(new ConfirmPasswordFragment());
//				break;

		}

		try {
			MovementHelper.addFragment(BaseActivity.this,
					fragment, Constants.CONTAINER_BASE_ACTIVITY_ID, "");
		} catch (Exception e) {
			e.getStackTrace();
		}


	}
 	private void serializable(Fragment fragment2) {
		fragment = fragment2;
		bundle.putSerializable(Constants.INTENT_BUNDLE,
				Objects.requireNonNull(getIntent().getExtras()).getSerializable(Constants.INTENT_BUNDLE));
		fragment.setArguments(bundle);
	}
	@Override
	protected void attachBaseContext(Context newBase) {
		super.attachBaseContext(newBase);
		//MessagesManager.sToast(this, "BattachBase");

	}

	@Override
	protected void onStart() {
		super.onStart();
		LocalizationUtils.setDefaultFontConfiguration(BaseActivity.this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

	//	MessagesManager.sToast(this, "BDestroy");

	}


	@Override
	public void onBackPressed() {

		Fragment frag = getSupportFragmentManager()
				.findFragmentById(Constants.CONTAINER_BASE_ACTIVITY_ID);
		finish();
	//	MessagesManager.sToast(this, "BPressed");


	}


}

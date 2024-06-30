package com.mobily.elite.main;

import static androidx.navigation.Navigation.findNavController;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.mobily.elite.R;
import com.mobily.elite.databinding.ActivityMainBinding;


import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding activityMainBinding;
    MainActivityViewModel viewModel;
//    LogoutViewModel logoutViewModel;
    Bundle bundle;
    private long backPressedTime;
    private Toast backToast;
    FragmentManager fm = getSupportFragmentManager();
    Fragment fragment = null;
    public static String TAG = "TAG";
    NavController mNavController;


    private HashMap<String, Object> firebaseDefaultMap;
    public static final String VERSION_CODE_KEY = "latest_app_version";
    private AlertDialog updateDailog;


    private int REQUEST_CODE = 11;


    //https://github.com/aurelhubert/ahbottomnavigation
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);



        init();
//        getPermissions();
//        prepareBottomNavigation();
//        UpdateApp();


    }


    private void init() {
        //Init Nav Graph
        mNavController = findNavController(this, R.id.host_fragment);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        activityMainBinding.setLifecycleOwner(this);
        bundle = new Bundle();
        setupToolbar();
//        get_countCardNumber();
//        //Android In app force update implementation
//
//        //initRemoteConfig();
//        UpdateAppTwo();

//        activityMainBinding.toolbarLy.parntBar.setVisibility(View.VISIBLE);

        mNavController.navigate(R.id.categoryFragment);
    }

    private void setupToolbar() {


    }




//    public void getPermissions() {
//        Dexter.withContext(this)
//                .withPermissions(Manifest.permission.CAMERA,
//                        Manifest.permission.ACCESS_FINE_LOCATION,
//                        Manifest.permission.ACCESS_COARSE_LOCATION,
//                        Manifest.permission.READ_EXTERNAL_STORAGE,
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE).withListener(new MultiplePermissionsListener() {
//            @Override
//            public void onPermissionsChecked(MultiplePermissionsReport report) {
//                // check if all permissions are granted
//                report.areAllPermissionsGranted();
//                // check for permanent denial of any permission
//                if (report.isAnyPermissionPermanentlyDenied()) {
//                    // permission is denied permenantly, navigate user to app settings
//                    Intent intent = new Intent();
//                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//                    Uri uri = Uri.fromParts("package", getPackageName(), null);
//                    intent.setData(uri);
//                    startActivity(intent);
//                }
//            }
//
//            @Override
//            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
//                permissionToken.continuePermissionRequest();
//            }
//        }).onSameThread().check();
//    }


//    private void prepareBottomNavigation() {
//
//        //activityMainBinding.bottomNavigation.setCount(1, "115");
//        RequestOptions requestOptions = new RequestOptions();
//
//        if (getUserProfile() != null) {
//            token = Objects.requireNonNull(getUserProfile()).getToken();
//
//            activityMainBinding.bottomNavigation.setVisibility(View.VISIBLE);
//            activityMainBinding.bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_message_bottom));
//            activityMainBinding.bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_paper_battom));
//            activityMainBinding.bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_home_24));
//            activityMainBinding.bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_dollorchart));
//            activityMainBinding.bottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.ic_menu_bottom));
//            Glide.with(MainActivity.this)
//                    .load(getUserProfile().getImage())
//                    .error(R.drawable.placeholder_image)
//                    .apply(requestOptions)
//                    .listener(new RequestListener<Drawable>() {
//                        @Override
//                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                            requestOptions.autoClone();
//                            requestOptions.clone();
//                            return false;
//                        }
//
//                        @Override
//                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                            requestOptions.autoClone();
//                            requestOptions.clone();
//                            return false;
//                        }
//                    })
//                    .into(activityMainBinding.toolbarLy.actionMenu);
//            getnotificationCount();
//
//        }
//
//
//        activityMainBinding.bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
//            @Override
//            public void onClickItem(MeowBottomNavigation.Model item) {
//                switch (item.getId()) {
//                    case 1:
//                        mNavController.navigate(R.id.inboxFragment);
//                        activityMainBinding.toolbarLy.parntBar.setVisibility(View.VISIBLE);
//                        break;
//                    case 2:
//                        mNavController.navigate(R.id.fragment_NewOrders);
//                        activityMainBinding.toolbarLy.parntBar.setVisibility(View.GONE);
//                        break;
//                    case 3:
//                        mNavController.navigate(R.id.homeFragment);
//                        activityMainBinding.toolbarLy.parntBar.setVisibility(View.VISIBLE);
//                        break;
//                    case 4:
//                        mNavController.navigate(R.id.reportsFragment);
//                        activityMainBinding.toolbarLy.parntBar.setVisibility(View.GONE);
//                        break;
//                    case 5:
//                        mNavController.navigate(R.id.settingsFragment);
//                        activityMainBinding.toolbarLy.parntBar.setVisibility(View.GONE);
//                        break;
//                }
//
//            }
//        });
//        activityMainBinding.bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
//            @Override
//            public void onShowItem(MeowBottomNavigation.Model item) {
//
//
//            }
//        });
//        activityMainBinding.bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
//            @Override
//            public void onReselectItem(MeowBottomNavigation.Model item) {
//                //Toast.makeText(MainActivity.this, ""+name, Toast.LENGTH_SHORT).show();
//                // TODO No thing IN BACKbottom
///*				switch (item.getId()) {
//					case 1:
//						mNavController.navigate(R.id.inboxFragment);
//						activityMainBinding.toolbarLy.parntBar.setVisibility(View.VISIBLE);
//						break;
//					case 2:
//						mNavController.navigate(R.id.fragment_NewOrders);
//						activityMainBinding.toolbarLy.parntBar.setVisibility(View.GONE);
//						break;
//					case 3:
//						mNavController.navigate(R.id.homeFragment);
//						activityMainBinding.toolbarLy.parntBar.setVisibility(View.VISIBLE);
//						break;
//					case 4:
//						mNavController.navigate(R.id.reportsFragment);
//						activityMainBinding.toolbarLy.parntBar.setVisibility(View.GONE);
//						break;
//					case 5:
//						mNavController.navigate(R.id.settingsFragment);
//						activityMainBinding.toolbarLy.parntBar.setVisibility(View.GONE);
//						break;
//				}*/
//            }
//        });
//        // Count Notifications
//			/*activityMainBinding.bottomNavigation.setCount(1, "115");
//			activityMainBinding.bottomNavigation.setCount(2, "115");*/
//
//
//        activityMainBinding.bottomNavigation.show(3, true);
//    }


//    private void getnotificationCount() {
//        notificationCountViewModel.getCount();
//        notificationCountViewModel.getMutableLiveData().observe((LifecycleOwner) this, new Observer<MutableHelper>() {
//            @Override
//            public void onChanged(MutableHelper mutableHelper) {
//                switch (mutableHelper.key) {
//                    case VIEW_SUCCESS:
//                        if (((bottomNotificationModel) mutableHelper.value).getData().getInboxCount() != 0 ||
//                                ((bottomNotificationModel) mutableHelper.value).getData().getOrderCount() != 0 ){
//                            activityMainBinding.bottomNavigation.setCount(1, ((bottomNotificationModel) mutableHelper.value).getData().getInboxCount().toString());
//                            activityMainBinding.bottomNavigation.setCount(2, ((bottomNotificationModel) mutableHelper.value).getData().getOrderCount().toString());
//
//                        }else {}
//                        break;
//                    case VIEW_FAILED:
//                        MessagesManager.showConnectionSnackBar(getApplicationContext(), Type.ERROR, mutableHelper.value.toString());
//                        break;
//                   /* case VIEW_NOT_Authorization:
//                        MessagesManager.sToast(MainActivity.this, mutableHelper.value.toString());
//                        MovementHelper.startBaseActivity(MainActivity.this,
//                                Constants.LOGIN_PAGE, "");
//                        clearUserProfile();
//                        break;*/
//                    case Constants.NETWORK_CONNECTION_ERROR:
//                        MessagesManager.sToastNoServes(getApplicationContext(), R.string.noServices);
//                        break;
//                }
//
//
//            }
//        });
//    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        UpdateApp();
//        UpdateAppTwo();
//        LocalizationUtils.setDefaultFontConfiguration(MainActivity.this);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            if (getUserProfile() == null) {
//                activityMainBinding.toolbarLy.tvUsername.setText(R.string.label_login);
//                activityMainBinding.toolbarLy.tvUsername.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        MovementHelper.startBaseActivity(MainActivity.this,
//                                Constants.LOGIN_PAGE, "");
//                    }
//                });
//            } else {
//                activityMainBinding.toolbarLy.tvUsername.setText(getUserProfile().getName());
//                activityMainBinding.toolbarLy.tvUsername.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(MainActivity.this, getUserProfile().getName() +"  -  "+ "مرحباَ بك فى عمارتك ", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        }
//    }


//    private void settingDialog() {
//        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
//        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        View dialogView = inflater.inflate(R.layout.setting_dialog, null);
//        dialogBuilder.setView(dialogView);
//
//        final AlertDialog show = dialogBuilder.show();
//        show.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//
//        Button ln_logout = dialogView.findViewById(R.id.ln_logout);
//        TextView code_builder = dialogView.findViewById(R.id.code_builder);
//        RadioButton btnarabic = dialogView.findViewById(R.id.btn_arabic);
//        RadioButton btnenglish = dialogView.findViewById(R.id.btn_english);
//        LinearLayout ln_user_profile = dialogView.findViewById(R.id.ln_user_profile);
//        code_builder.setOnClickListener(view -> {
//            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
//
//        });
//
//        if (getUserProfile() == null) {
//            //NewAccount
//            ln_logout.setText(R.string.label_user_new);
//        } else {
//            //logout
//            ln_logout.setText(R.string.label_log_out);
//        }
//        Button buCancel = dialogView.findViewById(R.id.buCancel);
//
//
//        if (LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase(Constants.LANGUAGE_ARABIC)) {
//            btnarabic.setBackgroundTintList(getResources().getColorStateList(R.color.text_btn_Color));
//            btnenglish.setBackgroundTintList(getResources().getColorStateList(R.color.cart_shop_Color));
//        } else {
//            btnenglish.setBackgroundTintList(getResources().getColorStateList(R.color.text_btn_Color));
//            btnarabic.setBackgroundTintList(getResources().getColorStateList(R.color.cart_shop_Color));
//        }
//
//        if (getCurrentLanguage(this).equals("ar"))
//            btnarabic.setChecked(true);
//        else
//            btnenglish.setChecked(true);
//
//
//        /*CLick Listeners*/
//        ln_logout.setOnClickListener(view -> {
//            show.dismiss();
//            if (getUserProfile() == null) {
//                //NewAccount
//                UserPreferenceHelper.clearUserProfile();
//                MovementHelper.startBaseActivity(MainActivity.this
//                        , Constants.LOGIN_PAGE, null);
//            } else {
//                //logout
//                logoutDialog();
//            }
//        });
//
//        btnenglish.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                LocaleHelper.setLocale(MainActivity.this, Constants.LANGUAGE_ENGLISH);
//                Intent restartIntent = new Intent(MainActivity.this, SplashActivity.class);
//                restartIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(restartIntent);
//            }
//        });
//
//        btnarabic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                LocaleHelper.setLocale(MainActivity.this, Constants.LANGUAGE_ARABIC);
//                Intent restartIntent = new Intent(MainActivity.this, SplashActivity.class);
//                restartIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(restartIntent);
//
//            }
//        });
//
//        ln_user_profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                show.dismiss();
//                mNavController.navigate(R.id.settingsFragment);
//
//            }
//        });
//
//        buCancel.setOnClickListener(view -> show.dismiss());
//    }

//    private void logoutDialog() {
//        new iOSDialogBuilder(MainActivity.this)
//                .setTitle(getString(R.string.label_logout))
//                .setSubtitle(getString(R.string.label_desc_log_out))
//                .setBoldPositiveLabel(true)
//                .setCancelable(true)
//                .setPositiveListener(getString(R.string.label_yes),
//                        new iOSDialogClickListener() {
//                            @Override
//                            public void onClick(iOSDialog dialog) {
//                                dialog.dismiss();
//                                UserPreferenceHelper.clearUserProfile();
//                                MovementHelper.startBaseActivity(MainActivity.this
//                                        , Constants.LOGIN_PAGE, null);
//                                logoutAccount();
//                                finishActivity(0);
//                                finishAffinity();
//                                finish();
//                            }
//                        })
//                .setNegativeListener(getString(R.string.label_no),
//                        new iOSDialogClickListener() {
//                            @Override
//                            public void onClick(iOSDialog dialog) {
//                                dialog.dismiss();
//                            }
//                        })
//                .build().show();
//
//    }


//    public void get_countCardNumber() {
//        activityMainBinding.progressbar.setVisibility(View.VISIBLE);
//        CartRequest request = new CartRequest();
//        if (UserPreferenceHelper.getUserProfile() != null) {
//            request.setUser_id(String.valueOf(UserPreferenceHelper.getUserProfile().getId()));
//            request.setDevice_id("");
//            Log.e(TAG, "countCardNumber:1 " + request);
//        } else {
//            request.setUser_id("");
//            request.setDevice_id(getDeviceId());
//            Log.e(TAG, "countCardNumber:2" + request);
//
//        }
//
//        countViewModel.getCount(request);
//        countViewModel.getMutableLiveData().observe(this, new Observer<MutableHelper>() {
//            @Override
//            public void onChanged(MutableHelper mutableHelper) {
//                switch (mutableHelper.key) {
//                    case COUNT_SUCCESS:
//                        if ((((Count_Response) mutableHelper.value).getData().getCount()).equals(""))
//                            activityMainBinding.toolbarLy.actionBarCount.setVisibility(View.GONE);
//                        else {
//                            activityMainBinding.toolbarLy.actionBarCount.setVisibility(View.VISIBLE);
//                            activityMainBinding.toolbarLy.actionBarCount.setText((((Count_Response) mutableHelper.value).getData().getCount()));
//                        }
//                        break;
//                    case COUNT_FAILED:
//                    case COUNT_NOT_FOUND:
//                        MessagesManager.sToast(MainActivity.this, mutableHelper.value.toString());
//                        break;
//                    case Constants.NETWORK_CONNECTION_ERROR:
//                        MessagesManager.sToastNoServes(MainActivity.this, R.string.noServices);
//                        break;
//                }
//            }
//        });
//
//
//    }

    /**
     * @return DeviceId
     */
//    private String getDeviceId() {
//        @SuppressLint("HardwareIds")
//        String device_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
//        Log.d("TAG", "getDeviceId: " + device_id);
//        return device_id;
//    }


//    @Override
//    protected void onNewIntent(Intent intent) {
//        super.onNewIntent(intent);
//        setIntent(intent);
//
//        intent = getIntent();
//        if (intent != null) {
//
//            String extra = intent.getStringExtra("title");
//            if (extra != null) {
//                Log.e("NaviagteNotification", extra);
//
//                Navigation.findNavController(MainActivity.this, R.id.host_fragment).navigate(R.id.inboxFragment);
//
//
//            }
//
//        }
//    }
//
//    boolean isNotified;

//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        broadcastIntent();
//
//        Intent intent = getIntent();
//        if (intent != null && !isNotified) {
//
//            String inboxId = intent.getStringExtra("inboxId");
//            String type = intent.getStringExtra("type");
//
//            if (inboxId != null) {
//                Log.e("NaviagteNotification", inboxId + " / Type " + type);
//
//                Bundle bundle = new Bundle();
//                bundle.putInt(Constants.INBOX_ID, Integer.valueOf(inboxId));
//                bundle.putString(Constants.INBOX_TYPE, type);
//                isNotified = true;
//                Navigation.findNavController(MainActivity.this, R.id.host_fragment).navigate(R.id.detailsInboxFragment, bundle);
//
//            }
//
//        }
//
//
//    }

//    private void logoutAccount() {
//        activityMainBinding.progressbar.setVisibility(View.VISIBLE);
//        logoutViewModel.getLogoutData();
//        logoutViewModel.getMutableLiveData().observe((LifecycleOwner) this, new Observer<MutableHelper>() {
//            @Override
//            public void onChanged(MutableHelper mutableHelper) {
//                switch (mutableHelper.key) {
//                    case DELETE_SUCCESS:
//                        activityMainBinding.progressbar.setVisibility(View.GONE);
//                        MessagesManager.sToast(MainActivity.this, mutableHelper.value.toString());
//                        break;
//                    case DELETE_FAILED:
//                        MessagesManager.sToast(MainActivity.this, mutableHelper.value.toString());
//                        break;
//                    case DELETE_NOT_AUTHOIZE:
//                        activityMainBinding.progressbar.setVisibility(View.GONE);
//                        MessagesManager.sToast(MainActivity.this, mutableHelper.value.toString());
//                        MovementHelper.startBaseActivity(MainActivity.this,
//                                Constants.LOGIN_PAGE, "");
//                        clearUserProfile();
//                        break;
//                    case Constants.NETWORK_CONNECTION_ERROR:
//                        activityMainBinding.progressbar.setVisibility(View.GONE);
//                        MessagesManager.sToastNoServes(MainActivity.this, R.string.noServices);
//                        break;
//                }
//            }
//        });
//
//    }

//    public void bottomNavigation(int id) {
//        activityMainBinding.bottomNavigation.show(id, true);
//
//
//    }

// Tow Use UpdateApp
/*
	private void initRemoteConfig() {
		mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();

		//Setting the Default Map Value with the current app version code
		//default values are used for safety if on backend version_code is not set in remote config
		HashMap<String, Object> firebaseDefaultMap = new HashMap<>();
		firebaseDefaultMap.put(VERSION_CODE_KEY, getCurrentVersionCode());
		mFirebaseRemoteConfig.setDefaultsAsync(firebaseDefaultMap);

		//setMinimumFetchIntervalInSeconds to 0 during development to fast retrieve the values
		//in production set it to 12 which means checks for firebase remote config values for every 12 hours
		mFirebaseRemoteConfig.setConfigSettingsAsync(
				new FirebaseRemoteConfigSettings.Builder()
						.setMinimumFetchIntervalInSeconds(TimeUnit.HOURS.toSeconds(0))
						.build());

		//Fetching remote firebase version_code value here
		mFirebaseRemoteConfig.fetch().addOnCompleteListener(new OnCompleteListener<Void>() {
			@Override
			public void onComplete(@NonNull Task<Void> task) {
				if (task.isSuccessful()) {
					//activate most recently fetch config value
					mFirebaseRemoteConfig.activate().addOnCompleteListener(new OnCompleteListener<Boolean>() {
						@Override
						public void onComplete(@NonNull Task<Boolean> task) {
							if(task.isSuccessful()){
								//calling function to check if new version is available or not
								final int latestAppVersion = (int) mFirebaseRemoteConfig.getDouble(VERSION_CODE_KEY);
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										checkForUpdate(latestAppVersion);
									}
								});
							}
						}
					});
				}
			}
		});
	}

	private void checkForUpdate(int latestAppVersion) {
		if (latestAppVersion > getCurrentVersionCode()) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Update");
			builder.setMessage("New Version Available.\n"+"Please Update App");
			builder.setPositiveButtonIcon(getResources().getDrawable(R.drawable.ic_google_play));
			builder.setCancelable(false);
			builder.setPositiveButton("", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					goToPlayStore();
					updateDailog.dismiss();
				}
			});
			builder.setNegativeButton("", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					updateDailog.dismiss();
				}
			});
			// create and show the alert dialog
			updateDailog = builder.create();
			updateDailog.show();
		}
	}

	private int getCurrentVersionCode() {
		int versionCode=1;
		try {
			final PackageInfo pInfo = getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0);
			if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
				versionCode = (int) pInfo.getLongVersionCode();
			} else {
				versionCode = pInfo.versionCode;
			}
		} catch (PackageManager.NameNotFoundException e) {
			//log exception
		}
		return versionCode;
	}

	private void goToPlayStore() {
		try{
			startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id="+getPackageName())));
		}
		catch (ActivityNotFoundException e){
			startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
		}


	}
*/

//
//    public void UpdateApp() {
//        AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(this);
//        Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();
//        // Checks that the platform will allow the specified type of update.
//        appUpdateInfoTask.addOnSuccessListener(result -> {
//
//            if (result.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE) {
//                //    requestUpdate(result);
//
//                ContextThemeWrapper ctw = new ContextThemeWrapper(this, R.style.AlertDialogTheme);
//
//                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ctw);
//
//                alertDialogBuilder.setIcon(R.drawable.ic_google_play);
//                alertDialogBuilder.setTitle(R.string.update);
//                alertDialogBuilder.setCancelable(false);
//                alertDialogBuilder.setMessage(R.string.Update_Message);
//                alertDialogBuilder.setPositiveButton(R.string.update2, new OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        try {
//                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName())));
//                        } catch (ActivityNotFoundException e) {
//                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
//                        }
//                    }
//                });
//                alertDialogBuilder.setNegativeButton(R.string.No, new OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//
//                    }
//                });
//                alertDialogBuilder.show();
//
//            } else {
//
//
//            }
//
//        });
//    }
//
//    public void UpdateAppTwo() {
//
//
//        AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(this);
//        Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();
//        appUpdateInfoTask.addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>() {
//            @Override
//            public void onSuccess(AppUpdateInfo appUpdateInfo) {
//                if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
//                        && appUpdateInfo.isUpdateTypeAllowed(IMMEDIATE)) {
//                    try {
//                        appUpdateManager.startUpdateFlowForResult(appUpdateInfo, IMMEDIATE, MainActivity.this, REQUEST_CODE);
//                    } catch (IntentSender.SendIntentException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//
//
//            }
//        });
//
//
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            Toast.makeText(this, "Start Download", Toast.LENGTH_SHORT).show();
            if (resultCode != REQUEST_CODE) {
                Log.e("ve", "Update_flow_Failed" + resultCode);
                try {
                    String versionName = this.getPackageManager()
                            .getPackageInfo(this.getPackageName(), 0).versionName;
                    Toast.makeText(this, "Update_App" + versionName, Toast.LENGTH_SHORT).show();

                } catch (NameNotFoundException e) {
                    e.printStackTrace();
                }

            }

        }

    }


}
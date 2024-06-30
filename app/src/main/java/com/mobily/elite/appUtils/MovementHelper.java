package com.mobily.elite.appUtils;



import static com.mobily.elite.appUtils.Constants.AMOUNT;
import static com.mobily.elite.appUtils.Constants.KEY_ID;
import static com.mobily.elite.appUtils.Constants.POSITION;
import static com.mobily.elite.appUtils.Constants.PROJECT_ID;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.mobily.elite.R;
import com.mobily.elite.base.BaseActivity;
import com.mobily.elite.main.MainActivity;

import java.io.Serializable;


public class MovementHelper {


    //---------Fragments----------//

    public static void popAllFragments(Context context) {
        FragmentManager fm = ((FragmentActivity) context).getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
    }

    public static void addFragment(Context context, Fragment fragment, int activityType , String backStackText) {
        FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction().add(activityType, fragment)
                .setCustomAnimations(R.anim.silde_down, R.anim.silde_down,
                        android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right );
        if (!backStackText.equals("")) {
            fragmentTransaction.addToBackStack(backStackText);
        }
        fragmentTransaction.commit();
    }


    public static void replaceFragment(Context context, Fragment fragment, int activityType, String backStackText) {
        FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .replace(activityType, fragment);
        if (!backStackText.equals("")) {
            fragmentTransaction.addToBackStack(backStackText);
        }
        fragmentTransaction.commit();
    }


    public static void popLastFragment(Context context) {
        ((FragmentActivity) context).getSupportFragmentManager().popBackStack();
    }


    //-----------Activities-----------------//


    public static void startActivity(Context context, Class<?> activity, String bundle) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(Constants.INTENT_BUNDLE,bundle);
        context.startActivity(intent);
    }




    public static void startActivityForResult(Context context, Class<?> activity ,
                                              int requestCode, int page, String bundle) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(Constants.INTENT_PAGE,page);
        intent.putExtra(Constants.INTENT_BUNDLE,bundle) ;
        ((AppCompatActivity)context).startActivityForResult(intent,requestCode);
    }




    public static void startBaseActivity(Context context, int page, Object bundle) {
        Intent intent = new Intent(context, BaseActivity.class);
        intent.putExtra(Constants.INTENT_PAGE,page);
        intent.putExtra(Constants.INTENT_BUNDLE,(Serializable) bundle);
        context.startActivity(intent);

    }
    public static void startBaseForgetPass(Context context, int page, Object bundle, String phoneNumber) {
        Intent intent = new Intent(context, BaseActivity.class);
        intent.putExtra(Constants.INTENT_PAGE,page);
        intent.putExtra(Constants.INTENT_BUNDLE,(Serializable) bundle);
        intent.putExtra(Constants.phone_Number, phoneNumber);
        context.startActivity(intent);

    }




    public static void startMainActivity(Context context, int page) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(Constants.INTENT_PAGE, page);
        context.startActivity(intent);
    }


    public static void startMainActivity(Context context, int page,String token) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(Constants.INTENT_PAGE, page);
        intent.putExtra(Constants.TOKEN,token);
        context.startActivity(intent);
    }

    public static void startWebView(Context context, Class<?> activity, String id, int position) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(KEY_ID, id);
        intent.putExtra(POSITION, position);
        context.startActivity(intent);
    }

    public static void startWebView(Context context, Class<?> activity, int id, int position,String amount) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(PROJECT_ID, id);
        intent.putExtra(POSITION, position);
        intent.putExtra(AMOUNT, amount);
        context.startActivity(intent);
    }

    public static void startWebPage(Context context, String page) {
        try { context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(page)));
        } catch (Exception e){
            e.getStackTrace();
        }
    }
}

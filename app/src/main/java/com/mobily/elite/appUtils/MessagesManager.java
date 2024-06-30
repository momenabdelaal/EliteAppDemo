package com.mobily.elite.appUtils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chootdev.csnackbar.Align;
import com.chootdev.csnackbar.Duration;
import com.chootdev.csnackbar.Snackbar;
import com.chootdev.csnackbar.Type;

import java.util.Locale;


public class MessagesManager {

//    public static void fastDialog(final Activity activity, String title, String message) {
//        final AlertDialog.Builder builder =
//                new AlertDialog.Builder(activity);
//        builder.setTitle(title);
//        builder.setMessage(message).setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface d, int id) {
//            }
//        });
//        builder.create().show();
//    }

    public static void showErrorMessage(RelativeLayout errorLayout, ImageView imageView, TextView textMessage, int img, String message) {

        errorLayout.setVisibility(View.VISIBLE);

        imageView.setImageResource(img);
        textMessage.setText(message);

    }
    public static void lToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

    public static void sToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
    public static void sToastNoServes(Context context, int text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public static void dToast(Context context, String text, int duration) {
        Toast.makeText(context, text, duration).show();
    }

    public static void hideKeyboard(View view, Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager)
                context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    public static void makeCall(Context context, String number) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
        context.startActivity(intent);
    }

    public static void startWebPage(Context context, String page) {
        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(page)));
    }


    public static void shareUrl(String url, Context context){
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = url;
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Share");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        context.startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }





    public static void changeLanguage(Context context, String languageToLoad) {
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getResources().updateConfiguration(config,
                context.getResources().getDisplayMetrics());
//        UserPreferenceHelper.setLanguage(languageToLoad);
    }


    public static void showConnectionSnackBar (Context context, Type type, String message){
        Snackbar.with(context,null)
                .type(type)
                .message(message)
                .duration(Duration.SHORT)
                .fillParent(true)
                .textAlign(Align.CENTER)
                .show();


      //  Type.SUCCESS  // Green color alert to show ok, success, approved type functions
      //  Type.ERROR    // Red color alert to show error, failer type functions
      //  Type.UPDATE   // Grey color alert to show update take place, working type functions
      //  Type.WARNING  // Orange color alert to show alert type functions
      //  Type.CUSTOM   // This can use to set custom color as background


    }

    public static void showSnackbar(View view, String text){
        com.google.android.material.snackbar.Snackbar.make(view, text, 500).show();
    }



    public static void showSnackbarWithAction(View view, String text, int duration, String action){
        com.google.android.material.snackbar.Snackbar snackbar = com.google.android.material.snackbar.Snackbar.make(view, text, duration);
        snackbar.setAction(action, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             }
        });
        snackbar.show();
    }




}

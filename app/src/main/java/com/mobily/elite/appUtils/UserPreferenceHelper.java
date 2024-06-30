package com.mobily.elite.appUtils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import com.google.gson.Gson;
import com.mobily.elite.appUtils.Localization.LocaleHelper;


import java.util.Objects;


public class UserPreferenceHelper {
//
//    private static SharedPreferences sharedPreferences = null;
//
//    //here you can find shared preference operations like get saved data for user
//
//
//    private UserPreferenceHelper() {
//
//    }
//
//    public static SharedPreferences getSharedPreferenceInstance(Context context) {
//        if (sharedPreferences != null) return sharedPreferences;
//        return sharedPreferences = context.getSharedPreferences("savedData",
//                Context.MODE_PRIVATE);
//    }
//
//
//
//    public static void saveUserProfile(UserModel userProfile) {
//        SharedPreferences.Editor prefsEditor = getSharedPreferenceInstance(MyApplication
//                .getInstance().getApplicationContext()).edit();
//        Gson gson = new Gson();
//        String json = gson.toJson(userProfile);
//        prefsEditor.putString("userDetails", json);
//        prefsEditor.apply();
//    }
//
//    public static void clearUserProfile() {
//        SharedPreferences.Editor prefsEditor = getSharedPreferenceInstance
//                (MyApplication.getInstance().getApplicationContext()).edit();
//        prefsEditor.putString("userDetails", null);
//        prefsEditor.apply();
//    }
//
//     public static UserModel getUserProfile() {
//        Gson gson = new Gson();
//        String json = getSharedPreferenceInstance(MyApplication.getInstance().getApplicationContext())
//                .getString("userDetails", "");
//         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//             if(Objects.equals(json, ""))return null;
//         }
//         return gson.fromJson(json, UserModel.class);
//    }
//
//
//     public static boolean isLogined() {
//        return (getUserProfile() != null ) && (!getUserProfile().equals(""));
//    }

    /*public static void setLanguage(String language) {
        SharedPreferences userDetails = MyApplication.getInstance()
                .getSharedPreferences("languageData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = userDetails.edit();
        editor.putString("language", language);
        editor.apply();
    }

    public static String getCurrentLanguage() {
        SharedPreferences sharedPreferences = MyApplication.getInstance()
                .getSharedPreferences("languageData", Context.MODE_PRIVATE);
        return sharedPreferences.getString("language", "ar");
    }*/

    /**
     *
     * @param ctx
     * @return String
     */
    public static String getCurrentLanguage(Context ctx) {
        return LocaleHelper.getLanguage(ctx);
    }

    /**
     *
     * @param ctx
     * @return Boolean
     */
    public Boolean isArabicLanguage(Context ctx){
        if (LocaleHelper.getLanguage(ctx).equals("ar")){
            return true;
        }else return false;
    }





//        public static void saveFCMToken( String token) {
//        if (token == null || token.equals("")) {
//            return;
//        } else {
//            SharedPreferences.Editor editor = getSharedPreferenceInstance(MyApplication
//                    .getInstance()).edit();
//        editor.putString(MyApplication.getInstance().getApplicationContext()
//                .getString(R.string.FCM_TOKEN), token);
//            editor.apply();
//        }
//    }
//
//    public static String getFCMToken() {
//        String token =  getSharedPreferenceInstance(MyApplication.getInstance())
//                .getString(MyApplication.getInstance()
//                .getResources().getString(R.string.FCM_TOKEN), "");
//        assert token != null;
//        return token.length() < 1 ?"EmptyToken":token;
//    }
//
//
//    public static void clearFCMToken() {
//        SharedPreferences.Editor prefsEditor = getSharedPreferenceInstance
//                (MyApplication.getInstance()).edit();
//        prefsEditor.putString(MyApplication.getInstance().getApplicationContext()
//                .getString(R.string.FCM_TOKEN), null);
//        prefsEditor.apply();
//    }






}

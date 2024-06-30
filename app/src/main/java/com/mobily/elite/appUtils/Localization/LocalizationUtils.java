package com.mobily.elite.appUtils.Localization;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.DisplayMetrics;


import com.mobily.elite.appUtils.Constants;

import java.util.Locale;

public class LocalizationUtils {

    public static void setDefaultFontConfiguration(Context context) {
        try {
            Locale locale;
            if (LocaleHelper.getLanguage(context).equalsIgnoreCase("ar"))
                locale = new Locale(LocaleHelper.getLanguage(context), "SA");
            else
                locale = new Locale(LocaleHelper.getLanguage(context));
            Locale.setDefault(locale);
            Configuration configuration = context.getResources().getConfiguration();
            configuration.locale = locale;
            configuration.fontScale = (float) 1; //0.85 small size, 1 normal size, 1,15 big etc
            DisplayMetrics metrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(metrics);
            metrics.scaledDensity = configuration.fontScale * metrics.density;
            if (!Constants.densities.contains(metrics.density))
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    configuration.densityDpi = (int) (getDensity(context) * 160f);
                }
            context.getResources().updateConfiguration(configuration, metrics);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Float getDensity(Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        if (density >= 4.0) {
            return 4.0f;
        }
        if (density >= 3.0) {
            return 3.0f;
        }
        if (density >= 2.0) {
            return 2.0f;
        }
        if (density >= 1.5) {
            return 1.5f;
        }
        if (density >= 1.0) {
            return 1.0f;
        }
        return 0.75f;
    }

}

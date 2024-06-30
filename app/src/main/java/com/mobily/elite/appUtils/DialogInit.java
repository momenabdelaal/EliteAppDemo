package com.mobily.elite.appUtils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.WindowManager;

import com.mobily.elite.R;


/**
 * Created by Momen on 7/28/2021
 */
public class DialogInit {


    public static ProgressDialog createProgressDialog(Context mContext) {


        ProgressDialog dialog = new ProgressDialog(mContext);
        try {
            dialog.show();
        } catch (WindowManager.BadTokenException e) {

        }
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog);
        // dialog.setMessage(Message);
        return dialog;
    }
}

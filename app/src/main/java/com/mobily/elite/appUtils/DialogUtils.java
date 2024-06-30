package com.mobily.elite.appUtils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.mobily.elite.R;


class DialogUtils {

	public static Dialog createSimpleOkDialog(Context context, String title, String message, Object o) {
		return createSimpleOkDialog(context, title, message, null);
	}

	public static Dialog createSimpleOkDialog(Context context, String title, String message,
											  DialogInterface.OnClickListener okClickListener) {
		return createSimpleOkDialog(context, title, message,
				context.getString(R.string.app_name), okClickListener);
	}

	public static Dialog createSimpleOkDialog(Context context, String title, String message,
											  String okButtonText, DialogInterface.OnClickListener okClickListener) {
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(context)
				.setTitle(title)
				.setMessage(message)
				.setNeutralButton(okButtonText, okClickListener);
		return alertDialog.create();
	}

	public static ProgressDialog createProgressDialog(Context context, String message) {
		ProgressDialog progressDialog = new ProgressDialog(context);
		progressDialog.setMessage(message);
		return progressDialog;
	}


/*
	private void initDialog() {

		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View dialogView = inflater.inflate(R.layout.item_dialog, null);
		dialogBuilder.setView(dialogView);

		final AlertDialog show = dialogBuilder.show();
		show.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));


		TextView tv_employee_name = dialogView.findViewById(R.id.tv_employee_name);


		tv_employee_name.setText("employeeSettingsModelList.get(position).getName()");
		LinearLayout linerUpdate = dialogView.findViewById(R.id.linerUpdate);
		LinearLayout linerDelete = dialogView.findViewById(R.id.linerDelete);
		CardView cardView = dialogView.findViewById(R.id.parntCard);
		cardView.setCardBackgroundColor(UtilsColor.getRandomColorCode());

		Button buCancel = dialogView.findViewById(R.id.buCancel);

		linerDelete.setOnClickListener(view -> {

			show.dismiss();

		});
		linerUpdate.setOnClickListener(view -> {

			show.dismiss();
		});


		buCancel.setOnClickListener(view -> show.dismiss());


	}
*/






}

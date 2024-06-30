package com.mobily.elite.ui.home;



import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.chootdev.csnackbar.Type;
import com.mobily.elite.R;
import com.mobily.elite.appUtils.MessagesManager;
import com.mobily.elite.appUtils.OnItemClickListenerView;
import com.mobily.elite.appUtils.pagination.EndlessRecyclerViewScrollListener;
import com.mobily.elite.databinding.FragmentHomeBinding;
import com.mobily.elite.main.MainActivity;
import com.mobily.elite.ui.home.model.ModelData;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeFragment extends Fragment {

	public Context context;
	public Activity activity;
	FragmentHomeBinding binding;

	View rootView;
	HomeAdapter adapter;


	StaggeredGridLayoutManager layoutManager;


	@Override
	public void onAttach(@NonNull Context context) {
		super.onAttach(context);
		this.context = context;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e("FragmentStarted", "FragmentStarted");

		handleBackButtonCallback();


	}

	@Override
	public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

		init();
		return rootView;
	}


	public void init() {

		rootView = binding.getRoot();
	}


	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		activity = getActivity();
		((MainActivity) activity).activityMainBinding.clMainToolbarContainer.setVisibility(View.VISIBLE);

		setRecyclerViewCategory();

	}



	private void handleBackButtonCallback() {
		final OnBackPressedCallback callback = new OnBackPressedCallback(true) {
			@Override
			public void handleOnBackPressed() {
				getActivity().finish();

			}
		};
		requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
	}


	@SuppressLint("UseCompatLoadingForDrawables")
	private void setRecyclerViewCategory() {


		List<ModelData> listData =  new ArrayList<>();
		listData.add(new ModelData("te893","JONAVIC DALIDA AGCAOILI","DOMESTIC HELEPER",context.getResources().getDrawable(R.drawable.cv1),
				context.getResources().getDrawable(R.drawable.te893)));
		listData.add(new ModelData("te891","CARMELITA HALANG MAGHINAY","DOMESTIC HELEPER",context.getResources().getDrawable(R.drawable.cv2),
				context.getResources().getDrawable(R.drawable.te891)));
		listData.add(new ModelData("te897","MERRIAN BARBA JACABAN","DOMESTIC HELEPER",context.getResources().getDrawable(R.drawable.cv3),
				context.getResources().getDrawable(R.drawable.te897)));
		listData.add(new ModelData("te896","ELSA ANDRES VALDEZ","DOMESTIC HELEPER",context.getResources().getDrawable(R.drawable.cv4),
				context.getResources().getDrawable(R.drawable.te896)));
		listData.add(new ModelData("te902","MERLIE CASTOR CABANAS","DOMESTIC HELEPER",context.getResources().getDrawable(R.drawable.cv5),
				context.getResources().getDrawable(R.drawable.te902)));
		listData.add(new ModelData("te901","SHERIE ANN ABABA BARROGA","DOMESTIC HELEPER",context.getResources().getDrawable(R.drawable.cv6),
				context.getResources().getDrawable(R.drawable.te901)));
		listData.add(new ModelData("te904","JABETH PENUAGA ROSETE","DOMESTIC HELEPER",context.getResources().getDrawable(R.drawable.cv7),
				context.getResources().getDrawable(R.drawable.te904)));
		listData.add(new ModelData("te908","WILMA SENTO CAMANZO","DOMESTIC HELEPER",context.getResources().getDrawable(R.drawable.cv8),
				context.getResources().getDrawable(R.drawable.te908)));


		layoutManager = new StaggeredGridLayoutManager(2,
				StaggeredGridLayoutManager.VERTICAL);
		LayoutAnimationController animation = AnimationUtils
				.loadLayoutAnimation(context, R.anim.layout_animation);
		binding.rvCategory.setLayoutManager(layoutManager);
		binding.rvCategory.setLayoutAnimation(animation);
		adapter = new HomeAdapter(/* new ArrayList<>() */);
		binding.rvCategory.setAdapter(adapter);
		adapter.addList(listData);
		adapter.onItemClickListener = new OnItemClickListenerView() {
			@Override
			public void onItemClick(View view, int position) {
				showDialog(listData.get(position).getFullcv());
			}
		};




	}

	private void showDialog(Drawable fullcv) {
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
		LayoutInflater inflater =((Activity)context).getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.layout_dialog, null);
		dialogBuilder.setView(dialogView);

		TextView buSubmit = dialogView.findViewById(R.id.buSubmit);
		TextView buLater = dialogView.findViewById(R.id.buLater);
		LinearLayout lnCardTitle = dialogView.findViewById(R.id.lnCardTitle);

		dialogBuilder.setCancelable(false);
		AlertDialog	updateDialog = dialogBuilder.create();

		buSubmit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				MessagesManager.sToast(context,"DEMO");
			}
		});

		buLater.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				loadPhoto(fullcv,updateDialog);
			}
		});

		lnCardTitle.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				updateDialog.dismiss();
			}
		});

		updateDialog.show();

	}
	private void loadPhoto(Drawable urlimage,AlertDialog updateDialog) {
		updateDialog.dismiss();
		final Dialog dialog = new Dialog(context, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setCancelable(true);
		dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.image_layout,
				null);
		ImageView image = (ImageView) layout.findViewById(R.id.imageView);
		ImageView ivClose = (ImageView) layout.findViewById(R.id.ivClose);

		image.setImageDrawable(urlimage);

//		Glide.with(context)
//				.load(urlimage)
//				.into(image);

		dialog.setContentView(layout);
		dialog.show();

		ivClose.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				dialog.dismiss();
			}
		});
	}


}
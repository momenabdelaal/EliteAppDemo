package com.mobily.elite.ui.home;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.mobily.elite.R;
import com.mobily.elite.appUtils.MessagesManager;
import com.mobily.elite.databinding.FragmentCategoryBinding;
import com.mobily.elite.databinding.FragmentHomeBinding;
import com.mobily.elite.main.MainActivity;
import com.mobily.elite.ui.home.model.ModelData;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {

	public Context context;
	public Activity activity;
	FragmentCategoryBinding binding;

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
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_category, container, false);

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

		assert activity != null;
		((MainActivity) activity).activityMainBinding.clMainToolbarContainer.setVisibility(View.GONE);

		binding.linearHelper.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Navigation.findNavController(view).navigate(R.id.homeFragment, null);

			}
		});

		binding.linearJoin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				MessagesManager.sToast(context,"DEMO");
			}
		});


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



}
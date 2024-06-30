package com.mobily.elite.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.mobily.elite.R;
import com.mobily.elite.appUtils.OnItemClickListenerView;
import com.mobily.elite.databinding.ItemHomeRowBinding;
import com.mobily.elite.ui.home.model.ModelData;

import java.util.ArrayList;
import java.util.List;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder>  {

   // public List<HomeModel> itemList;
    Context context;
    List<ModelData> categoryDataList;
    public OnItemClickListenerView onItemClickListener;
    public HomeAdapter() {
       // this.itemList = itemList;
        categoryDataList =new ArrayList<>();

    }

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ItemHomeRowBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.item_home_row, viewGroup, false);

        context = viewGroup.getContext();

        return new HomeHolder(binding);

    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull final HomeHolder viewHolder, final int i) {

        ModelData modelData = categoryDataList.get(i);

        viewHolder.binding.ivCategory.setImageDrawable(modelData.getImage());
        viewHolder.binding.tvName.setText(modelData.getName());
        viewHolder.binding.tvJob.setText(modelData.getJobName());
//        CategoryModel model = categoryDataList.get(i);
//        viewHolder.binding.tvCategoryName.setText(model.getName());
//
//        RequestOptions requestOptions = new RequestOptions();
//    //    requestOptions.placeholder(R.color.base_color);
//        requestOptions.error(UtilsColor.getRandomDrawbleColor());
//       // requestOptions.override(500,200);
//        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
//
//       /* viewHolder.binding.itemView.setCardBackgroundColor(Color.TRANSPARENT);
//        viewHolder.binding.itemView.setCardElevation(0);*/
//         //ParntImage
//
//        Glide.with(context)
//                .load(model.getImage())
//                .apply(requestOptions)
//               //  .transition(DrawableTransitionOptions.withCrossFade())
//                .listener(new RequestListener<Drawable>() {
//                    @Override
//                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                         viewHolder.binding.prograssLoadPhoto.setVisibility(View.GONE);
//                        requestOptions.autoClone();
//                        requestOptions.clone();
//
//
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                        viewHolder.binding.prograssLoadPhoto.setVisibility(View.GONE);
//                        requestOptions.autoClone();
//                        requestOptions.clone();
//
//                        return false;
//                    }
//                })
//                .into(viewHolder.binding.ivCategory);
//
//
//
//        //childImge
//        Glide.with(context)
//                .load(model.getIcon()) // Uri of the picture
//                .into(viewHolder.binding.iconCategory);

        if (onItemClickListener != null) {
            viewHolder.itemView.setOnClickListener(v ->
                    onItemClickListener.onItemClick(v, i));
        }


    }

    @Override
    public int getItemCount() {
        return  categoryDataList.size();


    }

    public void addList(List<ModelData> list) {
        categoryDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void reset() {
        categoryDataList.clear();
        notifyDataSetChanged();
    }

    public List<ModelData> getList() {
        return categoryDataList;
    }
    public static class HomeHolder extends RecyclerView.ViewHolder {

        ItemHomeRowBinding binding;


        public HomeHolder(@NonNull ItemHomeRowBinding bindingView) {
            super(bindingView.getRoot());
            this.binding = bindingView;
        }

    }
}


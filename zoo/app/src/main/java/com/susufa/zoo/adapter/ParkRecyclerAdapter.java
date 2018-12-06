package com.susufa.zoo.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.susufa.zoo.R;
import com.susufa.zoo.dataModel.ParkIntro;
import com.susufa.zoo.dataModel.ParkIntrokHeader;
import com.susufa.zoo.dataModel.RecyclerBaseItem;
import com.susufa.zoo.dataModel.Vegetable;
import com.susufa.zoo.utils.CommonUtils;
import com.susufa.zoo.utils.ImageUtils;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public abstract class ParkRecyclerAdapter extends RecyclerBaseAdapter {
    public static final int HEADER_PARK_INTRO = 0;
    public static final int ITEM_PARK = 1;
    public static final int ITEM_VEGETABLE = 2;

    public ParkRecyclerAdapter(Activity activity, List<RecyclerBaseItem> list) {
        super(activity, list);
    }

    abstract public void onParkItemSelected(RecyclerBaseItem item);

    abstract public void onVegetableItemSelected(RecyclerBaseItem item);

    @Override
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder ret = null;
        View view;
        int layoutResId;
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);

        switch (viewType) {
            case HEADER_PARK_INTRO:
                layoutResId = R.layout.recyclerview_item_park_info_header;
                view = mLayoutInflater.inflate(layoutResId, null);
                lp.height = CommonUtils.dp2Px(mActivity, 500);
                view.setLayoutParams(lp);
                ret = new ParkHeaderViewHolder(view);
                break;

            case ITEM_PARK:
                layoutResId = R.layout.recyclerview_item_park_info;
                view = mLayoutInflater.inflate(layoutResId, null);
                lp.height = CommonUtils.dp2Px(mActivity, 120);
                view.setLayoutParams(lp);
                ret = new ParkItemViewHolder(view);
                break;

            case ITEM_VEGETABLE:
                layoutResId = R.layout.recyclerview_item_park_info;
                view = mLayoutInflater.inflate(layoutResId, null);
                lp.height = CommonUtils.dp2Px(mActivity, 120);
                view.setLayoutParams(lp);
                ret = new VegetableItemViewHolder(view);
                break;


        }

        return ret;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        RecyclerBaseItem item = getItem(position);
        switch (item.getLayoutType()) {
            case HEADER_PARK_INTRO:
                ((ParkHeaderViewHolder) holder).setItem((ParkIntrokHeader) getItem(position));
                break;

            case ITEM_PARK:
                ((ParkItemViewHolder) holder).setItem((ParkIntro) getItem(position));
                break;

            case ITEM_VEGETABLE:
                ((VegetableItemViewHolder) holder).setItem((Vegetable) getItem(position));
                break;
        }
    }

    private class ParkHeaderViewHolder extends RecyclerView.ViewHolder {
        private TextView tvParkIntro;
        private TextView tvParkCloseTime;
        private ImageView ivParkInfoHeader;
        private ParkIntrokHeader mParkIntroHeader;


        private ParkHeaderViewHolder(View itemView) {
            super(itemView);
            bindViews(itemView);
        }

        private void bindViews(View view) {
            tvParkIntro = view.findViewById(R.id.tvParkIntro);
            tvParkCloseTime = view.findViewById(R.id.tvParkCloseTime);
            ivParkInfoHeader = view.findViewById(R.id.ivParkInfoHeader);
        }

        private void setItem(ParkIntrokHeader parkIntroHeader) {
            mParkIntroHeader = parkIntroHeader;
            ParkIntro parkIntro = mParkIntroHeader.getParkIntro();
            if (mParkIntroHeader != null) {
                tvParkIntro.setText(parkIntro.getEName());
                tvParkCloseTime.setText(parkIntro.getEMemo());

                int picSize = CommonUtils.dp2Px(mActivity, 300);
                if (!CommonUtils.isAbsEmpty(parkIntro.getEPicUrl())) {
                    Picasso.get()
                            .load(parkIntro.getEPicUrl())
                            .noPlaceholder()
                            .resize(picSize, picSize)
                            .centerCrop()
                            .into(ivParkInfoHeader);
                }
            }

        }
    }


    private class ParkItemViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvPark;
        private TextView mTvParkDetail;
        private TextView mTvParkCloseTime;
        private ImageView mIvParkInfo;
        private ParkIntro mParkIntro;


        private ParkItemViewHolder(View itemView) {
            super(itemView);
            bindViews(itemView);
        }

        private void bindViews(View view) {
            mTvPark = view.findViewById(R.id.tvPark);
            mTvParkDetail = view.findViewById(R.id.tvParkDetail);
            mTvParkCloseTime = view.findViewById(R.id.tvParkCloseTime);
            mIvParkInfo = view.findViewById(R.id.ivParkInfo);
        }

        private void bindEvents() {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onParkItemSelected(mParkIntro);
                }
            });
        }

        private void setItem(ParkIntro parkIntro) {
            mParkIntro = parkIntro;
            if (parkIntro != null) {
                mTvPark.setText(parkIntro.getEName());
                mTvParkDetail.setText(parkIntro.getEInfo());
                mTvParkCloseTime.setText(parkIntro.getEMemo());

                int picSize = CommonUtils.dp2Px(mActivity, 100);
                int radius = CommonUtils.dp2Px(mActivity, 5);
                if (!CommonUtils.isAbsEmpty(parkIntro.getEPicUrl())) {
                    Picasso.get()
                            .load(parkIntro.getEPicUrl())
                            .transform(new ImageUtils.RoundedCornersTransform(radius))
                            .noPlaceholder()
                            .resize(picSize, picSize)
                            .centerCrop()
                            .into(mIvParkInfo);
                }
            }

            bindEvents();
        }
    }


    private class VegetableItemViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvVegetableName;
        private TextView mTvVegetableDetail;
        private ImageView mIvVegetable;
        private Vegetable mVegetable;


        private VegetableItemViewHolder(View itemView) {
            super(itemView);
            bindViews(itemView);
        }

        private void bindViews(View view) {
            mTvVegetableName = view.findViewById(R.id.tvPark);
            mTvVegetableDetail = view.findViewById(R.id.tvParkDetail);
            mIvVegetable = view.findViewById(R.id.ivParkInfo);
            view.findViewById(R.id.tvParkCloseTime).setVisibility(View.GONE);
        }

        private void bindEvents() {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onVegetableItemSelected(mVegetable);
                }
            });
        }

        private void setItem(Vegetable vegetable) {
            mVegetable = vegetable;
            if (mVegetable != null) {

                mTvVegetableName.setText(mVegetable.getFNameCh());
                mTvVegetableDetail.setText(mVegetable.getFFeature());

                int picSize = CommonUtils.dp2Px(mActivity, 100);
                int radius = CommonUtils.dp2Px(mActivity, 5);
                if (!CommonUtils.isAbsEmpty(vegetable.getFPic01Url())) {
                    Picasso.get()
                            .load(vegetable.getFPic01Url())
                            .transform(new ImageUtils.RoundedCornersTransform(radius))
                            .noPlaceholder()
                            .resize(picSize, picSize)
                            .centerCrop()
                            .into(mIvVegetable);
                }
            }

            bindEvents();
        }
    }
}

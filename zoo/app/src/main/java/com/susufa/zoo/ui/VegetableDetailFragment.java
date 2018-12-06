package com.susufa.zoo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.susufa.zoo.R;
import com.susufa.zoo.dataModel.Vegetable;
import com.susufa.zoo.utils.CommonUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class VegetableDetailFragment extends Fragment {
    private static final String BUNDLE_VEGETABLE = "vegetable";
    private Activity mActivity;
    private Vegetable mVegetable;
    private ImageView mIvVegetable;
    private TextView mVegetableInfo;

    static VegetableDetailFragment getInstance(Vegetable vegetable) {
        VegetableDetailFragment fragment = new VegetableDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(BUNDLE_VEGETABLE, vegetable);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vegetable_detail, container, false);
        mIvVegetable = view.findViewById(R.id.ivVegetable);
        mVegetableInfo = view.findViewById(R.id.tvVegetableInfo);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        bindEvents();
    }

    private void init() {
        mActivity = getActivity();
        if (getArguments() != null) {
            mVegetable = (Vegetable) getArguments().getSerializable(BUNDLE_VEGETABLE);
        }
    }

    private void bindEvents() {
        int picSize = CommonUtils.dp2Px(mActivity, 320);
        if (!CommonUtils.isAbsEmpty(mVegetable.getFPic01Url())) {
            Picasso.get()
                    .load(mVegetable.getFPic01Url())
                    .noPlaceholder()
                    .resize(picSize, picSize)
                    .centerCrop()
                    .into(mIvVegetable);
        }

        mActivity.setTitle(mVegetable.getFNameCh());

        String info = getString(R.string.location) + "\n" + mVegetable.getFLocation() + "\n\n"
                + getString(R.string.asKnown) + "\n" + mVegetable.getFAlsoKnown() + "\n\n"
                + getString(R.string.brief) + "\n" + mVegetable.getFBrief() + "\n\n"
                + getString(R.string.feature) + "\n" + mVegetable.getFFeature() + "\n\n"
                + getString(R.string.function) + "\n" + mVegetable.getFFunction() + "\n\n"
                + getString(R.string.update) + "\n" + mVegetable.getFUpdate() + "\n\n";

        mVegetableInfo.setText(info);
    }
}

package com.susufa.zoo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.susufa.zoo.R;
import com.susufa.zoo.adapter.ParkRecyclerAdapter;
import com.susufa.zoo.constants.Field;
import com.susufa.zoo.dataModel.ParkIntrokHeader;
import com.susufa.zoo.dataModel.RecyclerBaseItem;
import com.susufa.zoo.dataModel.Vegetable;
import com.susufa.zoo.interfaces.OnAPIListener;
import com.susufa.zoo.module.apiParams.InParamsVegetable;
import com.susufa.zoo.utils.APIUtils;
import com.susufa.zoo.utils.LogUtils;
import com.susufa.zoo.utils.StringUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ParkDetailFragment extends Fragment {
    private static final String TAG = ParkDetailFragment.class.getSimpleName();
    private static final String BUNDLE_PARK_INTRO_HEADER = "parkIntroHeader";

    private Activity mActivity;
    private RecyclerView mRvParkIntro;
    private FragmentManager mFragmentManager;
    private ParkRecyclerAdapter mParkRecyclerAdapter;
    private List<RecyclerBaseItem> mVegetableList;

    static ParkDetailFragment getInstance(ParkIntrokHeader parkIntroHeader) {
        ParkDetailFragment fragment = new ParkDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(BUNDLE_PARK_INTRO_HEADER, parkIntroHeader);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_park_detail, container, false);
        mRvParkIntro = view.findViewById(R.id.rvParkDetail);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        bindEvents();
    }

    @Override
    public void onStart() {
        super.onStart();
        pullVegetableInfo();
    }

    private void init() {
        mActivity = getActivity();
        mFragmentManager = getFragmentManager();
        mVegetableList = new ArrayList<>();
        if (getArguments() != null) {
            RecyclerBaseItem parkIntro = (RecyclerBaseItem) getArguments().getSerializable(BUNDLE_PARK_INTRO_HEADER);
            mVegetableList.add(parkIntro);
        }
    }

    private void bindEvents() {
        mRvParkIntro.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvParkIntro.setHasFixedSize(true);
        mRvParkIntro.setItemViewCacheSize(100);
        mRvParkIntro.setDrawingCacheEnabled(true);
        mRvParkIntro.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        mActivity.setTitle(((ParkIntrokHeader) mVegetableList.get(0)).getParkIntro().getEName());
    }

    private void setAdapter() {
        if (mParkRecyclerAdapter == null) {
            mParkRecyclerAdapter = new ParkRecyclerAdapter(mActivity, mVegetableList) {
                @Override
                public void onParkItemSelected(RecyclerBaseItem item) {

                }

                @Override
                public void onVegetableItemSelected(RecyclerBaseItem item) {
                    VegetableDetailFragment fragment = VegetableDetailFragment.getInstance((Vegetable) item);
                    mFragmentManager.beginTransaction().setCustomAnimations(
                            R.animator.fragment_slide_left_enter,
                            R.animator.fragment_slide_left_exit,
                            R.animator.fragment_slide_right_enter,
                            R.animator.fragment_slide_right_exit)
                            .add(R.id.container, fragment, VegetableDetailFragment.class.getSimpleName())
                            .addToBackStack(VegetableDetailFragment.class.getSimpleName())
                            .commit();

                }
            };
            mRvParkIntro.setAdapter(mParkRecyclerAdapter);
        } else {
            mParkRecyclerAdapter.setList(mVegetableList);
        }
    }

    private void pullVegetableInfo() {
        InParamsVegetable ip = new InParamsVegetable();
        APIUtils.request(mActivity, ip, new OnAPIListener() {
            @Override
            public void onError(int statusCode, String error) {

            }

            @Override
            public void onPreExecute() {
            }

            @Override
            public void onResponse(String encodeResponse) {
                if (encodeResponse != null) {
                    try {

                        String response = StringUtils.decodeUtf8String(encodeResponse);
                        JSONObject object = new JSONObject(response);

                        JSONArray vegetableJsonArray = object.getJSONObject(Field.RESULT).getJSONArray(Field.RESULTS);
                        Type listType = new TypeToken<List<Vegetable>>() {
                        }.getType();
                        List<RecyclerBaseItem> vegetableList = new Gson().fromJson(vegetableJsonArray.toString(), listType);

                        for (RecyclerBaseItem vegetable : vegetableList) {
                            vegetable.setLayoutType(ParkRecyclerAdapter.ITEM_VEGETABLE);
                        }

                        mVegetableList.addAll(vegetableList);
                        setAdapter();
                    } catch (JSONException e) {
                        LogUtils.e(TAG, e.toString());
                    }
                } else {
                    LogUtils.d(TAG, " onResponse Exception:");
                }
            }
        });
    }
}

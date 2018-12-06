package com.susufa.zoo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.susufa.zoo.R;
import com.susufa.zoo.dataModel.ParkIntrokHeader;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.FragmentManager;

public class ParkDetailActivity extends AppCompatActivity {
    private static final String TAG = ParkDetailActivity.class.getSimpleName();
    public static final String BUNDLE_PARK_INTRO_HEADER = "parkIntroHeader";

    private TextView mTvTitle;
    private FragmentManager mFm;
    private ParkIntrokHeader mParkIntroHeader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_detail);
        setToolBar();
        init();
        getIntentData();
        insertFragment();
        bindEvents();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        int count = mFm.getBackStackEntryCount();

        if (count > 1) {
            mFm.popBackStack();
        } else {
            Log.d(TAG, "onBackPressed cp 8");
            finish();
        }
    }

    private void bindEvents() {
        mFm.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if (mFm != null) {
                    int count = mFm.getBackStackEntryCount();
                    String fmName = count > 0 ? mFm.getBackStackEntryAt(count - 1).getName() : null;
                    if (fmName != null) {
                        if (fmName.contentEquals(ParkDetailFragment.class.getSimpleName())) {
                            mTvTitle.setText(mParkIntroHeader.getParkIntro().getEName());
                        }
                    }
                }
            }
        });
    }

    public void setTitle(CharSequence title) {
        mTvTitle.setText(title);
    }

    private void init() {
        mFm = getSupportFragmentManager();
    }

    private void getIntentData() {
        mParkIntroHeader = (ParkIntrokHeader) getIntent().getSerializableExtra(BUNDLE_PARK_INTRO_HEADER);
    }

    private void setToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar.getNavigationIcon() != null) {
            DrawableCompat.setTint(toolbar.getNavigationIcon(), getResources().getColor(R.color.color_ffffff));

            mTvTitle = new TextView(this);
            mTvTitle.setText(null);
            mTvTitle.setTextSize(18);
            mTvTitle.setTextColor(getResources().getColor(R.color.color_ffffff));


            Toolbar.LayoutParams lpTitle = new Toolbar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lpTitle.gravity = Gravity.CENTER_HORIZONTAL;
            toolbar.addView(mTvTitle, lpTitle);
            setSupportActionBar(toolbar);
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    private void insertFragment() {
        ParkDetailFragment fragment = ParkDetailFragment.getInstance(mParkIntroHeader);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, fragment, ParkDetailFragment.class.getSimpleName())
                .addToBackStack(ParkDetailFragment.class.getSimpleName())
                .commit();
    }

}

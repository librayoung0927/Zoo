package com.susufa.zoo.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.susufa.zoo.R;
import com.susufa.zoo.adapter.ParkRecyclerAdapter;
import com.susufa.zoo.constants.Field;
import com.susufa.zoo.dataModel.ParkIntro;
import com.susufa.zoo.dataModel.ParkIntrokHeader;
import com.susufa.zoo.dataModel.RecyclerBaseItem;
import com.susufa.zoo.interfaces.OnAPIListener;
import com.susufa.zoo.module.apiParams.InParamsParkIntro;
import com.susufa.zoo.utils.APIUtils;
import com.susufa.zoo.utils.LogUtils;
import com.susufa.zoo.utils.StringUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    private Activity mActivity;
    private RecyclerView mRvPark;
    private List<RecyclerBaseItem> mParkIntroList;
    private ParkRecyclerAdapter mParkRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        bindViews();
        bindEvents();
    }

    private void bindViews() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mRvPark = findViewById(R.id.rvPark);
    }

    private void bindEvents() {
        mRvPark.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvPark.setHasFixedSize(true);
        mRvPark.setItemViewCacheSize(20);
        mRvPark.setDrawingCacheEnabled(true);
        mRvPark.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
    }

    private void setAdapter() {
        if (mParkRecyclerAdapter == null) {
            mParkRecyclerAdapter = new ParkRecyclerAdapter(mActivity, mParkIntroList) {
                @Override
                public void onParkItemSelected(RecyclerBaseItem item) {

                    ParkIntrokHeader parkIntrokHeader = new ParkIntrokHeader();
                    parkIntrokHeader.setParkIntro((ParkIntro) item);

                    Intent intent = new Intent(mActivity, ParkDetailActivity.class);
                    intent.putExtra(ParkDetailActivity.BUNDLE_PARK_INTRO_HEADER, parkIntrokHeader);
                    startActivity(intent);
                }

                @Override
                public void onVegetableItemSelected(RecyclerBaseItem item) {

                }
            };
            mRvPark.setAdapter(mParkRecyclerAdapter);
        } else {
            mParkRecyclerAdapter.addAll(mParkIntroList);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        pullParkIntro();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void init() {
        mActivity = this;
        mParkIntroList = new ArrayList<>();
    }

    private void pullParkIntro() {
        InParamsParkIntro ip = new InParamsParkIntro();
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

                        JSONArray parkIntoJsonArray = object.getJSONObject(Field.RESULT).getJSONArray(Field.RESULTS);
                        Type listType = new TypeToken<List<ParkIntro>>() {
                        }.getType();
                        mParkIntroList = new Gson().fromJson(parkIntoJsonArray.toString(), listType);

                        for (RecyclerBaseItem parkIntro : mParkIntroList) {
                            parkIntro.setLayoutType(ParkRecyclerAdapter.ITEM_PARK);
                        }

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

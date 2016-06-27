package com.karson.portfolio.adnfeed.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.crashlytics.android.Crashlytics;
import com.karson.portfolio.adnfeed.R;
import com.karson.portfolio.adnfeed.adapter.AppNetMessageAdapter;
import com.karson.portfolio.adnfeed.model.AppNetRowData;
import com.karson.portfolio.adnfeed.service.AppNetService;

import net.danlew.android.joda.JodaTimeAndroid;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.fabric.sdk.android.Fabric;

public class AppNetStreamActivity extends AppCompatActivity {

    private static final String TAG = "AppNetSreamActivity";

    @BindView(R.id.message_card_list) RecyclerView messageCardList;

    @BindView(R.id.tool_bar) Toolbar toolbar;

    AppNetMessageAdapter adapter;

    boolean mBound = false;

    AppNetService.AppNetServiceBinder binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_net_stream);
        ButterKnife.bind(this);
        JodaTimeAndroid.init(this);
        Fabric.with(this, new Crashlytics());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        messageCardList.setLayoutManager(layoutManager);

        adapter = new AppNetMessageAdapter(new ArrayList<>());
        messageCardList.setAdapter(adapter);

        setSupportActionBar(toolbar);

        Intent intent = new Intent(this, AppNetService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_pause_resume) {
            Log.d(TAG, "Pause resume button clicked");
            if(mBound) {
                if(item.getTitle().equals(getString(R.string.toolbar_menu_pause))) {
                    item.setTitle(getString(R.string.toolbar_menu_resume));
                    item.setIcon(getResources().getDrawable(R.mipmap.ic_continue));
                    binder.pause();
                } else {
                    item.setTitle(getString(R.string.toolbar_menu_pause));
                    item.setIcon(getResources().getDrawable(R.mipmap.ic_pause));
                    binder.resume();
                }
            } else {
                Log.i(TAG, "Menu button clicked before service bound");
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Unbind from the service
        if (mBound) {
            unbindService(mConnection);
            mBound = false;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void doThis(List<AppNetRowData> appNetRowDataList) {
        adapter.addData(appNetRowDataList);
        messageCardList.getLayoutManager().scrollToPosition(0);
    }

    /**
     * Implement callbacks for service connect/disconnect
     */
    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            mBound = true;
            binder = (AppNetService.AppNetServiceBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
            binder = null;
        }
    };
}

package com.incture.sample.workbox;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.incture.sample.workbox.adapters.WorkLoadViewAdapter;
import com.incture.sample.workbox.models.UserWorkLoad;
import com.incture.sample.workbox.rest.RequestPackage;
import com.incture.sample.workbox.sample.SampleDataProvider;
import com.incture.sample.workbox.service.NetworkIntentService;
import com.incture.sample.workbox.utils.NetworkUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "http://115.110.225.49:50000/appone/pmc/userload/heatmap";

    private List<UserWorkLoad> mData = new ArrayList<>();// = SampleDataProvider.userWorkLoadList;

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            ArrayList<UserWorkLoad> dataItems = (ArrayList<UserWorkLoad>) intent.getBundleExtra(NetworkIntentService.MY_SERVICE_PAYLOAD).get("items");

            mData = dataItems;
            bindAdapter();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LocalBroadcastManager.getInstance(getApplicationContext())
                .registerReceiver(mBroadcastReceiver,
                        new IntentFilter(NetworkIntentService.MY_SERVICE_MESSAGE));


        if(NetworkUtil.hasNetworkAccess(this)){

            JSONObject jsonParam = new JSONObject();
            try {
                jsonParam.put("groupName", "ALL");
                jsonParam.put("labelName", "");
                jsonParam.put("processName", "ALL");
                jsonParam.put("requestId", "");
                jsonParam.put("askStatus", "OPEN");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            RequestPackage aPackage = new RequestPackage();
            aPackage.setEndPoint(JSON_URL);
            aPackage.setMethod("POST");
            aPackage.setRequestContentType("application/json");
            aPackage.setRequestPayload(jsonParam.toString());

            Intent intent = new Intent(this, NetworkIntentService.class);
            intent.putExtra(NetworkIntentService.REQUEST_PACKAGE, aPackage);
            startService(intent);
        } else{
            Toast.makeText(this, "Network not available!", Toast.LENGTH_SHORT).show();
        }


    }

    private void bindAdapter(){
        WorkLoadViewAdapter adapter = new WorkLoadViewAdapter(this, mData);
        RecyclerView workloadRecyclerView = findViewById(R.id.workload_recycler_view);
        workloadRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        workloadRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getApplicationContext())
                .unregisterReceiver(mBroadcastReceiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}

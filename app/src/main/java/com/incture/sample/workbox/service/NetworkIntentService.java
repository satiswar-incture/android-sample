package com.incture.sample.workbox.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;

import com.google.gson.Gson;
import com.incture.sample.workbox.models.UserWorkLoad;
import com.incture.sample.workbox.models.UserWorkloadDto;
import com.incture.sample.workbox.rest.NetworkHelper;
import com.incture.sample.workbox.rest.RequestPackage;
import com.incture.sample.workbox.sample.SampleDataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by satiswardash on 24/11/17.
 */

public class NetworkIntentService extends IntentService{
    public static final String TAG = "workbox_network_service";
    public static final String MY_SERVICE_MESSAGE = "myServiceMessage";
    public static final String MY_SERVICE_PAYLOAD = "myServicePayload";
    public static final String REQUEST_PACKAGE = "requestPackage";

    public NetworkIntentService() {
        super("workbox_network_service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        RequestPackage requestPackage =
                intent.getParcelableExtra(REQUEST_PACKAGE);

        String response = "";
        ArrayList<UserWorkLoad> dataItems = null;
        try {
            //Thread.sleep(3000);
            //dataItems = SampleDataProvider.userWorkLoadList;

            response = NetworkHelper.downloadFromFeed(requestPackage);

        } catch (IOException e) {
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }

        UserWorkloadDto items = null;
        try{

            Gson gson = new Gson();
            items = gson.fromJson(response, UserWorkloadDto.class);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        dataItems = (ArrayList<UserWorkLoad>) items.getUserWorkloadDto();


        Intent messageIntent = new Intent(MY_SERVICE_MESSAGE);
        Bundle b = new Bundle();
        b.putParcelableArrayList("items", dataItems);
        messageIntent.putExtra(MY_SERVICE_PAYLOAD, b);
        LocalBroadcastManager manager =
                LocalBroadcastManager.getInstance(getApplicationContext());
        manager.sendBroadcast(messageIntent);
    }

}

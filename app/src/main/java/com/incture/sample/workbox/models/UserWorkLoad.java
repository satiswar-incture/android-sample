package com.incture.sample.workbox.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

public class UserWorkLoad implements Parcelable {

    private String userId;
    private String userName;
    private String userGroup;
    private String noOfTask;

    public UserWorkLoad() {
        initUUID();
    }

    private void initUUID() {

    }

    public UserWorkLoad(String workloadId, String userId, String userName, String userGroup, String noOfTasks) {


        this.userId = userId;
        this.userName = userName;
        this.userGroup = userGroup;
        this.noOfTask = noOfTasks;
    }



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public String getNoOfTasks() {
        return noOfTask;
    }

    public void setNoOfTasks(String noOfTasks) {
        this.noOfTask = noOfTasks;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userId);
        dest.writeString(this.userName);
        dest.writeString(this.userGroup);
        dest.writeString(this.noOfTask);
    }

    protected UserWorkLoad(Parcel in) {
        this.userId = in.readString();
        this.userName = in.readString();
        this.userGroup = in.readString();
        this.noOfTask = in.readString();
    }

    public static final Parcelable.Creator<UserWorkLoad> CREATOR = new Parcelable.Creator<UserWorkLoad>() {
        @Override
        public UserWorkLoad createFromParcel(Parcel source) {
            return new UserWorkLoad(source);
        }

        @Override
        public UserWorkLoad[] newArray(int size) {
            return new UserWorkLoad[size];
        }
    };
}

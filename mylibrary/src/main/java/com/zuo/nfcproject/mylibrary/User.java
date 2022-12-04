package com.zuo.nfcproject.mylibrary;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022-11-28 0:11
 * Description:
 */
public class User implements Parcelable {
    private String Id;
    private String Name;
    private String age;


    protected User(Parcel in) {
        Id = in.readString();
        Name = in.readString();
        age = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Id);
        parcel.writeString(Name);
        parcel.writeString(age);
    }
}

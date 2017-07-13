package com.kishan.smsapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jeevan on 7/13/2017.
 */

public class SmsHistoryInfo implements Parcelable {
    private String name;
    private String contactNo;
    private String msg;
    private String timeStamp;

    public SmsHistoryInfo() {
    }


    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public SmsHistoryInfo(String name, String contactNo, String msg) {
        this.name = name;
        this.contactNo = contactNo;
        this.msg = msg;
    }

    public SmsHistoryInfo(String name, String contactNo, String msg, String timeStamp) {
        this.name = name;
        this.contactNo = contactNo;
        this.msg = msg;
        this.timeStamp = timeStamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static Creator<SmsHistoryInfo> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.contactNo);
        dest.writeString(this.msg);
        dest.writeString(this.timeStamp);
    }

    protected SmsHistoryInfo(Parcel in) {
        this.name = in.readString();
        this.contactNo = in.readString();
        this.msg = in.readString();
        this.timeStamp = in.readString();
    }

    public static final Creator<SmsHistoryInfo> CREATOR = new Creator<SmsHistoryInfo>() {
        @Override
        public SmsHistoryInfo createFromParcel(Parcel source) {
            return new SmsHistoryInfo(source);
        }

        @Override
        public SmsHistoryInfo[] newArray(int size) {
            return new SmsHistoryInfo[size];
        }
    };
}

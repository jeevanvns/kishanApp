package com.kishan.smsapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jeevan on 13-07-2017.
 */

public class ContactInfo implements Parcelable {
    private String firstName;
    private String lastName;
    private String contactNo;

    public ContactInfo(String firstName, String lastName, String contactNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.contactNo);
    }

    protected ContactInfo(Parcel in) {
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.contactNo = in.readString();
    }

    public static final Parcelable.Creator<ContactInfo> CREATOR = new Parcelable.Creator<ContactInfo>() {
        @Override
        public ContactInfo createFromParcel(Parcel source) {
            return new ContactInfo(source);
        }

        @Override
        public ContactInfo[] newArray(int size) {
            return new ContactInfo[size];
        }
    };
}
